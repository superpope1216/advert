package com.pope.advert.controller.zfb;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

@Controller
@RequestMapping("zfbTest")
public class ZfbTestController {

	String key="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCgPkwco/irmsIFollbTW7CpWB4Xe4ZUhQvQW0fKyIjjqxKuXq3I4ItqRpsaWn0w2pFI4+ZJcw1d09OsnP7CqIyCHg8mAwvfqZ+u5gKWpxL/KBJFH0zPXP1v0ddVNn6H59wFdPOnYNd1tANEONobSed+inbcVDyQC6HFdHUNm2bdpfx2JD5khFtSwIFI7OKj1CTajtTH94uAt1VdcADzLl+f63n7MHg56C2mrYjFMHzwMBDKd3VMBTcdyMbsf0r2Qsd3Nl8Fzat4fLR5s5ZdM+0i/CFofkSZahXoBPe0m+OhVO4vHB1pVcoOIqoJwtkrlVLk9GiGDU/6ZZ7uUERe85xAgMBAAECggEAOrf5Tflr8v4HoObn1YQfVSYinpjU2eRwzwwrf2Nf5CWwzsT+ycMyPaccrqNGF1HQTDuGsDjghqsMnarYwyIXYzwlSxbwSCshuYjmYsznPxT4ay8d3bvkFSYdcX7ZTUVvODRXY/vmGmnP3SnWGvr8rG/yDJ6OaebI5elB9YBoU7HhFNf92NIt7EUYhX92boF43n2/ochQ4sBofzqz8oL+4JNk2LNLnyzPD9VHf3irr6xvBiaLJbJ2/F1B9+leI7Uep1Y+Opey3mR2Ji6cwIVoKdws4cndXDJVSd/DkzFxQf/UYRrlwitm66hU+H3uwCxdcKLSK6QhvY9F15rtPC31wQKBgQDh0RGbrwfqIpAHL+enXDMnwDgADVjELb6Vrr601aB8LVH7iIYLe/O3g3RffKw0DFK7knfT7CYKySZQE2Bu6RwBP/caRooTTA3hWpQUemT55B4lUkLr1SP1vP375JcV0bUqOU2XvMR6LFRyMSvMLwvMeRxfcSeazCHxllS5jP0NuQKBgQC1qXV/ajMYkM8eaOLuQkCpz7miMy005UBKV2cHHdpbGxDAF1EXLqKt3rrDzOvUoSWmmUprmJTmYzhzuDc5lmU3sy8U6tjG1L1eB7GyXYJWchLVrgnl5H550ORcs/X94uELI4e3wr9xcfgbvUDSefFmuz8Og+SNr1OVmaqe31vieQKBgQDMUcDe3pYIsVEkT6II+hGHLBL/aRQiHUnOYZhIQuq8sLz3HGY8yeCQ8S5An6uoRGYvNa2aYJdjNvGljoK4l88xClFowt536167wpstlDj9KfxkxHOssuOgm2ormn9hzKdhFwwv+SrFaIrX78mzK/Y/Am47pUSyeXVVBDKQ2RK2cQKBgFovvv16o9NWUP0v5TmT+rZTQj2cWp0gE0LVEXkfAQCp9y7mZIO1y122bdI3Mf1l42NKRwATyBh4udX5ZrFYUPfOJVmlHenYRAsilr2OXt67003yEUfooEGpyzWawk1BDaiSAxbfwFt50Us0MbJMh+QQocV7BUSx/jUPDP3CtcNBAoGADcJNFeufVkfcdvRMCKT7/8Oa3ir9E7G6St1M4/NRhwphHh8nW826MmnSQ8eLXXbaVrAHfKw8ko8nkdWL2ofiS3naeqjUFwl5CPC3hHtXFgxbaE3o+xpW7pvyKr6aO8GU6t+dLiw7Pet09EUYQB+R0IUV7GXuD4z43Jeg9dYJCHM=";
	String pub_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoD5MHKP4q5rCBaJZW01uwqVgeF3uGVIUL0FtHysiI46sSrl6tyOCLakabGlp9MNqRSOPmSXMNXdPTrJz+wqiMgh4PJgML36mfruYClqcS/ygSRR9Mz1z9b9HXVTZ+h+fcBXTzp2DXdbQDRDjaG0nnfop23FQ8kAuhxXR1DZtm3aX8diQ+ZIRbUsCBSOzio9Qk2o7Ux/eLgLdVXXAA8y5fn+t5+zB4Oegtpq2IxTB88DAQynd1TAU3HcjG7H9K9kLHdzZfBc2reHy0ebOWXTPtIvwhaH5EmWoV6AT3tJvjoVTuLxwdaVXKDiKqCcLZK5VS5PRohg1P+mWe7lBEXvOcQIDAQAB";
	@RequestMapping("test")
	@ResponseBody
	public String test() throws UnsupportedEncodingException {
		AlipayClient alipayClient = new DefaultAlipayClient
				("https://openapi.alipaydev.com/gateway.do", 
						"2016091000480995", key, "json", "UTF-8", 
						pub_key, "RSA2"); //获得初始化的AlipayClient
	    AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
	    //alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
	    //alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
	    String subject=new String("云中国".getBytes(),"UTF-8");
	    alipayRequest.setBizContent("{" +
	        "    \"out_trade_no\":\"20180501000038\"," +
	        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
	        "    \"total_amount\":11," +
	        "    \"subject\":\""+subject+"\"," +
	        "    \"body\":\""+subject+"\"" +
	        "  }");//填充业务参数
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
}
