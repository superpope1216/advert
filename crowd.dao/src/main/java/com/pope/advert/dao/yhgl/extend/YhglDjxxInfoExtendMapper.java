package com.pope.advert.dao.yhgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.yhgl.YhglDjxxInfo;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;

public interface YhglDjxxInfoExtendMapper {
   List<YhglDjxxInfoExtend> selectByCondition(QueryCondition<YhglDjxxInfoExtend> condition);
   
   
   List<YhglDjxxInfoExtend> selectDisplayByCondition(QueryCondition<YhglDjxxInfoExtend> condition);
   Integer updateByVersion(YhglDjxxInfo yhglDjxxInfo);
}