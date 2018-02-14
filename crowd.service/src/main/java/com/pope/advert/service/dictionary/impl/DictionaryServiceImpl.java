package com.pope.advert.service.dictionary.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.dictionary.extend.DictionaryInfoExtendMapper;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.code.DictionaryEnum;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryInfoExtendMapper dictionaryInfoExtendMapper;
	@Override
	public List<DictionaryInfo> selectAllByTable(DictionaryEnum dictionaryEnum) throws ServiceException {
		return dictionaryInfoExtendMapper.selectAllByTable(dictionaryEnum.getCode());
	}

	@Override
	public List<DictionaryInfo> selectByCondtion(DictionaryEnum dictionaryEnum, DictionaryInfo dictionary) throws ServiceException {
	
		return dictionaryInfoExtendMapper.selectByCondtion(dictionaryEnum.getCode(), dictionary);
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectFbxxByCondition(String xmbh) throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectFbxxByCondition(xmbh));
	}

	@Override
	public Map<String, Object> selectRwxsByBm(String bm) throws ServiceException {
		return dictionaryInfoExtendMapper.selectRwxsByBm(bm);
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectAreaByClassify(String classifyId, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectAreaByClassify(classifyId));
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectAreaByParent(String parentBm, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectAreaByParent(parentBm));
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectDst(String areaBm, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectDst(areaBm));
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectSdpdByDst(String dstBm, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectSdpdByDst(dstBm));
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectDllmByPdbm(String pdId, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectDllmByPdbm(pdId));
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectGbdstByAreabm(String areaBm, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectGbdstByAreabm(areaBm));
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectGbdstpdByGbdstBm(String gbdstBm, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectGbdstpdByGbdstBm(gbdstBm));
	}

	@Override
	public DataResult<List<DictionaryInfo>> selectByAreaBm(String tableName, String areaBm, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dictionaryInfoExtendMapper.selectByAreaBm(tableName,areaBm));
	}

}
