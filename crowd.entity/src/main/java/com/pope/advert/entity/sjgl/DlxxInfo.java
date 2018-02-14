package com.pope.advert.entity.sjgl;

import java.io.Serializable;

public class DlxxInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String wid;

    private String title;

    private String kssj;

    private String jssj;

    private String imgid;

    private String ztnr;

    private String mtfl;

    private String cjsj;

    private String yhid;

    private String xgsj;

    private String shzt;

    private String shsj;

    private String content;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj == null ? null : kssj.trim();
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj == null ? null : jssj.trim();
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid == null ? null : imgid.trim();
    }

    public String getZtnr() {
        return ztnr;
    }

    public void setZtnr(String ztnr) {
        this.ztnr = ztnr == null ? null : ztnr.trim();
    }

    public String getMtfl() {
        return mtfl;
    }

    public void setMtfl(String mtfl) {
        this.mtfl = mtfl == null ? null : mtfl.trim();
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj == null ? null : cjsj.trim();
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getXgsj() {
        return xgsj;
    }

    public void setXgsj(String xgsj) {
        this.xgsj = xgsj == null ? null : xgsj.trim();
    }

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt == null ? null : shzt.trim();
    }

    public String getShsj() {
        return shsj;
    }

    public void setShsj(String shsj) {
        this.shsj = shsj == null ? null : shsj.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}