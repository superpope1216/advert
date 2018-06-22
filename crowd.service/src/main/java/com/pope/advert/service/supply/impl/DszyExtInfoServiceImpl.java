package com.pope.advert.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.DszyExtInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyExtInfoExtendMapper;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.extend.CompanyZzInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("dszyExtInfoService")
public class DszyExtInfoServiceImpl implements DszyExtInfoService {
@Autowired
	private DszyExtInfoMapper dszyExtInfoMapper;

@Autowired
private DszyExtInfoExtendMapper dszyExtInfoExtendMapper;

@Autowired
private DictionaryService dictionaryService;

@Override
public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.deleteByPrimaryKey(wid));
}

@Override
public DataResult<Integer> insertSelective(DszyExtInfo record, CustomOperateLog log) throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.insertSelective(record));
}

@Override
public DataResult<DszyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.selectByPrimaryKey(wid));
}

@Override
public DataResult<Integer> updateByPrimaryKeySelective(DszyExtInfo record, CustomOperateLog log)
		throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.updateByPrimaryKeySelective(record));
}

@Override
public DataResult<List<DszyExtInfoExtend>> selectByCondition(QueryCondition<DszyExtInfoExtend> condition,
		CustomOperateLog log) throws ServiceException {
	if (condition.getPageInfo() != null) {
		Page<DszyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
				condition.getPageInfo().getPageSize());
		List<DszyExtInfoExtend> datas = dszyExtInfoExtendMapper.selectByCondition(condition);

		DataResult<List<DszyExtInfoExtend>> dataResult = DataResult.success(datas);
		dataResult.setPageInfo(PageUtil.changePageInfo(page));
		return dataResult;
	} else {
		return DataResult.success(dszyExtInfoExtendMapper.selectByCondition(condition));

	}
}

@Override
public DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException {
	return DataResult.success(dszyExtInfoExtendMapper.deleteByDszyId(dszyId));
}


private void getHy(List<DszyExtInfoExtend> datas){
	List<DictionaryInfo> hyList=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_HY);
	if(CommonUtil.isNotEmptyList(datas)){
		for(DszyExtInfoExtend dszyExtInfoExtend:datas){
			if(!StringUtil.isEmpty(dszyExtInfoExtend.getHy())){
				String[] hy=dszyExtInfoExtend.getHy().split(",");
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
				dszyExtInfoExtend.setHyDisplay(hyDisplay);
				
			}
		}
	}
}
@Override
public DataResult<List<DszyExtInfoExtend>> selectDisplayByCondition(QueryCondition<DszyExtInfoExtend> condition,
		CustomOperateLog log) throws ServiceException {
	if (condition.getPageInfo() != null) {
		Page<DszyExtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
				condition.getPageInfo().getPageSize());
		List<DszyExtInfoExtend> datas = dszyExtInfoExtendMapper.selectDisplayByCondition(condition);
		getHy(datas);
		DataResult<List<DszyExtInfoExtend>> dataResult = DataResult.success(datas);
		
		dataResult.setPageInfo(PageUtil.changePageInfo(page));
		return dataResult;
	} else {
		List<DszyExtInfoExtend> datas=dszyExtInfoExtendMapper.selectDisplayByCondition(condition);
		getHy(datas);
		return DataResult.success(datas);

	}
	
	
} 
	 
}
