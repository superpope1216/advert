package com.pope.advert.entity.gggl.bzzy;

import java.io.Serializable;

public class BzzyExtInfo implements Serializable{
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
    private String bcsm;

    /**
     * 
     */
    private String ggdlfs;

    /**
     * 
     */
    private String dlzslj;

    /**
     * 
     */
    private String sctulj;

    /**
     * 
     */
    private String bzzyId;

    /**
     * 
     */
    private String sfxzhy;

    /**
     * 
     */
    private String hy;

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
     * @return BCSM 
     */
    public String getBcsm() {
        return bcsm;
    }

    /**
     * 
     * @param bcsm 
     */
    public void setBcsm(String bcsm) {
        this.bcsm = bcsm == null ? null : bcsm.trim();
    }

    /**
     * 
     * @return GGDLFS 
     */
    public String getGgdlfs() {
        return ggdlfs;
    }

    /**
     * 
     * @param ggdlfs 
     */
    public void setGgdlfs(String ggdlfs) {
        this.ggdlfs = ggdlfs == null ? null : ggdlfs.trim();
    }

    /**
     * 
     * @return DLZSLJ 
     */
    public String getDlzslj() {
        return dlzslj;
    }

    /**
     * 
     * @param dlzslj 
     */
    public void setDlzslj(String dlzslj) {
        this.dlzslj = dlzslj == null ? null : dlzslj.trim();
    }

    /**
     * 
     * @return SCTULJ 
     */
    public String getSctulj() {
        return sctulj;
    }

    /**
     * 
     * @param sctulj 
     */
    public void setSctulj(String sctulj) {
        this.sctulj = sctulj == null ? null : sctulj.trim();
    }

    /**
     * 
     * @return BZZY_ID 
     */
    public String getBzzyId() {
        return bzzyId;
    }

    /**
     * 
     * @param bzzyId 
     */
    public void setBzzyId(String bzzyId) {
        this.bzzyId = bzzyId == null ? null : bzzyId.trim();
    }

    /**
     * 
     * @return SFXZHY 
     */
    public String getSfxzhy() {
        return sfxzhy;
    }

    /**
     * 
     * @param sfxzhy 
     */
    public void setSfxzhy(String sfxzhy) {
        this.sfxzhy = sfxzhy == null ? null : sfxzhy.trim();
    }

    /**
     * 
     * @return HY 
     */
    public String getHy() {
        return hy;
    }

    /**
     * 
     * @param hy 
     */
    public void setHy(String hy) {
        this.hy = hy == null ? null : hy.trim();
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
        sb.append(", bcsm=").append(bcsm);
        sb.append(", ggdlfs=").append(ggdlfs);
        sb.append(", dlzslj=").append(dlzslj);
        sb.append(", sctulj=").append(sctulj);
        sb.append(", bzzyId=").append(bzzyId);
        sb.append(", sfxzhy=").append(sfxzhy);
        sb.append(", hy=").append(hy);
        sb.append("]");
        return sb.toString();
    }
}