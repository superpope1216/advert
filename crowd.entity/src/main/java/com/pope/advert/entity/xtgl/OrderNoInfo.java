package com.pope.advert.entity.xtgl;

import java.io.Serializable;

public class OrderNoInfo implements Serializable{
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
    private String orderno;

    /**
     * 
     */
    private String month;

    /**
     * 类别01为缴费(消费)，02为充值，03为余额
     */
    private String type;

    /**
     * 
     */
    private String csjs;

    /**
     * 
     */
    private String ip;

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
     * @return orderNo 
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 
     * @param orderno 
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    /**
     * 
     * @return month 
     */
    public String getMonth() {
        return month;
    }

    /**
     * 
     * @param month 
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * 类别01为缴费(消费)，02为充值，03为余额
     * @return type 类别01为缴费(消费)，02为充值，03为余额
     */
    public String getType() {
        return type;
    }

    /**
     * 类别01为缴费(消费)，02为充值，03为余额
     * @param type 类别01为缴费(消费)，02为充值，03为余额
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 
     * @return CSJS 
     */
    public String getCsjs() {
        return csjs;
    }

    /**
     * 
     * @param csjs 
     */
    public void setCsjs(String csjs) {
        this.csjs = csjs == null ? null : csjs.trim();
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
        sb.append(", orderno=").append(orderno);
        sb.append(", month=").append(month);
        sb.append(", type=").append(type);
        sb.append(", csjs=").append(csjs);
        sb.append(", ip=").append(ip);
        sb.append("]");
        return sb.toString();
    }
}