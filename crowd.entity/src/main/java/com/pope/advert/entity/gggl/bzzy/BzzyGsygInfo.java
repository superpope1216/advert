package com.pope.advert.entity.gggl.bzzy;

import java.io.Serializable;
import java.math.BigDecimal;

public class BzzyGsygInfo implements Serializable{
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
    private BigDecimal zk;
    /**
     * 
     */
    private String bzzyId;

    public String getBzzyId() {
		return bzzyId;
	}

	public void setBzzyId(String bzzyId) {
		this.bzzyId = bzzyId;
	}

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
     * @return ZK 
     */
    public BigDecimal getZk() {
        return zk;
    }

    /**
     * 
     * @param zk 
     */
    public void setZk(BigDecimal zk) {
        this.zk = zk;
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
        sb.append(", zk=").append(zk);
        sb.append("]");
        return sb.toString();
    }
}