package com.pope.advert.controller.yhgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("registerUser")
public class RegisterController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private RegisterInfoService registerInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		mv.setViewName("yhgl/register");
		return mv;
		
	}
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<RegisterInfoExtend>> getList(String yhm,String sjh,String shzt,Integer pageNum,String state,String order) throws Exception{
		RegisterInfoExtend queryRegisterInfoExtend=new RegisterInfoExtend();
		if(!StringUtil.isEmpty(yhm)){
			queryRegisterInfoExtend.setYhmLike(yhm.trim());
		}
		if(!StringUtil.isEmpty(sjh.trim())){
			queryRegisterInfoExtend.setSjhLike(sjh.trim());
		}
		return registerInfoService.selectByCondition(ConditionUtil.createCondition(queryRegisterInfoExtend, new PageInfo(null,pageNum)), this.createCustomOperateLog());
		
		
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return registerInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@RequestMapping("select")
	@ResponseBody
	public DataResult<RegisterInfoExtend> select(String wid) throws Exception{
		RegisterInfoExtend queryRegisterInfoExtend=new RegisterInfoExtend();
		queryRegisterInfoExtend.setWid(wid);
		List<RegisterInfoExtend> datas=registerInfoService.selectByCondition(ConditionUtil.createCondition(queryRegisterInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}
		return DataResult.success(queryRegisterInfoExtend);
	}
}
