package com.pope.advert.dao.gggl.bzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyXbmggInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyXbmggInfoExtend;

public interface BzzyXbmggInfoExtendMapper {
	List<BzzyXbmggInfoExtend> selectByCondition(QueryCondition<BzzyXbmggInfoExtend> condition);

	List<BzzyXbmggInfoExtend> selectDisplayByCondition(QueryCondition<BzzyXbmggInfoExtend> condition);
	Integer deleteByBzzyId(@Param("bzzyId") String bzzyId);
}