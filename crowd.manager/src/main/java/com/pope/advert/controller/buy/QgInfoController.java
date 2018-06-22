package com.pope.advert.controller.buy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.buy.qg.extend.QgInfoExtend;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.service.buy.qg.QgInfoService;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
@Controller
@RequestMapping("qgInfo")
public class QgInfoController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private QgInfoService qgInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		mv.setViewName("buy/qg");
		return mv;
	}
	@RequestMapping("list")
	@ResponseBody
	public DataResult<List<QgInfoExtend>> list(QgInfoExtend queryQgInfoExtend,Integer pageSize,Integer pageNum) throws Exception{
		
		return qgInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryQgInfoExtend, new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	@ResponseBody
	@RequestMapping("select")
	public DataResult<QgInfoExtend> select(String wid) throws Exception{
		QgInfoExtend queryQgInfoExtend=new QgInfoExtend();
		queryQgInfoExtend.setWid(wid);
		List<QgInfoExtend> datas=qgInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryQgInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new QgInfoExtend());
		}
	}
	@ResponseBody
	@RequestMapping("delete")
	public DataResult<Integer> delete(String wid) throws Exception{
		return qgInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@ResponseBody
	@RequestMapping("sh")
	public DataResult<Integer> sh(String wid,String shzt) throws Exception{
		return qgInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
}
