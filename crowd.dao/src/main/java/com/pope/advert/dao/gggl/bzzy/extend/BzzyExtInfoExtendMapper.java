package com.pope.advert.dao.gggl.bzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;

public interface BzzyExtInfoExtendMapper {
	List<BzzyExtInfoExtend> selectByCondition(QueryCondition<BzzyExtInfoExtend> condition);

	List<BzzyExtInfoExtend> selectDisplayByCondition(QueryCondition<BzzyExtInfoExtend> condition);

	Integer deleteByBzzyId(@Param("bzzyId") String bzzyId);
}