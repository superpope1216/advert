package com.pope.advert.dao.gggl.zzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.zzzy.ZzzyGsygInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyGsygInfoExtend;

public interface ZzzyGsygInfoExtendMapper {
	List<ZzzyGsygInfoExtend> selectByCondition(QueryCondition<ZzzyGsygInfoExtend> condition);
	
	Integer deleteByZzzyId(@Param("zzzyId") String zzzyId);
}