package com.pope.advert.controller.yhgl.supply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyQtInfoService;
import com.pope.advert.service.supply.gbzy.GbzySdInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("gbzyInfo")
public class GbzyInfoController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private GbzyInfoService gbzyInfoService;
	@Autowired
	private GbzyExtInfoService gbzyExtInfoService;
	@Autowired
	private GbzySdInfoService gbzySdInfoService;
	@Autowired
	private GbzyQtInfoService gbzyQtInfoService;
	
	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supply/gbzy");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}
	
	@RequestMapping("selectGbzyInfo")
	@ResponseBody
	public DataResult<GbzyInfoExtend> selectGbzyInfo(String wid) throws Exception {
		GbzyInfoExtend queryGbzyInfoExtend = new GbzyInfoExtend();
		queryGbzyInfoExtend.setWid(wid);

		List<GbzyInfoExtend> datas = gbzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryGbzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new GbzyInfoExtend());
		}
	}
	@RequestMapping("selectGbzyExtInfo")
	@ResponseBody
	public DataResult<GbzyExtInfoExtend> selectGbzyExtInfo(String gbzyId) throws Exception{
		List<DictionaryInfo> hyList=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_HY);
		
		GbzyExtInfoExtend queryGbzyExtInfoExtend=new GbzyExtInfoExtend();
		queryGbzyExtInfoExtend.setGbzyId(gbzyId);
		
		List<GbzyExtInfoExtend> datas=gbzyExtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryGbzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			GbzyExtInfoExtend gbzyExtInfoExtend=datas.get(0);
			
			return DataResult.success(gbzyExtInfoExtend);
		}else{
			return DataResult.success(new GbzyExtInfoExtend());
		}
	}

	@RequestMapping("selectGbzyOtherInfo")
	@ResponseBody
	public DataResult<Object> selectGbzyOtherInfo(String gbzyId,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			GbzySdInfoExtend queryGbzySdInfoExtend=new GbzySdInfoExtend();
			queryGbzySdInfoExtend.setGbzyBm(gbzyId);
			List<GbzySdInfoExtend> datas=gbzySdInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryGbzySdInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggxs)){
			
			GbzyQtInfoExtend queryGbzyQtInfoExtend=new GbzyQtInfoExtend();
			queryGbzyQtInfoExtend.setGbzyBm(gbzyId);
			List<GbzyQtInfoExtend> datas=gbzyQtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryGbzyQtInfoExtend),this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}
		return DataResult.success(null);
		
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public DataResult<Integer> delete(String wid,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			gbzySdInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
			
		}else if("2".equals(ggxs)){
			gbzyQtInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
		}
		return DataResult.success(1);
	}
	@ResponseBody
	@RequestMapping("sh")
	public DataResult<Integer> sh(String wid,String shzt)throws Exception{
		return gbzyInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
	
}
