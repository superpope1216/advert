package com.pope.advert.dao.gggl.zzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.zzzy.ZzzyRwInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyJyInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyRwInfoExtend;

public interface ZzzyRwInfoExtendMapper {
	List<ZzzyRwInfoExtend> selectByCondition(QueryCondition<ZzzyRwInfoExtend> condition);
	
	Integer deleteByZzzyId(@Param("zzzyId") String zzzyId);
}