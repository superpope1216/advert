package com.pope.advert.controller.gggl.xmtzy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.AreaClassifyEnum;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.xmtzy.XmtzyInfo;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.xmtzy.XmtzyInfoService;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("xmtzyPublishing")
public class XmtzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private XmtzyInfoService xmtzyInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid,String gglx,String ggfl) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/xmtzy/publishing");
		mv.addObject("wid",StringUtil.toStr(wid));
		mv.addObject("gglx",StringUtil.toStr(gglx));
		mv.addObject("ggfl",StringUtil.toStr(ggfl));
		mv.addObject("xmtlx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTLX, null));
		mv.addObject("szrq", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_SZRQ, null));
		mv.addObject("jycd", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_JYCD, null));
		mv.addObject("zyfb", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_ZYFB, null));
		mv.addObject("srzk", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_SRZK, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		return mv;
	}
	@RequestMapping("publishing")
	@AuthIsSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> publishing(XmtzyInfo xmtzyInfo) throws Exception{
		return xmtzyInfoService.publishing(xmtzyInfo, this.createCustomOperateLog());
	}
	@RequestMapping("select")
	@AuthIsSupplyAnnotation
	@ResponseBody
	public DataResult<XmtzyInfo> select(String wid) throws Exception{
		return xmtzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@RequestMapping("delete")
	@AuthIsSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return xmtzyInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
}
