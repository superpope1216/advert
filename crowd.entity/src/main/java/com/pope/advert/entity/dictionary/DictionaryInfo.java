package com.pope.advert.entity.dictionary;

import java.io.Serializable;

public class DictionaryInfo implements Serializable {
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
    private String lbdm;

    /**
     * 
     */
    private String lbmc;

    /**
     * 
     */
    private Integer sfsy;

    /**
     * 
     */
    private Long px;

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
     * @return LBDM 
     */
    public String getLbdm() {
        return lbdm;
    }

    /**
     * 
     * @param lbdm 
     */
    public void setLbdm(String lbdm) {
        this.lbdm = lbdm == null ? null : lbdm.trim();
    }

    /**
     * 
     * @return LBMC 
     */
    public String getLbmc() {
        return lbmc;
    }

    /**
     * 
     * @param lbmc 
     */
    public void setLbmc(String lbmc) {
        this.lbmc = lbmc == null ? null : lbmc.trim();
    }

    /**
     * 
     * @return SFSY 
     */
    public Integer getSfsy() {
        return sfsy;
    }

    /**
     * 
     * @param sfsy 
     */
    public void setSfsy(Integer sfsy) {
        this.sfsy = sfsy;
    }

    /**
     * 
     * @return PX 
     */
    public Long getPx() {
        return px;
    }

    /**
     * 
     * @param px 
     */
    public void setPx(Long px) {
        this.px = px;
    }

  
}