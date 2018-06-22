package com.pope.advert.dao.gggl.zzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyInfoExtend;

public interface ZzzyExtInfoExtendMapper {
	List<ZzzyExtInfoExtend> selectByCondition(QueryCondition<ZzzyExtInfoExtend> condition);
	
	List<ZzzyExtInfoExtend> selectDisplayByCondition(QueryCondition<ZzzyExtInfoExtend> condition);
	Integer deleteByZzzyId(@Param("dszyId") String dszyId);
}