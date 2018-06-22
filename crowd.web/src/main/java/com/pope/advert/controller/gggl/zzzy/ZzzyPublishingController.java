package com.pope.advert.controller.gggl.zzzy;

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
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyGsygInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyJyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyRwInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyJyInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyRwInfoExtend;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyGsygInfoService;
import com.pope.advert.service.supply.bzzy.BzzyJyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyRwInfoService;
import com.pope.advert.service.supply.bzzy.BzzyXbmggInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyGsygInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyJyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyRwInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("zzzyPublishing")
public class ZzzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private ZzzyGsygInfoService zzzyGsygInfoService;
	
	@Autowired
	private ZzzyRwInfoService zzzyRwInfoService;
	@Autowired
	private ZzzyJyInfoService zzzyJyInfoService;
	@Autowired
	private ZzzyInfoService zzzyInfoService;
	@Autowired
	private ZzzyExtInfoService zzzyExtInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid,String gglx,String ggfl) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/zzzy/publishing");
		mv.addObject("wid",StringUtil.toStr(wid));
		mv.addObject("gglx",StringUtil.toStr(gglx));
		mv.addObject("ggfl",StringUtil.toStr(ggfl).equals("")?"1":StringUtil.toStr(ggfl));
		mv.addObject("hy", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HY, null));
		mv.addObject("ggdlfs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("zzlx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_ZZZYLX, null));
		mv.addObject("bzys", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_BZYS, null));
		return mv;
	}
	
	@InitBinder("zzzyInfo")
	public void initBinderZzzyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("zzzyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@InitBinder("zzzyExtInfo")
	public void initBinderZzzyExtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("zzzyExtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@InitBinder("zzzyGsygInfo")
	public void initBinderZzzyGsygForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("zzzyGsygInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@ResponseBody
	@RequestMapping("publishingZzzyGsyg")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingZzzyGsyg(ZzzyInfo zzzyInfo,ZzzyGsygInfo zzzyGsygInfo,ZzzyExtInfo zzzyExtInfo) throws Exception{
		return zzzyGsygInfoService.publishing(zzzyInfo, zzzyGsygInfo,zzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("zzzyRwInfo")
	public void initBinderZzzyRwForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("zzzyRwInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingZzzyRw")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingZzzyRw(ZzzyInfo zzzyInfo,ZzzyRwInfo zzzyRwInfo,ZzzyExtInfo zzzyExtInfo) throws Exception{
		return zzzyRwInfoService.publishing(zzzyInfo, zzzyRwInfo,zzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("zzzyJyInfo")
	public void initBinderZzzyJyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("zzzyJyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingZzzyJy")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingZzzyJy(ZzzyInfo zzzyInfo,ZzzyJyInfo zzzyJyInfo,ZzzyExtInfo zzzyExtInfo) throws Exception{
		return zzzyJyInfoService.publishing(zzzyInfo, zzzyJyInfo,zzzyExtInfo,this.createCustomOperateLog());
	}
	
	/**
	 * 
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectZzzy")
	@ResponseBody
	@AuthIsSupplyAnnotation
	public DataResult<ZzzyInfo> selectZzzy(String wid) throws Exception{
		return zzzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@ResponseBody
	@RequestMapping("selectZzzyExt")
	@AuthIsSupplyAnnotation
	public DataResult<ZzzyExtInfoExtend> selectZzzyExt(String zzzyId) throws Exception{
		ZzzyExtInfoExtend queryZzzyExtInfoExtend=new ZzzyExtInfoExtend();
		queryZzzyExtInfoExtend.setDszyId(zzzyId);
		List<ZzzyExtInfoExtend> datas=zzzyExtInfoService.selectByCondition(ConditionUtil.createCondition(queryZzzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new ZzzyExtInfoExtend());
		}
	}
	
	@ResponseBody
	@RequestMapping("selectZzzyOther")
	@AuthIsSupplyAnnotation
	public DataResult<Object> selectZzzyOther(String zzzyId,String ggfl) throws Exception{
		
		if("1".equals(ggfl)){
			ZzzyGsygInfoExtend queryZzzyGsygInfoExtend=new ZzzyGsygInfoExtend();
			queryZzzyGsygInfoExtend.setZzzyId(zzzyId);;
			List<ZzzyGsygInfoExtend> datas=zzzyGsygInfoService.selectByCondition(ConditionUtil.createCondition(queryZzzyGsygInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggfl)){
			ZzzyRwInfoExtend queryZzzyRwInfoExtend=new ZzzyRwInfoExtend();
			queryZzzyRwInfoExtend.setZzzyId(zzzyId);
			
			List<ZzzyRwInfoExtend> datas=zzzyRwInfoService.selectByCondition(ConditionUtil.createCondition(queryZzzyRwInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}else if("3".equals(ggfl)){
			ZzzyJyInfoExtend queryZzzyJyInfoExtend=new ZzzyJyInfoExtend();
			queryZzzyJyInfoExtend.setZzzyId(zzzyId);
			List<ZzzyJyInfoExtend> datas=zzzyJyInfoService.selectByCondition(ConditionUtil.createCondition(queryZzzyJyInfoExtend), this.createCustomOperateLog()).getDatas();
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
			zzzyGsygInfoService.delete(wid, this.createCustomOperateLog());
		}else if("2".equals(ggfl)){
			zzzyRwInfoService.delete(wid, this.createCustomOperateLog());
		}else if("3".equals(ggfl)){
			zzzyJyInfoService.delete(wid, this.createCustomOperateLog());
		}
		return DataResult.success(1);
	}
}
