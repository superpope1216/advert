package com.pope.advert.controller.hyzx;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("hyzxNews")
public class HyzxNewsController  extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private QyzxNewsInfoService qyzxNewsInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hyzx/hyzxNews");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}
	
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<QyzxNewsInfoExtend>>  getList(String name,String shzt,Integer pageNum,String state,String order) throws Exception{
		QyzxNewsInfoExtend queryDlxxInfoExtend=new QyzxNewsInfoExtend();
		queryDlxxInfoExtend.setNeedCompanyInfo(true);
		
		if(!StringUtil.isEmpty(name)){
			queryDlxxInfoExtend.setCompanyName(name.trim());
		}
		if(!StringUtil.isEmpty(shzt)){
			queryDlxxInfoExtend.setShzt(shzt.trim());
		}
		List<String> orders=new ArrayList<String>();
		if(!StringUtil.isEmpty(order)){
			
			orders.add(order);
		}
		DataResult<List<QyzxNewsInfoExtend>> datas= qyzxNewsInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDlxxInfoExtend,new PageInfo(null,pageNum),orders),this.createCustomOperateLog());
		return datas;
	}
	
	@RequestMapping("sh")
	@ResponseBody
	public DataResult<Integer> sh(String wid,String shzt) throws Exception{
		return qyzxNewsInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
	@RequestMapping("delete")
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return qyzxNewsInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@RequestMapping("select")
	@ResponseBody
	public DataResult<QyzxNewsInfoExtend> select(String wid) throws Exception{
		QyzxNewsInfoExtend queryDlxxInfoExtend=new QyzxNewsInfoExtend();
		queryDlxxInfoExtend.setWid(wid);
		queryDlxxInfoExtend.setNeedCompanyInfo(true);
		List<QyzxNewsInfoExtend> datas=qyzxNewsInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDlxxInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}
		return DataResult.success(queryDlxxInfoExtend);
	}
}
