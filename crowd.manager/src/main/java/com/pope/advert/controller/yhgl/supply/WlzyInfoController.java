package com.pope.advert.controller.yhgl.supply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.wlzy.WlzyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
@Controller
@RequestMapping("wlzyInfo")
public class WlzyInfoController extends BaseController {
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private WlzyInfoService wlzyInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supply/wlzy");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}
	@RequestMapping("selectWlzyInfo")
	@ResponseBody
	public DataResult<WlzyInfoExtend> selectWlzyInfo(String wid) throws Exception{
		WlzyInfoExtend queryWlzyInfoExtend=new WlzyInfoExtend();
		queryWlzyInfoExtend.setWid(wid);
		List<WlzyInfoExtend> datas=wlzyInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryWlzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new WlzyInfoExtend());
		}
	}
	@ResponseBody
	@RequestMapping("delete")
	public DataResult<Integer> delete(String wid) throws Exception{
		return wlzyInfoService.delete(wid, this.createCustomOperateLog());
	}
	@ResponseBody
	@RequestMapping("sh")
	public DataResult<Integer> sh(String wid,String shzt)throws Exception{
		return wlzyInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
	
}
