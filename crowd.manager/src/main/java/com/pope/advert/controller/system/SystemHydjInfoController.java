package com.pope.advert.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.cwgl.CwglDjxxInfo;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("system/hy")
public class SystemHydjInfoController extends BaseController{

	@Autowired
	private CwglDjxxInfoService cwglDjxxInfoService;
	@RequestMapping("index")
	public String index() {
		return "system/hyIndex";
	}
	
	
	@RequestMapping("list")
	@ResponseBody
	public DataResult<List<CwglDjxxInfoExtend>> list() throws Exception{
		CwglDjxxInfoExtend queryCwglDjxxInfoExtend=new CwglDjxxInfoExtend();
		return cwglDjxxInfoService.selectByCondition(ConditionUtil.createCondition(queryCwglDjxxInfoExtend,new PageInfo(100,1)), this.createCustomOperateLog());
	}
	
	@RequestMapping("select")
	@ResponseBody
	public DataResult<CwglDjxxInfo> select(String wid) throws Exception{
	
		return cwglDjxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	
	@RequestMapping("save")
	@ResponseBody
	public DataResult<Integer> save(CwglDjxxInfo cwglDjxx) throws Exception{
		if(StringUtil.isEmpty(cwglDjxx.getWid())) {
			cwglDjxx.setWid(StringUtil.getUuId());
			return cwglDjxxInfoService.insertSelective(cwglDjxx, this.createCustomOperateLog());
		}else {
			return cwglDjxxInfoService.updateByPrimaryKeySelective(cwglDjxx, this.createCustomOperateLog());
		}
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return cwglDjxxInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
}
