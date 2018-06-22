package com.pope.advert.dao.gggl.bzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyJyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;

public interface BzzyJyInfoExtendMapper {
	List<BzzyJyInfoExtend> selectByCondition(QueryCondition<BzzyJyInfoExtend> condition);

	Integer deleteByBzzyId(@Param("bzzyId") String bzzyId);
}