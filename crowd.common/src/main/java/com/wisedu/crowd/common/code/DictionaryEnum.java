package com.wisedu.crowd.common.code;

public enum DictionaryEnum {

	T_ADVERT_SJZD_GGXS("T_ADVERT_SJZD_GGXS","广告形式"),
	
	T_ADVERT_SJZD_XZQH("T_ADVERT_SJZD_XZQH","行政区域"),
	T_ADVERT_SJZD_DST("T_ADVERT_SJZD_DST","电视台"),
	T_ADVERT_SJZD_HY("T_ADVERT_SJZD_HY","行业"),
	T_ADVERT_SJZD_GGDLFS("T_ADVERT_SJZD_GGDLFS","广告代理方式"),
	T_ADVERT_SJZD_LX("T_ADVERT_SJZD_GGLX","广告类型"),
	T_CROWD_SJZD_SDPD("T_CROWD_SJZD_SDPD","电视频道"),
	T_ADVERT_SJZD_SHZT("T_ADVERT_SJZD_SHZT","审核状态"),
	T_ADVERT_SJZD_DLLM("T_ADVERT_SJZD_DLLM","代理栏目"),
	T_ADVERT_SJZD_TBBCCSLX("T_ADVERT_SJZD_TBBCCSLX","套播播出次数类型"),
	T_ADVERT_SJZD_ZTSJD("T_ADVERT_SJZD_ZTSJD","专题时间段"),
	T_ADVERT_SJZD_GMGGJGPC("T_ADVERT_SJZD_GMGGJGPC","冠名广告价格频次"),
	T_ADVERT_SJZD_GBLX("T_ADVERT_SJZD_GBLX","广播类型"),
	T_ADVERT_SJZD_GBDST("T_ADVERT_SJZD_GBDST","广播电视台"),
	T_ADVERT_SJZD_GBDSTPD("T_ADVERT_SJZD_GBDSTPD","广播电视台频道"),
	T_ADVERT_SJZD_BZXX("T_ADVERT_SJZD_BZXX","报纸信息"),
	T_ADVERT_SJZD_BZLX("T_ADVERT_SJZD_BZLX","报纸类型"),
	T_ADVERT_SJZD_XBMGGLX("T_ADVERT_SJZD_XBMGGLX","报纸资源小版面广告类型"),
	T_ADVERT_SJZD_BZYS("T_ADVERT_SJZD_BZYS","报纸颜色"),
	T_ADVERT_SJZD_ZZZYLX("T_ADVERT_SJZD_ZZZYLX","杂志资源类型"),
	T_ADVERT_SJZD_ZZXX("T_ADVERT_SJZD_ZZXX","杂志信息"),
	T_ADVERT_SJZD_WLGZWZ("T_ADVERT_SJZD_WLGZWZ","网络资源位置"),
	T_ADVERT_SJZD_GGLX("T_ADVERT_SJZD_GGLX","广告类型"),
	
	
	T_ADVERT_SJZD_XMTLX("T_ADVERT_SJZD_XMTLX","新媒体类型"),
	
	T_ADVERT_SJZD_XMTZY_SZRQ("T_ADVERT_SJZD_XMTZY_SZRQ","受众人群"),
	
	T_ADVERT_SJZD_XMTZY_JYCD("T_ADVERT_SJZD_XMTZY_JYCD","教育程度"),
	
	T_ADVERT_SJZD_XMTZY_ZYFB("T_ADVERT_SJZD_XMTZY_ZYFB","职业分布"),
	
	T_ADVERT_SJZD_XMTZY_SRZK("T_ADVERT_SJZD_XMTZY_SRZK","收入状况"),
	
	T_ADVERT_SJZD_COMPANYXZ("T_ADVERT_SJZD_COMPANYXZ","公司性质"),
	
	T_ADVERT_SJZD_COMPANY_NYYE("T_ADVERT_SJZD_COMPANY_NYYE","公司营业额"),
	
	T_ADVERT_SJZD_COMPANY_ZZLX("T_ADVERT_SJZD_COMPANY_ZZLX","企业资质类型"),
	
	T_ADVERT_SJZD_SJLX("T_ADVERT_SJZD_SJLX","商机类型");
	
    private String code;

    private String name;

    DictionaryEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
