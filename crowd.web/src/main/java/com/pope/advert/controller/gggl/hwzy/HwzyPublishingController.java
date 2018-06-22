package com.pope.advert.controller.gggl.hwzy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.AreaClassifyEnum;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyLmInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;
import com.pope.advert.entity.gggl.hwzy.HwzyInfo;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyQtInfoService;
import com.pope.advert.service.supply.gbzy.GbzySdInfoService;
import com.pope.advert.service.supply.hwzy.HwzyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("hwzyPublishing")
public class HwzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private HwzyInfoService hwzyInfoService;
	
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid,String gglx) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/hwzy/publishing");
		mv.addObject("wid",StringUtil.toStr(wid));
		mv.addObject("gglx",StringUtil.toStr(gglx));
		mv.addObject("zmsj", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HWZY_ZMSJ, null));
		mv.addObject("mtzt", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HWZY_MEZT, null));
		mv.addObject("zxtfzq", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HWZY_ZXTFZQ, null));
		mv.addObject("ggsyqzk", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("advertType", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HWZY_LX, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		
		
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("publishing")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishing(HwzyInfo hwzyInfo) throws Exception{
		return hwzyInfoService.publishing(hwzyInfo,this.createCustomOperateLog());
	}
	@ResponseBody
	@RequestMapping("select")
	@AuthIsSupplyAnnotation
	public DataResult<HwzyInfo> select(String wid) throws Exception{
		return hwzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@ResponseBody
	@RequestMapping("delete")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> delete(String wid) throws Exception{
		return hwzyInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
}
