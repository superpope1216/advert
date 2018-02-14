package com.pope.advert.entity.gggl;

import java.io.Serializable;

public class DszyLmInfo  implements Serializable{
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
     * 栏目频道
     */
    private String pdId;
    /**
     * 代理栏目
     */
    private String dllm;

  

	/**
     * 全时长折扣
     */
    private Long qscZk;

    /**
     * 5秒
     */
    private Long fiveZk;

    /**
     * 10秒
     */
    private Long tenZk;

    /**
     * 15秒
     */
    private Long fiveteenZk;

    /**
     * 20秒
     */
    private Long twentyZk;

    /**
     * 30秒
     */
    private Long thirtyZk;
    
    /**
     * 
     */
    private String dszyId;
    
    public String getDllm() {
  		return dllm;
  	}

  	public void setDllm(String dllm) {
  		this.dllm = dllm;
  	}

    public String getDszyId() {
		return dszyId;
	}

	public void setDszyId(String dszyId) {
		this.dszyId = dszyId;
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
     * 栏目频道
     * @return PD_ID 栏目频道
     */
    public String getPdId() {
        return pdId;
    }

    /**
     * 栏目频道
     * @param pdId 栏目频道
     */
    public void setPdId(String pdId) {
        this.pdId = pdId == null ? null : pdId.trim();
    }

    /**
     * 全时长折扣
     * @return QSC_ZK 全时长折扣
     */
    public Long getQscZk() {
        return qscZk;
    }

    /**
     * 全时长折扣
     * @param qscZk 全时长折扣
     */
    public void setQscZk(Long qscZk) {
        this.qscZk = qscZk;
    }

    /**
     * 5秒
     * @return FIVE_ZK 5秒
     */
    public Long getFiveZk() {
        return fiveZk;
    }

    /**
     * 5秒
     * @param fiveZk 5秒
     */
    public void setFiveZk(Long fiveZk) {
        this.fiveZk = fiveZk;
    }

    /**
     * 10秒
     * @return TEN_ZK 10秒
     */
    public Long getTenZk() {
        return tenZk;
    }

    /**
     * 10秒
     * @param tenZk 10秒
     */
    public void setTenZk(Long tenZk) {
        this.tenZk = tenZk;
    }

    /**
     * 15秒
     * @return FIVETEEN_ZK 15秒
     */
    public Long getFiveteenZk() {
        return fiveteenZk;
    }

    /**
     * 15秒
     * @param fiveteenZk 15秒
     */
    public void setFiveteenZk(Long fiveteenZk) {
        this.fiveteenZk = fiveteenZk;
    }

    /**
     * 20秒
     * @return TWENTY_ZK 20秒
     */
    public Long getTwentyZk() {
        return twentyZk;
    }

    /**
     * 20秒
     * @param twentyZk 20秒
     */
    public void setTwentyZk(Long twentyZk) {
        this.twentyZk = twentyZk;
    }

    /**
     * 30秒
     * @return THIRTY_ZK 30秒
     */
    public Long getThirtyZk() {
        return thirtyZk;
    }

    /**
     * 30秒
     * @param thirtyZk 30秒
     */
    public void setThirtyZk(Long thirtyZk) {
        this.thirtyZk = thirtyZk;
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
        sb.append(", pdId=").append(pdId);
        sb.append(", qscZk=").append(qscZk);
        sb.append(", fiveZk=").append(fiveZk);
        sb.append(", tenZk=").append(tenZk);
        sb.append(", fiveteenZk=").append(fiveteenZk);
        sb.append(", twentyZk=").append(twentyZk);
        sb.append(", thirtyZk=").append(thirtyZk);
        sb.append("]");
        return sb.toString();
    }
}