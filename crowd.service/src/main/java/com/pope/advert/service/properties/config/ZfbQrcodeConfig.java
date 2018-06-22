package com.pope.advert.service.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ZfbQrcodeConfig {

	@Value("${zfb.open_api_domain}")
	private String openApiDomain;
	@Value("${zfb.appid}")
	private String appId;
	@Value("${zfb.private_key}")
	private String privateKey;
	@Value("${zfb.public_key}")
	private String publicKey;
	@Value("${zfb.sign_type}")
	private String signType;
	@Value("${zfb.max_query_retry}")
	private String maxQueryRetry;
	@Value("${zfb.query_duration}")
	private String queryDuration;
	@Value("${max_cancel_retry}")
	private String maxCancelRetry;
	@Value("${zfb.alipay_public_key}")
	private String aplipyPublicKey;
	@Value("${zbf.seller_id}")
	private String sellerId;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getAplipyPublicKey() {
		return aplipyPublicKey;
	}

	public void setAplipyPublicKey(String aplipyPublicKey) {
		this.aplipyPublicKey = aplipyPublicKey;
	}

	public String getOpenApiDomain() {
		return openApiDomain;
	}

	public void setOpenApiDomain(String openApiDomain) {
		this.openApiDomain = openApiDomain;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getMaxQueryRetry() {
		return maxQueryRetry;
	}

	public void setMaxQueryRetry(String maxQueryRetry) {
		this.maxQueryRetry = maxQueryRetry;
	}

	public String getQueryDuration() {
		return queryDuration;
	}

	public void setQueryDuration(String queryDuration) {
		this.queryDuration = queryDuration;
	}

	public String getMaxCancelRetry() {
		return maxCancelRetry;
	}

	public void setMaxCancelRetry(String maxCancelRetry) {
		this.maxCancelRetry = maxCancelRetry;
	}
	
}
