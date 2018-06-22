package com.pope.advert.service.supply.zzzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.zzzy.ZzzyExtInfoMapper;
import com.pope.advert.dao.gggl.zzzy.extend.ZzzyExtInfoExtendMapper;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("zzzyExtInfoService")
public class ZzzyExtInfoServiceImpl implements ZzzyExtInfoService{
	@Autowired
	private ZzzyExtInfoMapper zzzyExtInfoMapper;
	@Autowired
	private ZzzyExtInfoExtendMapper zzzyExtInfoExtendMapper;
	@Autowired
	private DictionaryService dictionaryService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZzzyExtInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZzzyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZzzyExtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<ZzzyExtInfoExtend>> selectByCondition(QueryCondition<ZzzyExtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<ZzzyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<ZzzyExtInfoExtend> datas = zzzyExtInfoExtendMapper.selectByCondition(condition);

			DataResult<List<ZzzyExtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(zzzyExtInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByGbzyId(String zzzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyExtInfoExtendMapper.deleteByZzzyId(zzzyId));
	}


private void getHy(List<ZzzyExtInfoExtend> datas){
	List<DictionaryInfo> hyList=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_HY);
	if(CommonUtil.isNotEmptyList(datas)){
		for(ZzzyExtInfoExtend zzzyExtInfoExtend:datas){
			if(!StringUtil.isEmpty(zzzyExtInfoExtend.getHy())){
				String[] hy=zzzyExtInfoExtend.getHy().split(",");
				String hyDisplay="";
				for(String s:hy){
					if(CommonUtil.isNotEmptyList(hyList)){
						for(DictionaryInfo _hy:hyList){
							if(s.equals(_hy.getLbdm())){
								hyDisplay+=","+_hy.getLbmc();
								 break;
							}
						}
					}
					
				}
				if(!StringUtil.isEmpty(hyDisplay)){
					hyDisplay=hyDisplay.substring(1);
				}
				zzzyExtInfoExtend.setHyDisplay(hyDisplay);
				
			}
		}
	}
}
	@Override
	public DataResult<List<ZzzyExtInfoExtend>> selectDisplayByCondition(QueryCondition<ZzzyExtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<ZzzyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<ZzzyExtInfoExtend> datas = zzzyExtInfoExtendMapper.selectDisplayByCondition(condition);
			getHy(datas);
			DataResult<List<ZzzyExtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			List<ZzzyExtInfoExtend> datas = zzzyExtInfoExtendMapper.selectDisplayByCondition(condition);
			getHy(datas);
			return DataResult.success(datas);

		}
	}
}
