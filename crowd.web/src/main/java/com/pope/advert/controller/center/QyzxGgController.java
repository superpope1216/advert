package com.pope.advert.controller.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxGgInfoService;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("qyzxGg")
public class QyzxGgController extends BaseController{
	@Autowired
	private QyzxGgInfoService qyzxGgInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("center/qyzxGgCenter");
		return mv;
	}
	
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<QyzxGgInfoExtend>> getList(Integer pageNum) throws Exception{
		QyzxGgInfoExtend queryQyzxGgInfoExtend=new QyzxGgInfoExtend();
		queryQyzxGgInfoExtend.setShzt(SjztEnum.YTG.getCode());
		
		return qyzxGgInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryQyzxGgInfoExtend,new PageInfo(null,pageNum)), this.createCustomOperateLog());
		
	}
}
