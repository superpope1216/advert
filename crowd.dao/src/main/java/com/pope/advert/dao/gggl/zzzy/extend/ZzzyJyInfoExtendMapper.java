package com.pope.advert.dao.gggl.zzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.zzzy.ZzzyJyInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyJyInfoExtend;

public interface ZzzyJyInfoExtendMapper {
	List<ZzzyJyInfoExtend> selectByCondition(QueryCondition<ZzzyJyInfoExtend> condition);
	
	Integer deleteByZzzyId(@Param("zzzyId") String zzzyId);
}