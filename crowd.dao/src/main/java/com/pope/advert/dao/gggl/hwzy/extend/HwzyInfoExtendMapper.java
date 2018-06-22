package com.pope.advert.dao.gggl.hwzy.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.hwzy.extend.HwzyInfoExtend;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;

public interface HwzyInfoExtendMapper {
	List<HwzyInfoExtend> selectDisplayByCondition(QueryCondition<HwzyInfoExtend> condition);
}
