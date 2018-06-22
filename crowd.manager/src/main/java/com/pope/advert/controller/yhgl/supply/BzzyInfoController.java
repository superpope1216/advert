package com.pope.advert.controller.yhgl.supply;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.SupplyClassifyEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyXbmggInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyExtInfoService;
import com.pope.advert.service.supply.bzzy.BzzyGsygInfoService;
import com.pope.advert.service.supply.bzzy.BzzyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyJyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyRwInfoService;
import com.pope.advert.service.supply.bzzy.BzzyXbmggInfoService;
import com.wisedu.crowd.common.util.BeanUtil;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("bzzyInfo")
public class BzzyInfoController extends BaseController {
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private SupplyInfoService supplyInfoService;

	@Autowired
	private BzzyInfoService bzzyInfoService;
	@Autowired
	private BzzyXbmggInfoService bzzyXbmggInfoService;
	@Autowired
	private BzzyGsygInfoService bzzyGsygInfoService;
	@Autowired
	private BzzyRwInfoService bzzyRwInfoService;
	@Autowired
	private BzzyJyInfoService bzzyJyInfoService;
	@Autowired
	private BzzyExtInfoService bzzyExtInfoService;

	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supply/bzzy");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}

	@RequestMapping("selectBzzyInfo")
	@ResponseBody
	public DataResult<BzzyInfoExtend> selectBzzyInfo(String wid) throws Exception {
		BzzyInfoExtend queryBzzyInfoExtend = new BzzyInfoExtend();
		queryBzzyInfoExtend.setWid(wid);

		List<BzzyInfoExtend> datas = bzzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryBzzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new BzzyInfoExtend());
		}
	}
	@RequestMapping("selectBzzyExtInfo")
	@ResponseBody
	public DataResult<BzzyExtInfoExtend> selectBzzyExtInfo(String bzzyId) throws Exception{
		
		BzzyExtInfoExtend queryBzzyExtInfoExtend=new BzzyExtInfoExtend();
		queryBzzyExtInfoExtend.setBzzyId(bzzyId);
		
		List<BzzyExtInfoExtend> datas=bzzyExtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryBzzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			BzzyExtInfoExtend bzzyExtInfoExtend=datas.get(0);
			return DataResult.success(bzzyExtInfoExtend);
		}else{
			return DataResult.success(new BzzyExtInfoExtend());
		}
	}

	@RequestMapping("selectBzzyOtherInfo")
	@ResponseBody
	public DataResult<Object> selectBzzyOtherInfo(String bzzyId,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			BzzyGsygInfoExtend queryBzzyGsygInfoExtend=new BzzyGsygInfoExtend();
			queryBzzyGsygInfoExtend.setBzzyId(bzzyId);
			List<BzzyGsygInfoExtend> datas=bzzyGsygInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryBzzyGsygInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggxs)){
			BzzyXbmggInfoExtend queryBzzyXbmggInfoExtend=new BzzyXbmggInfoExtend();
			queryBzzyXbmggInfoExtend.setBzzyId(bzzyId);
			List<BzzyXbmggInfoExtend> datas=bzzyXbmggInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryBzzyXbmggInfoExtend),this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("3".equals(ggxs)){
			BzzyRwInfoExtend queryBzzyRwInfoExtend=new BzzyRwInfoExtend();
			queryBzzyRwInfoExtend.setBzzyId(bzzyId);
			List<BzzyRwInfoExtend> datas=bzzyRwInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyRwInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("4".equals(ggxs)){
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
	public DataResult<Integer> delete(String wid,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			bzzyGsygInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
			
		}else if("2".equals(ggxs)){
			bzzyXbmggInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
		}else if("3".equals(ggxs)){
			
			bzzyRwInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
		}else if("4".equals(ggxs)){
			bzzyJyInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
		}
		return DataResult.success(1);
	}
	@ResponseBody
	@RequestMapping("sh")
	public DataResult<Integer> sh(String wid,String shzt)throws Exception{
		return bzzyInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
	

}
