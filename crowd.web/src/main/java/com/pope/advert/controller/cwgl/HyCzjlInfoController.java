package com.pope.advert.controller.cwgl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeWithHBServiceImpl;
import com.pope.advert.common.code.YhhyztEnum;
import com.pope.advert.common.code.ZfztEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.cwgl.CwglCzjlInfo;
import com.pope.advert.entity.cwgl.CwglDjxxInfo;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.yhgl.YhglDjxxInfo;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.cwgl.CwglCzjlInfoService;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.properties.config.ZfbQrcodeConfig;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DecimalUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("cwgl/czjl")
public class HyCzjlInfoController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(HyCzjlInfoController.class);
	private static AlipayClient alipayClient;
	@Autowired
	private CwglDjxxInfoService cwglDjxxInfoService;

	@Autowired
	private CwglCzjlInfoService cwglCzjlInfoService;
	@Autowired
	private YhglDjxxInfoServie yhglDjxxInfoServie;
	@Autowired
	private ZfbQrcodeConfig zfbConfig;
	static {
		 

	}

	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String pageType,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cwgl/czjl");
		request.setAttribute("pageType", "1");
		mv.addObject("pageType","1");
		mv.addObject("djxx",
				cwglDjxxInfoService.selectByCondition(ConditionUtil.createCondition(new CwglDjxxInfoExtend()),
						this.createCustomOperateLog()).getDatas());
		return mv;
	}

	@RequestMapping("list")
	@ResponseBody
	public DataResult<List<CwglCzjlInfoExtend>> list(Integer pageNum,Integer pageSize) throws Exception{
		CwglCzjlInfoExtend queryCwglCzjlInfoExtend=new CwglCzjlInfoExtend();
		queryCwglCzjlInfoExtend.setYhid(this.getYhId());
		return cwglCzjlInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryCwglCzjlInfoExtend, new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	@RequestMapping("selectDjxx")
	@ResponseBody
	public DataResult<CwglDjxxInfo> selectDjxx(String wid) throws Exception {
		return cwglDjxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}

	/**
	 * 
	 * @param dj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("recharge")
	@ResponseBody
	@AuthIsSupplyAnnotation
	public DataResult<String> recharge(String dj, Integer nx) throws Exception {
		return cwglCzjlInfoService.recharge(dj, nx, this.createCustomOperateLog());
	}

	String key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCpe5l9TRNDpYn/O0VWYCfqvZcMbB3OoefKn/C5lp1tVfOz354bqXPe4TlnaXET+Z2spR+SgIj9X5+gIUFjusfjqWlP9aEMHU+nr30RJPnN8fdjbcPXAbBx+ZXe4MiP8uE6d+Q9s8vvEZkdUd2M0B+FsJCXskn6k2VFspqK+yzShD3UJ14CfvoL2b07XSljx+uBaC8opq0LI7QE78dwlpNuLF7ueYa/de6oUMJIeadwnYPbo7toGlyV8WyvxRiJBfCisnPjANrLx16UYIEtPjlfjKHlgKLSdsOQ1TYg753MRMETe6OGMu5rZOvyIT/4AZCrUySNxlWyCj6O/gJY3qyDAgMBAAECggEAHGu7q4V3S4rA/2oDEJ8DUpwEbnLa9MG1ywbTKWwWbjVRrsI7E0xxP9jo9Wx7J+xeAouWJc0kK8kTTZkGDCFQT98i5+O64/suVmJZSLy4n06KO8Q2aSHBYvuFpGBxgaIrHtDoF2jFNAvxbzdBPdHQ12xqcuXU/g4ll3CB9fh05cA87Wwj8hlkEiGVfdMPmZTItDxUumwmbt/bh5C/bC6+WauCHlsMqwpQ8d0P7mI9skm65aNwrbF28gquV5MORL2RZq01gWQH9yfQMp+Ix+oY0yLTz33aTPE1zBXb+S6iBAuz712dlgoHR4Bns9/PnLui1WPMBYQA6WqA5CcW8cG4wQKBgQDsFQaADxzJBKAbpEs7ryEz1VNU4+9u18JTTiggf/rokxQVfCTONwsk+Fc9YEt9O5S8oIWTUNwy521MQUCwTtC+fb0pb77A8R1kowBI06YH8VkTWV691VrYYOS/bJoOxYe4NJIFvcwsHXeWUF/gdB5KIbWcNBe2J03amAhM/efNEwKBgQC3yCQ8bNp6LqV9o1s5fTPrIMKCbs+KuHmYEuClkTE/meAPcq0qz4impjDqttb/SZfGdCIn4MdBf+Py6NMBIiAudU7UDn/kNDX83iQurCyayIsSwZOS1fyYLyfDFYyBIJnoa7YdWSigci4EVGJkfMcBwAPmVX0XJXe2gMRYrCbA0QKBgCGyFo1smsUuPdP0LTDFnE2ToyM4rVH6xaeyPhP1cFCFvZYbc/1i6dpK/9iox92GBYKuvqH6JpO1aGo73gnMFgs6Uyd45ZcQUwusIDxEySvVDMuwM8+QhjjgC4Yu8AYvt2FZT4Y2QtABHLJ9olGdAT2/dfZnkQLUtU3/6R9kFhO1AoGAXf1ostKE5cnnbxrVc9BZdh3Z/HUJhYuU/DZjV6mqwzlCAwSGFYfv/jKuf8ukpwkPKzqHoVdu8Euk271A9KpsRPZPq1oDBEXDeqBtZsU9RqfboGsJuyXfOkGbl0T1B7ERpXE4wUew5GWgrSwu6e96o6V9GRaNlAHgeKDgSe05IJECgYAnT35/J64Y7M26lDhfxxJtEsx+6JozxodAQL6Ll2aJYZej/eqJ5xOSeI01WQt6/BsUqPnLxIdcHWF48KIVGHdVzINWIUfnPe0koaoZtIhrZRa7vKUu2tVNHoO1Zm4ALmMv4nLlsAoC5A9qtwnVlhjutI1zovsaLaqn6SmDyHALrA==";
	String pub_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqXuZfU0TQ6WJ/ztFVmAn6r2XDGwdzqHnyp/wuZadbVXzs9+eG6lz3uE5Z2lxE/mdrKUfkoCI/V+foCFBY7rH46lpT/WhDB1Pp699EST5zfH3Y23D1wGwcfmV3uDIj/LhOnfkPbPL7xGZHVHdjNAfhbCQl7JJ+pNlRbKaivss0oQ91CdeAn76C9m9O10pY8frgWgvKKatCyO0BO/HcJaTbixe7nmGv3XuqFDCSHmncJ2D26O7aBpclfFsr8UYiQXworJz4wDay8delGCBLT45X4yh5YCi0nbDkNU2IO+dzETBE3ujhjLua2Tr8iE/+AGQq1MkjcZVsgo+jv4CWN6sgwIDAQAB";
	@RequestMapping("changePage")
	public ModelAndView changePage(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("cwgl/confirm");
		mv.addObject("wid", wid);
		return mv;
	}
	@RequestMapping("rechargePage")
	@ResponseBody
	public DataResult<String> openRechargePage(String wid) throws Exception {
		CwglCzjlInfo cwglCzjl = cwglCzjlInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas();
		if (!cwglCzjl.getYhid().equals(this.createCustomOperateLog().getUserId())) {
			throw new ServiceException("该订单不是您本人的订单，无法支付该订单！");
		}
		CwglDjxxInfo cwglDjxx = cwglDjxxInfoService.selectByPrimaryKey(cwglCzjl.getDj(), this.createCustomOperateLog())
				.getDatas();

		return DataResult.success(preCreatePage(cwglCzjl, cwglDjxx));
	}

	// 测试当面付2.0生成支付二维码
	public String preCreatePage(CwglCzjlInfo cwglCzjl, CwglDjxxInfo cwglDjxx) throws ServiceException {
		// (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
		// 需保证商户系统端不能重复，建议通过数据库sequence生成，
		String outTradeNo = cwglCzjl.getDdbh();

		// (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
		String subject = "会员充值";

		// (必填) 订单总金额，单位为元，不能超过1亿元
		// 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
		String totalAmount = StringUtil.toStr(cwglCzjl.getJe());

		// (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
		// 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
		// String undiscountableAmount = "0";

		// 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
		// 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
			String sellerId = "";

		// 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
		String body = "充值" + cwglCzjl.getNx() + "年" + cwglDjxx.getName() + ",会员有效期为" + cwglCzjl.getKssj() + "至"
				+ cwglCzjl.getJssj() + "结束。";

		// 商户操作员编号，添加此参数可以为商户操作员做销售统计
		// String operatorId = "test_operator_id";

		// (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
		String storeId = "store_id";

		// 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
		// ExtendParams extendParams = new ExtendParams();
		// extendParams.setSysServiceProviderId("2088100200300400500");

		// 支付超时，定义为120分钟
		String timeoutExpress = "120m";

		alipayClient = new DefaultAlipayClient
				(zfbConfig.getOpenApiDomain(), zfbConfig.getAppId(), zfbConfig.getPrivateKey(), "json", "UTF-8", 
						zfbConfig.getPublicKey(), zfbConfig.getSignType()); 
	    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
	    //alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
	    //alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
	    AlipayTradePagePayModel model=new AlipayTradePagePayModel();
	    model.setBody(body);
	    model.setProductCode("FAST_INSTANT_TRADE_PAY");
	    model.setOutTradeNo(outTradeNo);
	    model.setTotalAmount(totalAmount);
	    model.setSubject(subject);
	  //  alipayRequest.setNotifyUrl("http://4098448.nat123.cc:12177/crowd/cwgl/czjl/notify");
	    alipayRequest.setReturnUrl("http://4098448.nat123.cc:12177/crowd/cwgl/czjl/returnUrl");
	    alipayRequest.setBizModel(model);
	    String form="";
	    try {
	        form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
	    } catch (AlipayApiException e) {
	        e.printStackTrace();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return form;
	}
	@RequestMapping("returnUrl")
	public String  returnUrl(HttpServletRequest request,HttpServletResponse response) throws Exception{
		DataResult<String> result=checkConfirm(request);
		if(result.isSuccess()) {
			return "cwgl/success";
		}else {
			return "cwgl/error";
		}
	}
	@RequestMapping("notify")
	public void  notify(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		DataResult<String> result=checkConfirm(request);
		if(result.isSuccess()) {
			response.getWriter().println("success");
			response.getWriter().close();
		}else {
			response.getWriter().println("fail");
			response.getWriter().close();
		}
	}
	
	private DataResult<String> checkConfirm(HttpServletRequest request) throws Exception{
		DataResult<String> dataResult=DataResult.success("1");
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, zfbConfig.getAplipyPublicKey(), "UTF-8", zfbConfig.getSignType()); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		
		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
		if(signVerified) {//验证成功
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
			String seller_id=new String(request.getParameter("seller_id").getBytes("ISO-8859-1"),"UTF-8");
			
			String app_id=new String(request.getParameter("app_id").getBytes("ISO-8859-1"),"UTF-8");
			
			String total_amount=new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			dataResult=checkConfirm(out_trade_no, seller_id, total_amount, app_id);
			
		}else {//验证失败
			String sWord = AlipaySignature.getSignCheckContentV1(params);
			log.info(sWord);
			dataResult.setSuccess(false);
			dataResult.setMsg("支付宝验证失败");
			
		}
		return dataResult;
	}

	
	private DataResult<String> checkConfirm(String out_trade_no,String seller_id,String total_amount,String app_id)throws Exception {
		DataResult<String> result=DataResult.success("1");
		result.setMsg("订单充值成功！");
		
		CwglCzjlInfoExtend queryCwglCzjlInfoExtend=new CwglCzjlInfoExtend();
		queryCwglCzjlInfoExtend.setDdbh(out_trade_no);
		List<CwglCzjlInfoExtend> czjlDatas=cwglCzjlInfoService.selectByCondition(ConditionUtil.createCondition(queryCwglCzjlInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(czjlDatas)) {
			
			if(zfbConfig.getSellerId().equals(seller_id) && zfbConfig.getAppId().equals(app_id)
				&& (czjlDatas.get(0).getJe().compareTo(DecimalUtil.toDecimal(total_amount))==0)) {
				if(ZfztEnum.XTZFCG.getCode().equals(czjlDatas.get(0).getZfzt())) {
					return result;
				}
				CwglCzjlInfo saveCwglCzjlInfo=new CwglCzjlInfo();
				saveCwglCzjlInfo.setWid(czjlDatas.get(0).getWid());
				saveCwglCzjlInfo.setZfzt(ZfztEnum.XTZFCG.getCode());
				
				YhglDjxxInfoExtend queryYhglDjxxInfoExtend=new YhglDjxxInfoExtend();
				queryYhglDjxxInfoExtend.setYhid(czjlDatas.get(0).getYhid());
				List<YhglDjxxInfoExtend> yhglDjxxDatas=yhglDjxxInfoServie.selectByCondition(ConditionUtil.createCondition(queryYhglDjxxInfoExtend), this.createCustomOperateLog()).getDatas();
				if(CommonUtil.isNotEmptyList(yhglDjxxDatas)) {
					if(YhhyztEnum.QF.getCode().equals(yhglDjxxDatas.get(0).getYhzt())) {//如果用户欠费了
						YhglDjxxInfo saveYhglDjxxInfo=new YhglDjxxInfo();
						saveYhglDjxxInfo.setWid(yhglDjxxDatas.get(0).getWid());
						saveYhglDjxxInfo.setKssj(czjlDatas.get(0).getKssj());
						saveYhglDjxxInfo.setJssj(yhglDjxxDatas.get(0).getJssj());
						saveYhglDjxxInfo.setDj(czjlDatas.get(0).getDj());
						saveYhglDjxxInfo.setYhzt(YhhyztEnum.ZC.getCode());
						CwglDjxxInfo cwglDjxxInfo=cwglDjxxInfoService.selectByPrimaryKey(czjlDatas.get(0).getDj(), this.createCustomOperateLog()).getDatas();
						
						saveYhglDjxxInfo.setZts(cwglDjxxInfo.getGgzyxzsl());
						saveYhglDjxxInfo.setVersion(yhglDjxxDatas.get(0).getVersion());
						saveYhglDjxxInfo.setSyts(cwglDjxxInfo.getGgzyxzsl());
						boolean save=false;
						int i=0;
						while(!save) {
							int count=yhglDjxxInfoServie.updateByVersion(saveYhglDjxxInfo, this.createCustomOperateLog()).getDatas();
							i++;
							
							if(count==1) {
								save=true;
							}else {
								if(i>3) {
									save=true;
									saveCwglCzjlInfo.setZfzt(ZfztEnum.ZFBZFCG.getCode());
									result.setSuccess(false);
									result.setMsg("支付宝支付成功，系统充值失败！");
								}
							}
							
						}
						
						
								
					}
					cwglCzjlInfoService.updateByPrimaryKeySelective(saveCwglCzjlInfo, this.createCustomOperateLog());
				}else {
					result.setSuccess(false);
					result.setMsg("该订单"+out_trade_no+"号不存在！");
					
				}
			}else {
				result.setSuccess(false);
				result.setMsg("该订单"+out_trade_no+"号不存在！");
			}
		}else {
			result.setSuccess(false);
			result.setMsg("该订单"+out_trade_no+"号不存在！");
		}
		return result;
	}
	// 简单打印应答
	private void dumpResponse(AlipayResponse response) {
		if (response != null) {
			log.info(String.format("code:%s, msg:%s", response.getCode(), response.getMsg()));
			if (!StringUtil.isEmpty(response.getSubCode())) {
				log.info(String.format("subCode:%s, subMsg:%s", response.getSubCode(), response.getSubMsg()));
			}
			log.info("body:" + response.getBody());
		}
	}
}
