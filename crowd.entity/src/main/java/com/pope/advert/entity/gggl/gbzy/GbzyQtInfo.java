package com.pope.advert.entity.gggl.gbzy;

import java.io.Serializable;

public class GbzyQtInfo implements Serializable{
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
     * 
     */
    private String gbpdBm;

    /**
     * 
     */
    private Long ztMoney;

    /**
     * 
     */
    private Long lbMoney;

    /**
     * 
     */
    private Long gmMoney;

    /**
     * 
     */
    private Long tyMoney;

    /**
     * 
     */
    private Long zdbsMoney;

    /**
     * 
     */
    private String gbzyBm;

    /**
     * 
     * @return WID 
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
     * 
     * @return GBPD_BM 
     */
    public String getGbpdBm() {
        return gbpdBm;
    }

    /**
     * 
     * @param gbpdBm 
     */
    public void setGbpdBm(String gbpdBm) {
        this.gbpdBm = gbpdBm == null ? null : gbpdBm.trim();
    }

    /**
     * 
     * @return ZT_MONEY 
     */
    public Long getZtMoney() {
        return ztMoney;
    }

    /**
     * 
     * @param ztMoney 
     */
    public void setZtMoney(Long ztMoney) {
        this.ztMoney = ztMoney;
    }

    /**
     * 
     * @return LB_MONEY 
     */
    public Long getLbMoney() {
        return lbMoney;
    }

    /**
     * 
     * @param lbMoney 
     */
    public void setLbMoney(Long lbMoney) {
        this.lbMoney = lbMoney;
    }

    /**
     * 
     * @return GM_MONEY 
     */
    public Long getGmMoney() {
        return gmMoney;
    }

    /**
     * 
     * @param gmMoney 
     */
    public void setGmMoney(Long gmMoney) {
        this.gmMoney = gmMoney;
    }

    /**
     * 
     * @return TY_MONEY 
     */
    public Long getTyMoney() {
        return tyMoney;
    }

    /**
     * 
     * @param tyMoney 
     */
    public void setTyMoney(Long tyMoney) {
        this.tyMoney = tyMoney;
    }

    /**
     * 
     * @return ZDBS_MONEY 
     */
    public Long getZdbsMoney() {
        return zdbsMoney;
    }

    /**
     * 
     * @param zdbsMoney 
     */
    public void setZdbsMoney(Long zdbsMoney) {
        this.zdbsMoney = zdbsMoney;
    }

    /**
     * 
     * @return GBZY_BM 
     */
    public String getGbzyBm() {
        return gbzyBm;
    }

    /**
     * 
     * @param gbzyBm 
     */
    public void setGbzyBm(String gbzyBm) {
        this.gbzyBm = gbzyBm == null ? null : gbzyBm.trim();
    }

    /**
     *
     * @mbggenerated 2017-12-24
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", name=").append(name);
        sb.append(", gbpdBm=").append(gbpdBm);
        sb.append(", ztMoney=").append(ztMoney);
        sb.append(", lbMoney=").append(lbMoney);
        sb.append(", gmMoney=").append(gmMoney);
        sb.append(", tyMoney=").append(tyMoney);
        sb.append(", zdbsMoney=").append(zdbsMoney);
        sb.append(", gbzyBm=").append(gbzyBm);
        sb.append("]");
        return sb.toString();
    }
}