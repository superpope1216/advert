package com.pope.advert.dao.dictionary.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dictionary.DictionaryInfo;


public interface DictionaryInfoExtendMapper {
	public List<DictionaryInfo> selectAllByTable(@Param("tableName")String tableName);
	
	public List<DictionaryInfo> selectByCondtion(@Param("tableName")String tableName,@Param("dictionary")DictionaryInfo dictionary);
	
	/**
	 * 查询产品线信息
	 * @param dictionary
	 * @return
	 */
	public List<DictionaryInfo> selectBmByCondition(@Param("tableName")String tableName,@Param("dictionary") DictionaryInfo dictionary);
	
	
	List<DictionaryInfo> selectFbxxByCondition(@Param("xmbh") String xmbh);
	
	Map<String,Object> selectRwxsByBm(@Param("bm") String bm);
	
	List<DictionaryInfo> selectAreaByClassify(@Param("classifyId") String classifyId);
	
	List<DictionaryInfo> selectAreaByParent(@Param("parentBm")String parentBm);
	
	List<DictionaryInfo> selectDst(@Param("areaBm")String areaBm);
	
	List<DictionaryInfo> selectSdpdByDst(@Param("dstBm")String dstBm);
	
	List<DictionaryInfo> selectDllmByPdbm(@Param("pdId")String pdId);
	
	List<DictionaryInfo> selectGbdstByAreabm(@Param("areaBm")String areaBm);
	
	List<DictionaryInfo> selectGbdstpdByGbdstBm(@Param("gbdstBm")String gbdstBm);
	
	List<DictionaryInfo> selectByAreaBm(@Param("tableName") String tableName,@Param("areaBm") String areaBm);
	
	
	List<DictionaryInfo>  selectZsfsByZsxt(@Param("zsxt") String zsxt);
	
	List<DictionaryInfo>  selectZsccByZsxt(@Param("zsxt") String zsxt);
	
	List<DictionaryInfo>  selectHwzyQyByGglx(@Param("gglx") String gglx);
	
	List<DictionaryInfo>  selectHwzyXsByGglx(@Param("gglx") String gglx);
	
	List<DictionaryInfo> selectHwzyGgxx(@Param("gglx") String gglx,@Param("area") String area,@Param("city") String city,@Param("xian") String xian);

}