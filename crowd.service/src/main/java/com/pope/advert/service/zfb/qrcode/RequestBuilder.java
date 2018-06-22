package com.pope.advert.service.zfb.qrcode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class RequestBuilder {
	 private String appAuthToken;
	 //异步通知地址
	    private String notifyUrl;
	    //同步通知地址
	    private String returnUrl;
	    

		private static Gson gson = new GsonBuilder().create();

	    // 验证请求对象
	    public abstract boolean validate();

	    // 获取bizContent对象，用于下一步转换为json字符串
	    public abstract Object getBizContent();

	    // 将bizContent对象转换为json字符串
	    public String toJsonString() {
	    	return gson.toJson(this.getBizContent());
	    }
	    
	    @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("RequestBuilder{");
	        sb.append("appAuthToken='").append(appAuthToken).append('\'');
	        sb.append(", notifyUrl='").append(notifyUrl).append('\'');
	        sb.append(", returnUrl='").append(returnUrl).append('\'');
	        sb.append('}');
	        return sb.toString();
	    }
	    
	    public String getAppAuthToken() {
			return appAuthToken;
		}

		public void setAppAuthToken(String appAuthToken) {
			this.appAuthToken = appAuthToken;
		}

		public String getNotifyUrl() {
			return notifyUrl;
		}

		public void setNotifyUrl(String notifyUrl) {
			this.notifyUrl = notifyUrl;
		}

		public String getReturnUrl() {
			return returnUrl;
		}

		public void setReturnUrl(String returnUrl) {
			this.returnUrl = returnUrl;
		}
}
	    
