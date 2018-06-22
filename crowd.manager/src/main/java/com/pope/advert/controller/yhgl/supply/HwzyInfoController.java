package com.pope.advert.controller.yhgl.supply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.hwzy.extend.HwzyInfoExtend;
import com.pope.advert.entity.gggl.xmtzy.extend.XmtzyInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.hwzy.HwzyInfoService;
import com.pope.advert.service.supply.xmtzy.XmtzyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("hwzyInfo")
public class HwzyInfoController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private HwzyInfoService hwzyInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supply/hwzy");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}
	@RequestMapping("selectHwzyInfo")
	@ResponseBody
	public DataResult<HwzyInfoExtend> selectXmtzyInfo(String wid) throws Exception{
		HwzyInfoExtend queryHwzyInfoExtend=new HwzyInfoExtend();
		queryHwzyInfoExtend.setWid(wid);
		List<HwzyInfoExtend> datas=hwzyInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryHwzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new HwzyInfoExtend());
		}
	}
	
	@RequestMapping("sh")
	@ResponseBody
	public DataResult<Integer> sh(String wid,String shzt) throws Exception{
		return hwzyInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
	@RequestMapping("delete")
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return hwzyInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
}
