package com.wisedu.crowd.common.util;

import com.github.pagehelper.Page;
import com.pope.advert.entity.dto.PageInfo;

public class PageUtil {

	public static  PageInfo changePageInfo(Page page ){
		if(page==null){
			return new PageInfo();
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(page.getPageNum());
		pageInfo.setPageSize(page.getPageSize());
		pageInfo.setTotalPage(page.getPages());
		pageInfo.setTotalSize(page.getTotal());
		return pageInfo;
	}
	
	public static PageInfo cratePageInfo(Integer pageNum,Integer pageSize){
		if(pageNum==null|| pageNum<1){
			pageNum=1;
		}
		if(pageSize==null|| pageSize<=0){
			pageSize=20;
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}
}
