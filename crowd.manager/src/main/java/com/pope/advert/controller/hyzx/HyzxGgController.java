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
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxGgInfoService;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("hyzxGg")
public class HyzxGgController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private QyzxGgInfoService qyzxGgInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hyzx/hyzxGg");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}
	
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<QyzxGgInfoExtend>>  getList(String name,String shzt,Integer pageNum,String state,String order) throws Exception{
		QyzxGgInfoExtend queryDlxxInfoExtend=new QyzxGgInfoExtend();
		queryDlxxInfoExtend.setNeedCompanyInfo(true);
		if(!StringUtil.isEmpty(name)){
			queryDlxxInfoExtend.setCompanyName(name.trim());
		}
		queryDlxxInfoExtend.setNeedCompanyInfo(true);
		if(!StringUtil.isEmpty(shzt)){
			queryDlxxInfoExtend.setShzt(shzt.trim());
		}
		List<String> orders=new ArrayList<String>();
		if(!StringUtil.isEmpty(order)){
			
			orders.add(order);
		}
		DataResult<List<QyzxGgInfoExtend>> datas= qyzxGgInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDlxxInfoExtend,new PageInfo(null,pageNum),orders),this.createCustomOperateLog());
		return datas;
	}
	
	@RequestMapping("sh")
	@ResponseBody
	public DataResult<Integer> sh(String wid,String shzt) throws Exception{
		return qyzxGgInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
	@RequestMapping("delete")
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return qyzxGgInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@RequestMapping("select")
	@ResponseBody
	public DataResult<QyzxGgInfoExtend> select(String wid) throws Exception{
		QyzxGgInfoExtend queryDlxxInfoExtend=new QyzxGgInfoExtend();
		queryDlxxInfoExtend.setWid(wid);
		queryDlxxInfoExtend.setNeedCompanyInfo(true);
		List<QyzxGgInfoExtend> datas=qyzxGgInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDlxxInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}
		return DataResult.success(queryDlxxInfoExtend);
	}
}
