package com.pope.advert.controller.gggl.gbzy;

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
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyQtInfoService;
import com.pope.advert.service.supply.gbzy.GbzySdInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("gbzyPublishing")
public class GbzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private GbzyInfoService gbzyInfoService;
	@Autowired
	private GbzySdInfoService gbzySdInfoService;
	@Autowired
	private GbzyQtInfoService gbzyQtInfoService;
	@Autowired
	private GbzyExtInfoService gbzyExtInfoService;
	@Autowired
	private SupplyInfoService supplyInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid,String gglx,String ggfl) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/gbzy/publishing");
		mv.addObject("wid",StringUtil.toStr(wid));
		mv.addObject("gglx",StringUtil.toStr(gglx));
		mv.addObject("ggfl",StringUtil.toStr(ggfl).equals("")?"1":StringUtil.toStr(ggfl));
		mv.addObject("hy", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HY, null));
		mv.addObject("ggdlfs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("gblx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GBLX, null));
		
		return mv;
	}
	
	@InitBinder("gbzyInfo")
	public void initBinderGbzyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@InitBinder("gbzyExtInfo")
	public void initBinderGbzyExtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzyExtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@InitBinder("gbzySdInfo")
	public void initBinderGbzySdForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzySdInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingGbzySd")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingGbzySd(GbzyInfo gbzyInfo,GbzySdInfo gbzySdInfo,GbzyExtInfo gbzyExtInfo) throws Exception{
		return gbzySdInfoService.publishing(gbzyInfo, gbzySdInfo,gbzyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("gbzyQtInfo")
	public void initBinderGbzyQtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzyQtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingGbzyQt")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingGbzyQt(GbzyInfo gbzyInfo,GbzyQtInfo gbzyQtInfo,GbzyExtInfo gbzyExtInfo) throws Exception{
		return gbzyQtInfoService.publishing(gbzyInfo, gbzyQtInfo,gbzyExtInfo,this.createCustomOperateLog());
	}
	/**
	 * 
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectGbzy")
	@ResponseBody
	@AuthIsSupplyAnnotation
	public DataResult<GbzyInfo> selectGbzy(String wid) throws Exception{
		return gbzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@ResponseBody
	@RequestMapping("selectGbzyExt")
	@AuthIsSupplyAnnotation
	public DataResult<GbzyExtInfoExtend> selectGbzyExt(String gbzyId) throws Exception{
		GbzyExtInfoExtend queryGbzyExtInfoExtend=new GbzyExtInfoExtend();
		queryGbzyExtInfoExtend.setGbzyId(gbzyId);
		List<GbzyExtInfoExtend> datas=gbzyExtInfoService.selectByCondition(ConditionUtil.createCondition(queryGbzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new GbzyExtInfoExtend());
		}
	}
	
	@ResponseBody
	@RequestMapping("selectGbzyOther")
	@AuthIsSupplyAnnotation
	public DataResult<Object> selectGbzyOther(String gbzyId,String ggfl) throws Exception{
		
		if("1".equals(ggfl)){
			GbzySdInfoExtend queryGbzySdInfoExtend=new GbzySdInfoExtend();
			queryGbzySdInfoExtend.setGbzyBm(gbzyId);
			List<GbzySdInfoExtend> datas=gbzySdInfoService.selectByCondition(ConditionUtil.createCondition(queryGbzySdInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggfl)){
			GbzyQtInfoExtend queryGbzyQtInfoExtend=new GbzyQtInfoExtend();
			queryGbzyQtInfoExtend.setGbzyBm(gbzyId);
			List<GbzyQtInfoExtend> datas=gbzyQtInfoService.selectByCondition(ConditionUtil.createCondition(queryGbzyQtInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}
		return DataResult.success(null);
	}
	@ResponseBody
	@RequestMapping("delete")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> delete(String wid,String ggfl) throws Exception{
		if("1".equals(ggfl)){
			gbzySdInfoService.delete(wid, this.createCustomOperateLog());
		}else if("2".equals(ggfl)){
			gbzyQtInfoService.delete(wid, this.createCustomOperateLog());
		}
		return DataResult.success(1);
	}
}
