package com.pope.advert.entity.gggl;

import java.io.Serializable;

public class DszyTbInfo  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 
     */
    private String name;

    /**
     * 包含频道
     */
    private String bhpd;

    /**
     * 播出次数类型
     */
    private String bcsmBm;

    /**
     * 
     */
    private Integer bcsmNum;

    /**
     * 
     */
    private String fiveHas;

    /**
     * 
     */
    private Long fiveMoney=0l;

    /**
     * 
     */
    private String seventHas;

    /**
     * 
     */
    private Long seventMoney;

    /**
     * 
     */
    private String tenHas;

    /**
     * 
     */
    private Long tenMoney;

    /**
     * 
     */
    private String fifteenHas;

    /**
     * 
     */
    private Long fifteenMoney;

    /**
     * 
     */
    private String twentyHas;

    /**
     * 
     */
    private Long twentyMoney;

    /**
     * 
     */
    private String twentyFiveHas;

    /**
     * 
     */
    private Long twentyFiveMoney;

    /**
     * 
     */
    private String thirtyHas;

    /**
     * 
     */
    private Long thirtyMoney;

    /**
     * 
     */
    private String fortyFiveHas;

    /**
     * 
     */
    private Long fortyFiveMoney;

    /**
     * 
     */
    private String sixtyHas;

    /**
     * 
     */
    private Long sixtyMoney;
    
    /**
     * 
     */
    private String dszyId;

    public String getDszyId() {
		return dszyId;
	}

	public void setDszyId(String dszyId) {
		this.dszyId = dszyId;
	}

	/**
     * 
     * @return wid 
     */
    public String getWid() {
        return wid;
    }

    /**
     * 
     * @param wid 
     */
    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    /**
     * 
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 包含频道
     * @return BHPD 包含频道
     */
    public String getBhpd() {
        return bhpd;
    }

    /**
     * 包含频道
     * @param bhpd 包含频道
     */
    public void setBhpd(String bhpd) {
        this.bhpd = bhpd == null ? null : bhpd.trim();
    }

    /**
     * 播出次数类型
     * @return BCSM_BM 播出次数类型
     */
    public String getBcsmBm() {
        return bcsmBm;
    }

    /**
     * 播出次数类型
     * @param bcsmBm 播出次数类型
     */
    public void setBcsmBm(String bcsmBm) {
        this.bcsmBm = bcsmBm == null ? null : bcsmBm.trim();
    }

    /**
     * 
     * @return BCSM_NUM 
     */
    public Integer getBcsmNum() {
        return bcsmNum;
    }

    /**
     * 
     * @param bcsmNum 
     */
    public void setBcsmNum(Integer bcsmNum) {
        this.bcsmNum = bcsmNum;
    }

    /**
     * 
     * @return FIVE_HAS 
     */
    public String getFiveHas() {
        return fiveHas;
    }

    /**
     * 
     * @param fiveHas 
     */
    public void setFiveHas(String fiveHas) {
        this.fiveHas = fiveHas == null ? null : fiveHas.trim();
    }

    /**
     * 
     * @return FIVE_MONEY 
     */
    public Long getFiveMoney() {
        return fiveMoney;
    }

    /**
     * 
     * @param fiveMoney 
     */
    public void setFiveMoney(Long fiveMoney) {
        this.fiveMoney = fiveMoney;
    }

    /**
     * 
     * @return SEVENT_HAS 
     */
    public String getSeventHas() {
        return seventHas;
    }

    /**
     * 
     * @param seventHas 
     */
    public void setSeventHas(String seventHas) {
        this.seventHas = seventHas == null ? null : seventHas.trim();
    }

    /**
     * 
     * @return SEVENT_MONEY 
     */
    public Long getSeventMoney() {
        return seventMoney;
    }

    /**
     * 
     * @param seventMoney 
     */
    public void setSeventMoney(Long seventMoney) {
        this.seventMoney = seventMoney;
    }

    /**
     * 
     * @return TEN_HAS 
     */
    public String getTenHas() {
        return tenHas;
    }

    /**
     * 
     * @param tenHas 
     */
    public void setTenHas(String tenHas) {
        this.tenHas = tenHas == null ? null : tenHas.trim();
    }

    /**
     * 
     * @return TEN_MONEY 
     */
    public Long getTenMoney() {
        return tenMoney;
    }

    /**
     * 
     * @param tenMoney 
     */
    public void setTenMoney(Long tenMoney) {
        this.tenMoney = tenMoney;
    }

    /**
     * 
     * @return Fifteen_has 
     */
    public String getFifteenHas() {
        return fifteenHas;
    }

    /**
     * 
     * @param fifteenHas 
     */
    public void setFifteenHas(String fifteenHas) {
        this.fifteenHas = fifteenHas == null ? null : fifteenHas.trim();
    }

    /**
     * 
     * @return Fifteen_money 
     */
    public Long getFifteenMoney() {
        return fifteenMoney;
    }

    /**
     * 
     * @param fifteenMoney 
     */
    public void setFifteenMoney(Long fifteenMoney) {
        this.fifteenMoney = fifteenMoney;
    }

    /**
     * 
     * @return Twenty_has 
     */
    public String getTwentyHas() {
        return twentyHas;
    }

    /**
     * 
     * @param twentyHas 
     */
    public void setTwentyHas(String twentyHas) {
        this.twentyHas = twentyHas == null ? null : twentyHas.trim();
    }

    /**
     * 
     * @return Twenty_money 
     */
    public Long getTwentyMoney() {
        return twentyMoney;
    }

    /**
     * 
     * @param twentyMoney 
     */
    public void setTwentyMoney(Long twentyMoney) {
        this.twentyMoney = twentyMoney;
    }

    /**
     * 
     * @return Twenty_five_has 
     */
    public String getTwentyFiveHas() {
        return twentyFiveHas;
    }

    /**
     * 
     * @param twentyFiveHas 
     */
    public void setTwentyFiveHas(String twentyFiveHas) {
        this.twentyFiveHas = twentyFiveHas == null ? null : twentyFiveHas.trim();
    }

    /**
     * 
     * @return Twenty_five_money 
     */
    public Long getTwentyFiveMoney() {
        return twentyFiveMoney;
    }

    /**
     * 
     * @param twentyFiveMoney 
     */
    public void setTwentyFiveMoney(Long twentyFiveMoney) {
        this.twentyFiveMoney = twentyFiveMoney;
    }

    /**
     * 
     * @return Thirty_has 
     */
    public String getThirtyHas() {
        return thirtyHas;
    }

    /**
     * 
     * @param thirtyHas 
     */
    public void setThirtyHas(String thirtyHas) {
        this.thirtyHas = thirtyHas == null ? null : thirtyHas.trim();
    }

    /**
     * 
     * @return Thirty_money 
     */
    public Long getThirtyMoney() {
        return thirtyMoney;
    }

    /**
     * 
     * @param thirtyMoney 
     */
    public void setThirtyMoney(Long thirtyMoney) {
        this.thirtyMoney = thirtyMoney;
    }

    /**
     * 
     * @return Forty_five_has 
     */
    public String getFortyFiveHas() {
        return fortyFiveHas;
    }

    /**
     * 
     * @param fortyFiveHas 
     */
    public void setFortyFiveHas(String fortyFiveHas) {
        this.fortyFiveHas = fortyFiveHas == null ? null : fortyFiveHas.trim();
    }

    /**
     * 
     * @return Forty_five_money 
     */
    public Long getFortyFiveMoney() {
        return fortyFiveMoney;
    }

    /**
     * 
     * @param fortyFiveMoney 
     */
    public void setFortyFiveMoney(Long fortyFiveMoney) {
        this.fortyFiveMoney = fortyFiveMoney;
    }

    /**
     * 
     * @return sixty_has 
     */
    public String getSixtyHas() {
        return sixtyHas;
    }

    /**
     * 
     * @param sixtyHas 
     */
    public void setSixtyHas(String sixtyHas) {
        this.sixtyHas = sixtyHas == null ? null : sixtyHas.trim();
    }

    /**
     * 
     * @return sixty_money 
     */
    public Long getSixtyMoney() {
        return sixtyMoney;
    }

    /**
     * 
     * @param sixtyMoney 
     */
    public void setSixtyMoney(Long sixtyMoney) {
        this.sixtyMoney = sixtyMoney;
    }

    /**
     *
     * @mbggenerated 2017-12-21
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", name=").append(name);
        sb.append(", bhpd=").append(bhpd);
        sb.append(", bcsmBm=").append(bcsmBm);
        sb.append(", bcsmNum=").append(bcsmNum);
        sb.append(", fiveHas=").append(fiveHas);
        sb.append(", fiveMoney=").append(fiveMoney);
        sb.append(", seventHas=").append(seventHas);
        sb.append(", seventMoney=").append(seventMoney);
        sb.append(", tenHas=").append(tenHas);
        sb.append(", tenMoney=").append(tenMoney);
        sb.append(", fifteenHas=").append(fifteenHas);
        sb.append(", fifteenMoney=").append(fifteenMoney);
        sb.append(", twentyHas=").append(twentyHas);
        sb.append(", twentyMoney=").append(twentyMoney);
        sb.append(", twentyFiveHas=").append(twentyFiveHas);
        sb.append(", twentyFiveMoney=").append(twentyFiveMoney);
        sb.append(", thirtyHas=").append(thirtyHas);
        sb.append(", thirtyMoney=").append(thirtyMoney);
        sb.append(", fortyFiveHas=").append(fortyFiveHas);
        sb.append(", fortyFiveMoney=").append(fortyFiveMoney);
        sb.append(", sixtyHas=").append(sixtyHas);
        sb.append(", sixtyMoney=").append(sixtyMoney);
        sb.append("]");
        return sb.toString();
    }
}