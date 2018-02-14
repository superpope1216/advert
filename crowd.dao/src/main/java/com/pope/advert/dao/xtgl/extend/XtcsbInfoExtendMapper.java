package com.pope.advert.dao.xtgl.extend;

import java.util.List;

import com.pope.advert.entity.xtgl.extend.XtcsbInfoExtend;


public interface XtcsbInfoExtendMapper {
	
	List<XtcsbInfoExtend>  selectByCondition(XtcsbInfoExtend record);
	
}