package SmsMessageTempleateEnum;

public enum SmsMessageTempleateEnum {
	TITLE(0,"【中国广告交易网】"),
    REGISTER(1, "验证码：(%s)，请您在5分钟内填写。若非本您人操作，请忽略本短信。"),
    
    BUY(2,"您好，您的广告求购方身份审核（%s）,请及时登陆平台确认。"),
    SUPPLY(3,"您好，您的广告发布方身份审核（%s）,请及时登陆平台确认"),
    AD_QG(4, "您好，您发布的广告求购（%s）,平台审核（%s）,请及时登陆平台确认"),
    AD_GG(5, "您好，您发布的企业公告（%s）,平台审核（%s）,请及时登陆平台确认"),
    AD_NEWS(6, "您好，您发布的企业新闻（%s）,平台审核（%s）,请及时登陆平台确认"),
    AD_ZS(7, "您好，您发布的广告招商（%s）,平台审核（%s）,请及时登陆平台确认"),
    AD_HZ(8, "您好，您发布的广告合作（%s）,平台审核（%s）,请及时登陆平台确认"),
    AD_DL(9, "您好，您发布的广告代理（%s）,平台审核（%s）,请及时登陆平台确认"),
    AD(10, "您好，您发布的广告（%s）,平台审核（%s）,请及时登陆平台确认");
    
    private int    code;

    private String name;

    SmsMessageTempleateEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
