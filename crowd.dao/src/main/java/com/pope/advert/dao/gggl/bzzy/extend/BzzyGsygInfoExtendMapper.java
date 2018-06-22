package com.pope.advert.dao.gggl.bzzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;

public interface BzzyGsygInfoExtendMapper {
	List<BzzyGsygInfoExtend> selectByCondition(QueryCondition<BzzyGsygInfoExtend> condition);

	List<BzzyGsygInfoExtend> selectDisplayByCondition(QueryCondition<BzzyGsygInfoExtend> condition);
	
	Integer deleteByBzzyId(@Param("bzzyId") String bzzyId);
}