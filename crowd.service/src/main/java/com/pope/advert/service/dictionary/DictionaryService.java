package com.pope.advert.service.dictionary;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface DictionaryService {

	List<DictionaryInfo> selectAllByTable(DictionaryEnum dictionaryEnum)  throws ServiceException;
	
	List<DictionaryInfo> selectByCondtion(DictionaryEnum dictionaryEnum, DictionaryInfo dictionary) throws ServiceException;
	
	DataResult<List<DictionaryInfo>> selectFbxxByCondition(String xmbh) throws ServiceException;
	
	Map<String,Object> selectRwxsByBm(String bm) throws ServiceException;
	
	DataResult<List<DictionaryInfo>> selectAreaByClassify(String classifyId,CustomOperateLog log) throws ServiceException;
	
	DataResult<List<DictionaryInfo>> selectAreaByParent( String parentBm,CustomOperateLog log) throws ServiceException;
	
	/**
	 * 根据地区编码获取电视台
	 * @param areaBm
	 * @param log
	 * @return
	 * @throws ServiceException
	 */
	DataResult<List<DictionaryInfo>> selectDst(String areaBm,CustomOperateLog log) throws ServiceException;
	/**
	 * 根据电视台获取时段频道
	 * @param dstBm
	 * @param log
	 * @return
	 * @throws ServiceException
	 */
	DataResult<List<DictionaryInfo>> selectSdpdByDst(String dstBm,CustomOperateLog log) throws ServiceException;
	
	/**
	 * 根据栏目频道获取代理栏目
	 * @param pdId
	 * @return
	 */
	DataResult<List<DictionaryInfo>> selectDllmByPdbm(String pdId,CustomOperateLog log) throws ServiceException;
	
	/**
	 * 根据区域编码获取广播电台
	 */
	DataResult<List<DictionaryInfo>> selectGbdstByAreabm(String areaBm,CustomOperateLog log) throws ServiceException;
	/**
	 * 根据广播电台获取时段
	 */
	DataResult<List<DictionaryInfo>> selectGbdstpdByGbdstBm(String gbdstBm,CustomOperateLog log) throws ServiceException;
	
	DataResult<List<DictionaryInfo>> selectByAreaBm(String tableName,String areaBm,CustomOperateLog log) throws ServiceException;
	
	
	DataResult<List<DictionaryInfo>>  selectZsfsByZsxt(String zsxt,CustomOperateLog log) throws ServiceException;
	
	DataResult<List<DictionaryInfo>>  selectZsccByZsxt(String zsxt,CustomOperateLog log) throws ServiceException;
	
	
	DataResult<List<DictionaryInfo>>  selectHwzyQyByGglx(String gglx,CustomOperateLog log) throws ServiceException;
	
	DataResult<List<DictionaryInfo>> selectHwzyXsByGglx( String gglx,CustomOperateLog log) throws ServiceException;
	
	DataResult<List<DictionaryInfo>> selectHwzyGgxx(String gglx,String area,String city,String xian,CustomOperateLog log) throws ServiceException;
}
