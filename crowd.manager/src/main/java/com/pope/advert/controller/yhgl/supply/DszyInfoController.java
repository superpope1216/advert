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
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyXbmggInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZzInfoExtend;
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
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("dszyInfo")
public class DszyInfoController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
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
	
	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supply/dszy");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}
	
	@RequestMapping("selectDszyInfo")
	@ResponseBody
	public DataResult<DszyInfoExtend> selectDszyInfo(String wid) throws Exception {
		DszyInfoExtend queryDszyInfoExtend = new DszyInfoExtend();
		queryDszyInfoExtend.setWid(wid);

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
	
	@ResponseBody
	@RequestMapping("delete")
	public DataResult<Integer> delete(String wid,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			dszySdInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
			
		}else if("2".equals(ggxs)){
			dszyLmInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
		}else if("3".equals(ggxs)){
			dszyTbInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
		}else if("4".equals(ggxs)){
			dszyZtInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
		}else if("5".equals(ggxs)){
			dszyGmInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
			
		}else if("6".equals(ggxs)){
			dszyZzInfoService.delete(wid, this.createCustomOperateLog()).getDatas();
		}
		return DataResult.success(1);
	}
	@ResponseBody
	@RequestMapping("sh")
	public DataResult<Integer> sh(String wid,String shzt)throws Exception{
		return dszyInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
}
