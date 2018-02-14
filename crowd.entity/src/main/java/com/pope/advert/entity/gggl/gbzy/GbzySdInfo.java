package com.pope.advert.entity.gggl.gbzy;

import java.io.Serializable;

public class GbzySdInfo implements Serializable{
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
    private String gbpdBm;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Long zk;

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
     * @return ZK 
     */
    public Long getZk() {
        return zk;
    }

    /**
     * 
     * @param zk 
     */
    public void setZk(Long zk) {
        this.zk = zk;
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
        sb.append(", gbpdBm=").append(gbpdBm);
        sb.append(", name=").append(name);
        sb.append(", zk=").append(zk);
        sb.append(", gbzyBm=").append(gbzyBm);
        sb.append("]");
        return sb.toString();
    }
}