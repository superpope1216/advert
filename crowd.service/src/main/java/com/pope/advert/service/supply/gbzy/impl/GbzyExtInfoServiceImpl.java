package com.pope.advert.service.supply.gbzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.gbzy.GbzyExtInfoMapper;
import com.pope.advert.dao.gggl.gbzy.extend.GbzyExtInfoExtendMapper;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("gbzyExtInfoService")
public class GbzyExtInfoServiceImpl implements GbzyExtInfoService {

	@Autowired
	private GbzyExtInfoMapper gbzyExtInfoMapper;
	@Autowired
	private GbzyExtInfoExtendMapper gbzyExtInfoExtendMapper;
	
	@Autowired
	private DictionaryService dictionaryService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(GbzyExtInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<GbzyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(GbzyExtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<GbzyExtInfoExtend>> selectByCondition(QueryCondition<GbzyExtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<GbzyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<GbzyExtInfoExtend> datas = gbzyExtInfoExtendMapper.selectByCondition(condition);

			DataResult<List<GbzyExtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(gbzyExtInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByGbzyId(String gbzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyExtInfoExtendMapper.deleteByGbzyId(gbzyId));
	}
	

private void getHy(List<GbzyExtInfoExtend> datas){
	List<DictionaryInfo> hyList=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_HY);
	if(CommonUtil.isNotEmptyList(datas)){
		for(GbzyExtInfoExtend gbzyExtInfoExtend:datas){
			if(!StringUtil.isEmpty(gbzyExtInfoExtend.getHy())){
				String[] hy=gbzyExtInfoExtend.getHy().split(",");
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
				gbzyExtInfoExtend.setHyDisplay(hyDisplay);
				
			}
		}
	}
} 

	@Override
	public DataResult<List<GbzyExtInfoExtend>> selectDisplayByCondition(QueryCondition<GbzyExtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<GbzyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<GbzyExtInfoExtend> datas = gbzyExtInfoExtendMapper.selectDisplayByCondition(condition);
			getHy(datas);
			DataResult<List<GbzyExtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			List<GbzyExtInfoExtend> datas = gbzyExtInfoExtendMapper.selectDisplayByCondition(condition);
			getHy(datas);
			return DataResult.success(datas);

		}
	}
	
}
