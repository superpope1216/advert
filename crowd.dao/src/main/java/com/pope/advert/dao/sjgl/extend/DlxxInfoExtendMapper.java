package com.pope.advert.dao.sjgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;

public interface DlxxInfoExtendMapper {

	List<DlxxInfoExtend> selectDisplayByCondition(QueryCondition<DlxxInfoExtend> condition);
}
