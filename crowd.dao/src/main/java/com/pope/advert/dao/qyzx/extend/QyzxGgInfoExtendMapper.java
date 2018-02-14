package com.pope.advert.dao.qyzx.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.qyzx.QyzxGgInfo;
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;

public interface QyzxGgInfoExtendMapper {
	List<QyzxGgInfoExtend> selectDisplayByCondition(QueryCondition<QyzxGgInfoExtend> condition);
}