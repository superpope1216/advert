package com.pope.advert.dao.gggl.bzzy.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyInfoExtend;

public interface BzzyInfoExtendMapper {
    List<BzzyInfoExtend> selectDisplayByCondition(QueryCondition<BzzyInfoExtend> condition);
}