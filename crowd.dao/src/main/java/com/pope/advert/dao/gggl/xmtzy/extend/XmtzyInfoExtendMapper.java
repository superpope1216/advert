package com.pope.advert.dao.gggl.xmtzy.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.xmtzy.extend.XmtzyInfoExtend;

public interface XmtzyInfoExtendMapper {
	List<XmtzyInfoExtend> selectDisplayByCondition(QueryCondition<XmtzyInfoExtend> condition);
}
