package com.pope.advert.controller.gggl.bzzy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyJyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyRwInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyXbmggInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyXbmggInfoExtend;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyExtInfoService;
import com.pope.advert.service.supply.bzzy.BzzyGsygInfoService;
import com.pope.advert.service.supply.bzzy.BzzyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyJyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyRwInfoService;
import com.pope.advert.service.supply.bzzy.BzzyXbmggInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("bzzyPublishing")
public class BzzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private BzzyGsygInfoService bzzyGsygInfoService;
	@Autowired
	private BzzyXbmggInfoService bzzyXbmggInfoService;
	@Autowired
	private BzzyRwInfoService bzzyRwInfoService;
	@Autowired
	private BzzyJyInfoService bzzyJyInfoService;
	@Autowired
	private BzzyInfoService bzzyInfoService;
	@Autowired
	private BzzyExtInfoService bzzyExtInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid,String gglx,String ggfl) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/bzzy/publishing");
		mv.addObject("wid",StringUtil.toStr(wid));
		mv.addObject("gglx",StringUtil.toStr(gglx));
		mv.addObject("ggfl",StringUtil.toStr(ggfl).equals("")?"1":StringUtil.toStr(ggfl));
		mv.addObject("hy", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HY, null));
		mv.addObject("ggdlfs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("bzlx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_BZLX, null));
		mv.addObject("xbmgglx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XBMGGLX, null));
		mv.addObject("bzys", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_BZYS, null));
		return mv;
	}
	
	@InitBinder("bzzyInfo")
	public void initBinderBzzyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@InitBinder("bzzyExtInfo")
	public void initBinderBzzyExtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyExtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@InitBinder("bzzyGsygInfo")
	public void initBinderBzzyGsygForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyGsygInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@ResponseBody
	@RequestMapping("publishingBzzyGsyg")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyGsyg(BzzyInfo bzzyInfo,BzzyGsygInfo bzzyGsygInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyGsygInfoService.publishing(bzzyInfo, bzzyGsygInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("bzzyXbmggInfo")
	public void initBinderBzzyXbmggForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyXbmggInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingBzzyXbmgg")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyXbmgg(BzzyInfo bzzyInfo,BzzyXbmggInfo bzzyXbmggInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyXbmggInfoService.publishing(bzzyInfo, bzzyXbmggInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("bzzyRwInfo")
	public void initBinderBzzyRwForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyRwInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingBzzyRw")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyRw(BzzyInfo bzzyInfo,BzzyRwInfo bzzyRwInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyRwInfoService.publishing(bzzyInfo, bzzyRwInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("bzzyJyInfo")
	public void initBinderBzzyJyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyJyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingBzzyJy")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyJy(BzzyInfo bzzyInfo,BzzyJyInfo bzzyJyInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyJyInfoService.publishing(bzzyInfo, bzzyJyInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
	
	/**
	 * 
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectBzzy")
	@ResponseBody
	@AuthIsSupplyAnnotation
	public DataResult<BzzyInfo> selectBzzy(String wid) throws Exception{
		return bzzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@ResponseBody
	@RequestMapping("selectBzzyExt")
	@AuthIsSupplyAnnotation
	public DataResult<BzzyExtInfoExtend> selectBzzyExt(String bzzyId) throws Exception{
		BzzyExtInfoExtend queryBzzyExtInfoExtend=new BzzyExtInfoExtend();
		queryBzzyExtInfoExtend.setBzzyId(bzzyId);
		List<BzzyExtInfoExtend> datas=bzzyExtInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new BzzyExtInfoExtend());
		}
	}
	
	@ResponseBody
	@RequestMapping("selectBzzyOther")
	@AuthIsSupplyAnnotation
	public DataResult<Object> selectBzzyOther(String bzzyId,String ggfl) throws Exception{
		
		if("1".equals(ggfl)){
			BzzyGsygInfoExtend queryBzzyGsygInfoExtend=new BzzyGsygInfoExtend();
			queryBzzyGsygInfoExtend.setBzzyId(bzzyId);
			List<BzzyGsygInfoExtend> datas=bzzyGsygInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyGsygInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggfl)){
			BzzyXbmggInfoExtend queryBzzyXbmggInfoExtend=new BzzyXbmggInfoExtend();
			queryBzzyXbmggInfoExtend.setBzzyId(bzzyId);
			List<BzzyXbmggInfoExtend> datas=bzzyXbmggInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyXbmggInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}else if("3".equals(ggfl)){
			BzzyRwInfoExtend queryBzzyRwInfoExtend=new BzzyRwInfoExtend();
			queryBzzyRwInfoExtend.setBzzyId(bzzyId);
			List<BzzyRwInfoExtend> datas=bzzyRwInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyRwInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}
		else if("4".equals(ggfl)){
			BzzyJyInfoExtend queryBzzyJyInfoExtend=new BzzyJyInfoExtend();
			queryBzzyJyInfoExtend.setBzzyId(bzzyId);
			List<BzzyJyInfoExtend> datas=bzzyJyInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyJyInfoExtend), this.createCustomOperateLog()).getDatas();
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
			bzzyGsygInfoService.delete(wid, this.createCustomOperateLog());
		}else if("2".equals(ggfl)){
			bzzyXbmggInfoService.delete(wid, this.createCustomOperateLog());
		}else if("3".equals(ggfl)){
			bzzyRwInfoService.delete(wid, this.createCustomOperateLog());
		}else if("4".equals(ggfl)){
			bzzyJyInfoService.delete(wid, this.createCustomOperateLog());
		}
		return DataResult.success(1);
	}
}
