package com.pope.advert.controller.supplyview.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZzInfoExtend;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyGmInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszyLmInfoService;
import com.pope.advert.service.supply.DszySdInfoService;
import com.pope.advert.service.supply.DszyTbInfoService;
import com.pope.advert.service.supply.DszyZtInfoService;
import com.pope.advert.service.supply.DszyZzInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("supplyDszyDetail")
public class SupplyDszyDetailController extends BaseController{

	@Autowired
	private DszyInfoService dszyInfoService;
	@Autowired
	private DszyExtInfoService dszyExtInfoService;
	@Autowired
	private DszySdInfoService dszySdInfoService;
	
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
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid,String ggxs) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("ggxs", ggxs);
		mv.addObject("wid", wid);
		mv.setViewName("supplyview/detail/dszyDetail");
		return mv;
	}
	
	@RequestMapping("selectDszyInfo")
	@ResponseBody
	public DataResult<DszyInfoExtend> selectDszyInfo(String wid) throws Exception {
		DszyInfoExtend queryDszyInfoExtend = new DszyInfoExtend();
		queryDszyInfoExtend.setWid(wid);
		queryDszyInfoExtend.setShzt(ShztEnum.YTG.getCode());
		List<DszyInfoExtend> datas = dszyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryDszyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new DszyInfoExtend());
		}
	}
	
	@RequestMapping("selectDszyExtInfo")
	@ResponseBody
	public DataResult<DszyExtInfoExtend> selectDszyExtInfo(String dszyId) throws Exception{
		DszyExtInfoExtend queryDszyExtInfoExtend=new DszyExtInfoExtend();
		queryDszyExtInfoExtend.setDszyId(dszyId);
		List<DszyExtInfoExtend> datas=dszyExtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDszyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}else{
			return DataResult.success(new DszyExtInfoExtend());
		}
	}
	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid) throws Exception{
		DszyInfoExtend queryDszyInfoExtend = new DszyInfoExtend();
		queryDszyInfoExtend.setWid(wid);
		queryDszyInfoExtend.setShzt(ShztEnum.YTG.getCode());
		List<DszyInfoExtend> datas = dszyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryDszyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			DszyInfoExtend dszyInfoExtend=datas.get(0);
			CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
			queryCompanyInfoExtend.setRegisterId(dszyInfoExtend.getRegisterId());
			
			List<CompanyInfoExtend> companyInfoDatas=companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(companyInfoDatas)){
				CompanyInfoExtend companyInfoExtend=companyInfoDatas.get(0);
				CompanyInfoExtend retCompanyInfoExtend=new CompanyInfoExtend();
				retCompanyInfoExtend.setWid(companyInfoExtend.getWid());
				retCompanyInfoExtend.setName(companyInfoExtend.getName());
				retCompanyInfoExtend.setGslog(companyInfoExtend.getGslog());
				return DataResult.success(retCompanyInfoExtend);
			}
		}
		return DataResult.success(new CompanyInfoExtend());
	}
	
	@RequestMapping("selectDszyOtherInfo")
	@ResponseBody
	public DataResult<Object> selectDszyOtherInfo(String dszyId,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			DszySdInfoExtend queryDszySdInfoExtend=new DszySdInfoExtend();
			queryDszySdInfoExtend.setDszyId(dszyId);
			List<DszySdInfoExtend> datas=dszySdInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDszySdInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggxs)){
			DszyLmInfoExtend queryDszyLmInfoExtend=new DszyLmInfoExtend();
			queryDszyLmInfoExtend.setDszyId(dszyId);
			List<DszyLmInfoExtend> datas=dszyLmInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDszyLmInfoExtend),this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("3".equals(ggxs)){
			
			DszyTbInfoExtend queryDszyTbInfoExtend=new DszyTbInfoExtend();
			queryDszyTbInfoExtend.setDszyId(dszyId);
			List<DszyTbInfoExtend> datas=dszyTbInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDszyTbInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0)); 
			}
			
		}else if("4".equals(ggxs)){
			DszyZtInfoExtend queryDszyZtInfoExtend=new DszyZtInfoExtend();
			queryDszyZtInfoExtend.setDszyId(dszyId);
			List<DszyZtInfoExtend> datas=dszyZtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDszyZtInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}else if("5".equals(ggxs)){
			DszyGmInfoExtend queryDszyGmInfoExtend=new DszyGmInfoExtend();
			queryDszyGmInfoExtend.setDszyId(dszyId);
			List<DszyGmInfoExtend> datas=dszyGmInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDszyGmInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}else if("6".equals(ggxs)){
			DszyZzInfoExtend queryDszyZzInfoExtend=new DszyZzInfoExtend();
			queryDszyZzInfoExtend.setDszyId(dszyId);
			List<DszyZzInfoExtend> datas=dszyZzInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDszyZzInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}
		return DataResult.success(null);
		
	}
}
