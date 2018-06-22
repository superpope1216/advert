package com.pope.advert.controller.cwgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.service.cwgl.CwglCzjlInfoService;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DecimalUtil;
import com.wisedu.crowd.common.util.StringUtil;

@RequestMapping("yhdjxxInfo")
@Controller
public class YhdjxxInfoController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private YhglDjxxInfoServie yhglDjxxInfoServie;
	@Autowired
	private CwglDjxxInfoService cwglDjxxInfoService;
	@Autowired
	private CwglCzjlInfoService cwglCzjlInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("cwgl/yhdjxx");
		mv.addObject("czzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_CWGL_CZZT));
		mv.addObject("djxx", cwglDjxxInfoService.selectByCondition(ConditionUtil.createCondition(new CwglDjxxInfoExtend()), this.createCustomOperateLog()).getDatas());
		return mv;
	}
	
	@RequestMapping("listCzjl")
	@ResponseBody
	public DataResult<List<CwglCzjlInfoExtend>> listCzjl(String yhid,Integer pageSize,Integer pageNum) throws Exception{
		CwglCzjlInfoExtend queryCwglCzjlInfoExtend=new CwglCzjlInfoExtend();
		queryCwglCzjlInfoExtend.setYhid(yhid);
		DataResult<List<CwglCzjlInfoExtend>> data=cwglCzjlInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryCwglCzjlInfoExtend, new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
		if(CommonUtil.isNotEmptyList(data.getDatas())) {
			for(CwglCzjlInfoExtend cwglCzjlInfoExtend:data.getDatas()) {
				if(cwglCzjlInfoExtend.getNx()!=null && cwglCzjlInfoExtend.getNx()!=0) {
					cwglCzjlInfoExtend.setHyje(StringUtil.toStr(DecimalUtil.div(cwglCzjlInfoExtend.getJe(), DecimalUtil.toDecimal(StringUtil.toStr(cwglCzjlInfoExtend.getNx())))));
				}
			}
		}
		return data;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public DataResult<List<YhglDjxxInfoExtend>> list(YhglDjxxInfoExtend djxx,Integer pageSize,Integer pageNum) throws Exception{
		
		return yhglDjxxInfoServie.selectDisplayByCondition(ConditionUtil.createCondition(djxx, new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
}
