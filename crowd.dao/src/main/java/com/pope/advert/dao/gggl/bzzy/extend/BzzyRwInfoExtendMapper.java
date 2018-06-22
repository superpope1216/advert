package com.pope.advert.dao.gggl.bzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyRwInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;

public interface BzzyRwInfoExtendMapper {
	List<BzzyRwInfoExtend> selectByCondition(QueryCondition<BzzyRwInfoExtend> condition);

	Integer deleteByBzzyId(@Param("bzzyId") String bzzyId);
}