package com.pope.advert.entity.xtgl;

import java.io.Serializable;
import java.util.Date;

public class FjxxInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 附件路径
     */
    private String wjlj;

    /**
     * 附件名称
     */
    private String wjmc;

    /**
     * 附件原始名称
     */
    private String wjxsmc;

    /**
     * 上传人ID
     */
    private String scrid;

    /**
     * 上传者手机号
     */
    private String scrxm;

    /**
     * 上传时间
     */
    private Date scsj;

    /**
     * 上传ip
     */
    private String scrip;

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
     * 附件路径
     * @return WJLJ 附件路径
     */
    public String getWjlj() {
        return wjlj;
    }

    /**
     * 附件路径
     * @param wjlj 附件路径
     */
    public void setWjlj(String wjlj) {
        this.wjlj = wjlj == null ? null : wjlj.trim();
    }

    /**
     * 附件名称
     * @return WJMC 附件名称
     */
    public String getWjmc() {
        return wjmc;
    }

    /**
     * 附件名称
     * @param wjmc 附件名称
     */
    public void setWjmc(String wjmc) {
        this.wjmc = wjmc == null ? null : wjmc.trim();
    }

    /**
     * 附件原始名称
     * @return WJXSMC 附件原始名称
     */
    public String getWjxsmc() {
        return wjxsmc;
    }

    /**
     * 附件原始名称
     * @param wjxsmc 附件原始名称
     */
    public void setWjxsmc(String wjxsmc) {
        this.wjxsmc = wjxsmc == null ? null : wjxsmc.trim();
    }

    /**
     * 上传人ID
     * @return SCRID 上传人ID
     */
    public String getScrid() {
        return scrid;
    }

    /**
     * 上传人ID
     * @param scrid 上传人ID
     */
    public void setScrid(String scrid) {
        this.scrid = scrid == null ? null : scrid.trim();
    }

    /**
     * 上传者手机号
     * @return SCRXM 上传者手机号
     */
    public String getScrxm() {
        return scrxm;
    }

    /**
     * 上传者手机号
     * @param scrxm 上传者手机号
     */
    public void setScrxm(String scrxm) {
        this.scrxm = scrxm == null ? null : scrxm.trim();
    }

    /**
     * 上传时间
     * @return SCSJ 上传时间
     */
    public Date getScsj() {
        return scsj;
    }

    /**
     * 上传时间
     * @param scsj 上传时间
     */
    public void setScsj(Date scsj) {
        this.scsj = scsj;
    }

    /**
     * 上传ip
     * @return SCRIP 上传ip
     */
    public String getScrip() {
        return scrip;
    }

    /**
     * 上传ip
     * @param scrip 上传ip
     */
    public void setScrip(String scrip) {
        this.scrip = scrip == null ? null : scrip.trim();
    }

    /**
     *
     * @mbggenerated 2018-01-16
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", wjlj=").append(wjlj);
        sb.append(", wjmc=").append(wjmc);
        sb.append(", wjxsmc=").append(wjxsmc);
        sb.append(", scrid=").append(scrid);
        sb.append(", scrxm=").append(scrxm);
        sb.append(", scsj=").append(scsj);
        sb.append(", scrip=").append(scrip);
        sb.append("]");
        return sb.toString();
    }
}