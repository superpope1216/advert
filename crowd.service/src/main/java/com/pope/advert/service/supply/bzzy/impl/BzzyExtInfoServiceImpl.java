package com.pope.advert.service.supply.bzzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.bzzy.BzzyExtInfoMapper;
import com.pope.advert.dao.gggl.bzzy.extend.BzzyExtInfoExtendMapper;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyExtInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("bzzyExtInfoService")
public class BzzyExtInfoServiceImpl implements BzzyExtInfoService {

	@Autowired
	private BzzyExtInfoMapper bzzyExtInfoMapper;
	
	@Autowired
	private BzzyExtInfoExtendMapper bzzyExtInfoExtendMapper;

@Autowired
private DictionaryService dictionaryService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(BzzyExtInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<BzzyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(BzzyExtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<BzzyExtInfoExtend>> selectByCondition(QueryCondition<BzzyExtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<BzzyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<BzzyExtInfoExtend> datas = bzzyExtInfoExtendMapper.selectByCondition(condition);

			DataResult<List<BzzyExtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(bzzyExtInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByBzzyId(String bzzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyExtInfoExtendMapper.deleteByBzzyId(bzzyId));
	}


private void getHy(List<BzzyExtInfoExtend> datas){
	List<DictionaryInfo> hyList=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_HY);
	if(CommonUtil.isNotEmptyList(datas)){
		for(BzzyExtInfoExtend bzzyExtInfoExtend:datas){
			if(!StringUtil.isEmpty(bzzyExtInfoExtend.getHy())){
				String[] hy=bzzyExtInfoExtend.getHy().split(",");
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
				bzzyExtInfoExtend.setHyDisplay(hyDisplay);
				
			}
		}
	}
} 
	@Override
	public DataResult<List<BzzyExtInfoExtend>> selectDisplayByCondition(QueryCondition<BzzyExtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<BzzyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<BzzyExtInfoExtend> datas = bzzyExtInfoExtendMapper.selectDisplayByCondition(condition);
			getHy(datas);
			DataResult<List<BzzyExtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			List<BzzyExtInfoExtend> datas =bzzyExtInfoExtendMapper.selectDisplayByCondition(condition);
			getHy(datas);
			return DataResult.success(datas);

		}
	}

	
}
