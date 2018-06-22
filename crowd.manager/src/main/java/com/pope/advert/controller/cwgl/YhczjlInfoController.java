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
import com.pope.advert.service.cwgl.CwglCzjlInfoService;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DecimalUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("czjlInfo")
public class YhczjlInfoController extends BaseController{
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
		mv.addObject("zfzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_CWGL_CZZT));
		mv.addObject("djxx", cwglDjxxInfoService.selectByCondition(ConditionUtil.createCondition(new CwglDjxxInfoExtend()), this.createCustomOperateLog()).getDatas());
		mv.setViewName("cwgl/czjl");
		return mv;
	}
	@RequestMapping("list")
	@ResponseBody
	public DataResult<List<CwglCzjlInfoExtend>> list(CwglCzjlInfoExtend cwglCzjlInfoExtend,Integer pageSize,Integer pageNum) throws Exception{
		
		DataResult<List<CwglCzjlInfoExtend>> data=cwglCzjlInfoService.selectDisplayByCondition(ConditionUtil.createCondition(cwglCzjlInfoExtend, new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
		if(CommonUtil.isNotEmptyList(data.getDatas())) {
			for(CwglCzjlInfoExtend aCwglCzjlInfoExtend:data.getDatas()) {
				if(cwglCzjlInfoExtend.getNx()!=null && cwglCzjlInfoExtend.getNx()!=0) {
				aCwglCzjlInfoExtend.setHyje(StringUtil.toStr(DecimalUtil.div(cwglCzjlInfoExtend.getJe(), DecimalUtil.toDecimal(StringUtil.toStr(cwglCzjlInfoExtend.getNx())))));
				}
			}
		}
		return data;
	}
	
}
