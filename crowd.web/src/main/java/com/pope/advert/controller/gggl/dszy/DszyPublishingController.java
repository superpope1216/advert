package com.pope.advert.controller.gggl.dszy;

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
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyGmInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyLmInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.DszyTbInfo;
import com.pope.advert.entity.gggl.DszyZzInfo;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.entity.gggl.DszyZtInfo;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyGmInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszyLmInfoService;
import com.pope.advert.service.supply.DszySdInfoService;
import com.pope.advert.service.supply.DszyTbInfoService;
import com.pope.advert.service.supply.DszyZtInfoService;
import com.pope.advert.service.supply.DszyZzInfoService;
import com.pope.advert.service.supply.SupplyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("dszyPublishing")
public class DszyPublishingController extends BaseController{

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private DszySdInfoService dszySdInfoService;
	@Autowired
	private DszyInfoService dszyInfoService;
	
	@Autowired
	private DszyLmInfoService dszyLmInfoService;
	@Autowired
	private DszyTbInfoService dszyTbInfoService;
	@Autowired
	private DszyZtInfoService dszyZtInfoService;
	@Autowired
	private DszyGmInfoService dszyGmInfoService;
	@Autowired
	private DszyZzInfoService dszyZzInfoService;
	
	@Autowired
	private DszyExtInfoService dszyExtInfoService;
	@Autowired
	private SupplyInfoService supplyInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid,String gglx,String ggfl) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/dszy/publishing");
		mv.addObject("wid",StringUtil.toStr(wid));
		mv.addObject("gglx",StringUtil.toStr(gglx));
		mv.addObject("ggfl",StringUtil.toStr(ggfl).equals("")?"1":StringUtil.toStr(ggfl));
		
		mv.addObject("ggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGXS, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("hy", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HY, null));
		mv.addObject("ggdlfs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("tbbccslx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_TBBCCSLX, null));
		mv.addObject("ztsjd", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_ZTSJD, null));
		mv.addObject("gmggjgpc", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GMGGJGPC, null));
		
		
		return mv;
	}
	
	@InitBinder("dszySdInfo")
	public void initBinderDszySdForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszySdInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@InitBinder("dszyInfo")
	public void initBinderDszyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyInfo.");
	}
	@InitBinder("dszyExtInfo")
	public void initBinderDszyExtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyExtInfo.");
	}
	@ResponseBody
	@RequestMapping("publishingDszySd")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszySd(DszyInfo dszyInfo,DszySdInfo dszySdInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszySdInfoService.publishing(dszyInfo, dszySdInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyLmInfo")
	public void initBinderDszyLmForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyLmInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyLm")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyLm(DszyInfo dszyInfo,DszyLmInfo dszyLmInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyLmInfoService.publishing(dszyInfo, dszyLmInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyTbInfo")
	public void initBinderDszyTbForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyTbInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyTb")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyTb(DszyInfo dszyInfo,DszyTbInfo dszyTbInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyTbInfoService.publishing(dszyInfo, dszyTbInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyZtInfo")
	public void initBinderDszyZtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyZtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyZt")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyZt(DszyInfo dszyInfo,DszyZtInfo dszyZtInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyZtInfoService.publishing(dszyInfo, dszyZtInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("dszyGmInfo")
	public void initBinderDszyGmForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyGmInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyGm")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyGm(DszyInfo dszyInfo,DszyGmInfo dszyGmInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyGmInfoService.publishing(dszyInfo, dszyGmInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyZzInfo")
	public void initBinderDszyZzForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyZzInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyZz")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyZz(DszyInfo dszyInfo,DszyZzInfo dszyZzInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyZzInfoService.publishing(dszyInfo, dszyZzInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	
	/**
	 * 电视资源
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("selectDszy")
	@AuthIsSupplyAnnotation
	public DataResult<DszyInfo> selectDszy(String wid) throws Exception{
		return dszyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@ResponseBody
	@RequestMapping("selectDszyExt")
	@AuthIsSupplyAnnotation
	public DataResult<DszyExtInfoExtend> selectDszyExt(String dszyId) throws Exception{
		DszyExtInfoExtend queryDszyExtInfoExtend=new DszyExtInfoExtend();
		queryDszyExtInfoExtend.setDszyId(dszyId);
		List<DszyExtInfoExtend> datas=dszyExtInfoService.selectByCondition(ConditionUtil.createCondition(queryDszyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new DszyExtInfoExtend());
		}
	}
	@ResponseBody
	@RequestMapping("selectDszyOther")
	@AuthIsSupplyAnnotation
	public DataResult<Map<String,Object>> selectDszyOther(String dszyId,String ggfl) throws Exception{
		String tableName="";
		if("1".equals(ggfl)){
			tableName="t_advert_gggl_dszy_sd";
		}else if("2".equals(ggfl)){
			tableName="t_advert_gggl_dszy_lm";
		}else if("3".equals(ggfl)){
			tableName="t_advert_gggl_dszy_tb";
		}
		else if("4".equals(ggfl)){
			tableName="t_advert_gggl_dszy_zt";
		}else if("5".equals(ggfl)){
			tableName="t_advert_gggl_dszy_gm";
		}else if("6".equals(ggfl)){
			tableName="t_advert_gggl_dszy_zz";
		}
		Map<String,Object> map=supplyInfoService.selectDszyByCondition(dszyId, tableName, this.createCustomOperateLog()).getDatas();
		Map<String,Object> newMap=new HashMap<String,Object>();
		
		if(CommonUtil.isNotEmptyMap(map)){
			for (Map.Entry<String,Object> entry : map.entrySet()) {
				String newKey=entry.getKey().toLowerCase();
				if(newKey.indexOf("_")>=0){
					String firstChar=newKey.substring(newKey.indexOf("_")+1, newKey.indexOf("_")+2);
					newKey=newKey.replaceFirst("_"+firstChar,firstChar.toUpperCase());
				}
				newMap.put(newKey, entry.getValue());
			}
		}
		return DataResult.success(newMap);
	}
	@RequestMapping("delete")
	@AuthIsSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> delete(String wid,String ggfl) throws Exception{
		if("1".equals(ggfl)){
			return dszySdInfoService.delete(wid, this.createCustomOperateLog());
		}else if("2".equals(ggfl)){
			return dszyLmInfoService.delete(wid, this.createCustomOperateLog());
		}else if("3".equals(ggfl)){
			return dszyTbInfoService.delete(wid, this.createCustomOperateLog());
		}
		else if("4".equals(ggfl)){
			return dszyZtInfoService.delete(wid, this.createCustomOperateLog());
		}else if("5".equals(ggfl)){
			return dszyGmInfoService.delete(wid, this.createCustomOperateLog());
		}else if("6".equals(ggfl)){
			return dszyZzInfoService.delete(wid, this.createCustomOperateLog());
		}
		return DataResult.success(1);
	}
	
	
	
	
}
