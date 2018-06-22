package com.pope.advert.entity.cwgl;

import java.io.Serializable;
import java.math.BigDecimal;

public class CwglCzjlInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 用户ID
     */
    private String yhid;

    /**
     * 等级ID
     */
    private String dj;

    /**
     * 
     */
    private String kssj;

    /**
     * 
     */
    private String jssj;

    /**
     * 
     */
    private String cjsj;

    /**
     * 
     */
    private String ip;

    /**
     * 系统支付状态
     */
    private String zfzt;

    /**
     * 支付宝账号
     */
    private String zfbbh;

    /**
     * 订单编号
     */
    private String ddbh;

    /**
     * 年限
     */
    private Integer nx;

    /**
     * 
     */
    private BigDecimal je;

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
     * 用户ID
     * @return YHID 用户ID
     */
    public String getYhid() {
        return yhid;
    }

    /**
     * 用户ID
     * @param yhid 用户ID
     */
    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    /**
     * 等级ID
     * @return DJ 等级ID
     */
    public String getDj() {
        return dj;
    }

    /**
     * 等级ID
     * @param dj 等级ID
     */
    public void setDj(String dj) {
        this.dj = dj == null ? null : dj.trim();
    }

    /**
     * 
     * @return KSSJ 
     */
    public String getKssj() {
        return kssj;
    }

    /**
     * 
     * @param kssj 
     */
    public void setKssj(String kssj) {
        this.kssj = kssj == null ? null : kssj.trim();
    }

    /**
     * 
     * @return JSSJ 
     */
    public String getJssj() {
        return jssj;
    }

    /**
     * 
     * @param jssj 
     */
    public void setJssj(String jssj) {
        this.jssj = jssj == null ? null : jssj.trim();
    }

    /**
     * 
     * @return CJSJ 
     */
    public String getCjsj() {
        return cjsj;
    }

    /**
     * 
     * @param cjsj 
     */
    public void setCjsj(String cjsj) {
        this.cjsj = cjsj == null ? null : cjsj.trim();
    }

    /**
     * 
     * @return IP 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 
     * @param ip 
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 系统支付状态
     * @return ZFZT 系统支付状态
     */
    public String getZfzt() {
        return zfzt;
    }

    /**
     * 系统支付状态
     * @param zfzt 系统支付状态
     */
    public void setZfzt(String zfzt) {
        this.zfzt = zfzt == null ? null : zfzt.trim();
    }

    /**
     * 支付宝账号
     * @return ZFBBH 支付宝账号
     */
    public String getZfbbh() {
        return zfbbh;
    }

    /**
     * 支付宝账号
     * @param zfbbh 支付宝账号
     */
    public void setZfbbh(String zfbbh) {
        this.zfbbh = zfbbh == null ? null : zfbbh.trim();
    }

    /**
     * 订单编号
     * @return DDBH 订单编号
     */
    public String getDdbh() {
        return ddbh;
    }

    /**
     * 订单编号
     * @param ddbh 订单编号
     */
    public void setDdbh(String ddbh) {
        this.ddbh = ddbh == null ? null : ddbh.trim();
    }

    /**
     * 年限
     * @return NX 年限
     */
    public Integer getNx() {
        return nx;
    }

    /**
     * 年限
     * @param nx 年限
     */
    public void setNx(Integer nx) {
        this.nx = nx;
    }

    /**
     * 
     * @return JE 
     */
    public BigDecimal getJe() {
        return je;
    }

    /**
     * 
     * @param je 
     */
    public void setJe(BigDecimal je) {
        this.je = je;
    }

    /**
     *
     * @mbggenerated 2018-05-30
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", yhid=").append(yhid);
        sb.append(", dj=").append(dj);
        sb.append(", kssj=").append(kssj);
        sb.append(", jssj=").append(jssj);
        sb.append(", cjsj=").append(cjsj);
        sb.append(", ip=").append(ip);
        sb.append(", zfzt=").append(zfzt);
        sb.append(", zfbbh=").append(zfbbh);
        sb.append(", ddbh=").append(ddbh);
        sb.append(", nx=").append(nx);
        sb.append(", je=").append(je);
        sb.append("]");
        return sb.toString();
    }
}