package com.pope.advert.controller;

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

import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.code.DictionaryEnum;

@Controller
@RequestMapping("dictionary")
public class DictionaryController extends BaseController{

	@Autowired
	private DictionaryService dictionaryService;
	@RequestMapping("selectCity")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectCityByParent(String parentBm) throws Exception{
		return dictionaryService.selectAreaByParent(parentBm, this.createCustomOperateLog());
	}
	@RequestMapping("selectDst")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectDst(String areaBm) throws Exception{
		return dictionaryService.selectDst(areaBm, this.createCustomOperateLog());
	}
	@RequestMapping("selectSdpd")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectSdpdByDst(String dstBm) throws Exception{
		return dictionaryService.selectSdpdByDst(dstBm, this.createCustomOperateLog());
	}
	
	@RequestMapping("selectDllm")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectDllmByPdbm(String pdId) throws Exception{
		return dictionaryService.selectDllmByPdbm(pdId, this.createCustomOperateLog());
	}
	
	@RequestMapping("selectGbdst")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectGbdstByAreabm(String areaBm) throws Exception{
		return dictionaryService.selectGbdstByAreabm(areaBm, this.createCustomOperateLog());
	}
	
	
	@RequestMapping("selectGbdstpd")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectGbdstpdByGbdstBm(String gbdstBm) throws Exception{
		return dictionaryService.selectGbdstpdByGbdstBm(gbdstBm, this.createCustomOperateLog());
	}
	
	
	@RequestMapping("selectBzxx")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectBzxxByAream(String areaBm) throws Exception{
		return dictionaryService.selectByAreaBm(DictionaryEnum.T_ADVERT_SJZD_BZXX.getCode(), areaBm, this.createCustomOperateLog());
	}
	
	@RequestMapping("selectZzxx")
	@ResponseBody
	public DataResult<List<DictionaryInfo>> selectZzxxByAream(String areaBm) throws Exception{
		return dictionaryService.selectByAreaBm(DictionaryEnum.T_ADVERT_SJZD_ZZXX.getCode(), areaBm, this.createCustomOperateLog());
	}
	
}
