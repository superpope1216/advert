package com.pope.advert.entity.gggl.hwzy;

import java.io.Serializable;
import java.math.BigDecimal;

public class HwzyInfo implements Serializable{
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
    private String area;

    /**
     * 
     */
    private String city;

    /**
     * 
     */
    private String xian;

    /**
     * 
     */
    private String tvId;
    
    /**
     * 封面图片
     */
    private String sctplj;

    public String getSctplj() {
		return sctplj;
	}

	public void setSctplj(String sctplj) {
		this.sctplj = sctplj;
	}

	/**
     * 区域
     */
    private String qy;

    /**
     * 形式
     */
    private String xs;

    /**
     * 名称
     */
    private String name;

    /**
     * 媒体类型
     */
    private String advertType;

    /**
     * 媒体材质
     */
    private String mtcz;

    /**
     * 
     */
    private String lng;

    /**
     * 
     */
    private String lat;

    /**
     * 是否已标注
     */
    private String sfybz;

    /**
     * 估计人流量
     */
    private Long gjrll;

    /**
     * 估计车流量
     */
    private Long gjcll;

    /**
     * 户外媒体规格宽
     */
    private BigDecimal mtggK;

    /**
     * 户外媒体规格高
     */
    private BigDecimal mtggG;

    /**
     * 户外媒体规格面
     */
    private Long mtggM;

    /**
     * 户外媒体规格平方米
     */
    private BigDecimal mtggPfm;

    /**
     * 执行价格(元/月)
     */
    private BigDecimal zxjgMonth;

    /**
     * 执行价格(元/年)
     */
    private BigDecimal zxjgYear;

    /**
     * 上传效果图
     */
    private String scxgt;

    /**
     * 照明时间
     */
    private String zmsj;

    /**
     * 上传位置图
     */
    private String zcwzt;

    /**
     * 媒体状态
     */
    private String mtzt;

    /**
     * 最小投放周期
     */
    private String zxtfzq;

    /**
     * 最早投放时间
     */
    private String zztfrq;

    /**
     * 所有权到期日
     */
    private String ssqdqr;

    /**
     * 最小投放数量
     */
    private Long zxtfsl;

    /**
     * 广告所有权状况
     */
    private String ggsyqzk;

    /**
     * 
     */
    private String hwgljj;

    /**
     * 
     */
    private String shzt;

    /**
     * 
     */
    private String cjsj;

    /**
     * 
     */
    private String cjip;

    /**
     * 
     */
    private String registerId;

    /**
     * 
     */
    private String datastatus;

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
     * @return AREA 
     */
    public String getArea() {
        return area;
    }

    /**
     * 
     * @param area 
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 
     * @return CITY 
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city 
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 
     * @return XIAN 
     */
    public String getXian() {
        return xian;
    }

    /**
     * 
     * @param xian 
     */
    public void setXian(String xian) {
        this.xian = xian == null ? null : xian.trim();
    }

    /**
     * 
     * @return TV_ID 
     */
    public String getTvId() {
        return tvId;
    }

    /**
     * 
     * @param tvId 
     */
    public void setTvId(String tvId) {
        this.tvId = tvId == null ? null : tvId.trim();
    }

    /**
     * 区域
     * @return QY 区域
     */
    public String getQy() {
        return qy;
    }

    /**
     * 区域
     * @param qy 区域
     */
    public void setQy(String qy) {
        this.qy = qy == null ? null : qy.trim();
    }

    /**
     * 形式
     * @return XS 形式
     */
    public String getXs() {
        return xs;
    }

    /**
     * 形式
     * @param xs 形式
     */
    public void setXs(String xs) {
        this.xs = xs == null ? null : xs.trim();
    }

    /**
     * 名称
     * @return NAME 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 媒体类型
     * @return ADVERT_TYPE 媒体类型
     */
    public String getAdvertType() {
        return advertType;
    }

    /**
     * 媒体类型
     * @param advertType 媒体类型
     */
    public void setAdvertType(String advertType) {
        this.advertType = advertType == null ? null : advertType.trim();
    }

    /**
     * 媒体材质
     * @return MTCZ 媒体材质
     */
    public String getMtcz() {
        return mtcz;
    }

    /**
     * 媒体材质
     * @param mtcz 媒体材质
     */
    public void setMtcz(String mtcz) {
        this.mtcz = mtcz == null ? null : mtcz.trim();
    }

    /**
     * 
     * @return LNG 
     */
    public String getLng() {
        return lng;
    }

    /**
     * 
     * @param lng 
     */
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    /**
     * 
     * @return LAT 
     */
    public String getLat() {
        return lat;
    }

    /**
     * 
     * @param lat 
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * 是否已标注
     * @return SFYBZ 是否已标注
     */
    public String getSfybz() {
        return sfybz;
    }

    /**
     * 是否已标注
     * @param sfybz 是否已标注
     */
    public void setSfybz(String sfybz) {
        this.sfybz = sfybz == null ? null : sfybz.trim();
    }

    /**
     * 估计人流量
     * @return GJRLL 估计人流量
     */
    public Long getGjrll() {
        return gjrll;
    }

    /**
     * 估计人流量
     * @param gjrll 估计人流量
     */
    public void setGjrll(Long gjrll) {
        this.gjrll = gjrll;
    }

    /**
     * 估计车流量
     * @return GJCLL 估计车流量
     */
    public Long getGjcll() {
        return gjcll;
    }

    /**
     * 估计车流量
     * @param gjcll 估计车流量
     */
    public void setGjcll(Long gjcll) {
        this.gjcll = gjcll;
    }

    /**
     * 户外媒体规格宽
     * @return MTGG_K 户外媒体规格宽
     */
    public BigDecimal getMtggK() {
        return mtggK;
    }

    /**
     * 户外媒体规格宽
     * @param mtggK 户外媒体规格宽
     */
    public void setMtggK(BigDecimal mtggK) {
        this.mtggK = mtggK;
    }

    /**
     * 户外媒体规格高
     * @return MTGG_G 户外媒体规格高
     */
    public BigDecimal getMtggG() {
        return mtggG;
    }

    /**
     * 户外媒体规格高
     * @param mtggG 户外媒体规格高
     */
    public void setMtggG(BigDecimal mtggG) {
        this.mtggG = mtggG;
    }

    /**
     * 户外媒体规格面
     * @return MTGG_M 户外媒体规格面
     */
    public Long getMtggM() {
        return mtggM;
    }

    /**
     * 户外媒体规格面
     * @param mtggM 户外媒体规格面
     */
    public void setMtggM(Long mtggM) {
        this.mtggM = mtggM;
    }

    /**
     * 户外媒体规格平方米
     * @return MTGG_PFM 户外媒体规格平方米
     */
    public BigDecimal getMtggPfm() {
        return mtggPfm;
    }

    /**
     * 户外媒体规格平方米
     * @param mtggPfm 户外媒体规格平方米
     */
    public void setMtggPfm(BigDecimal mtggPfm) {
        this.mtggPfm = mtggPfm;
    }

    /**
     * 执行价格(元/月)
     * @return ZXJG_MONTH 执行价格(元/月)
     */
    public BigDecimal getZxjgMonth() {
        return zxjgMonth;
    }

    /**
     * 执行价格(元/月)
     * @param zxjgMonth 执行价格(元/月)
     */
    public void setZxjgMonth(BigDecimal zxjgMonth) {
        this.zxjgMonth = zxjgMonth;
    }

    /**
     * 执行价格(元/年)
     * @return ZXJG_YEAR 执行价格(元/年)
     */
    public BigDecimal getZxjgYear() {
        return zxjgYear;
    }

    /**
     * 执行价格(元/年)
     * @param zxjgYear 执行价格(元/年)
     */
    public void setZxjgYear(BigDecimal zxjgYear) {
        this.zxjgYear = zxjgYear;
    }

    /**
     * 上传效果图
     * @return SCXGT 上传效果图
     */
    public String getScxgt() {
        return scxgt;
    }

    /**
     * 上传效果图
     * @param scxgt 上传效果图
     */
    public void setScxgt(String scxgt) {
        this.scxgt = scxgt == null ? null : scxgt.trim();
    }

    /**
     * 照明时间
     * @return ZMSJ 照明时间
     */
    public String getZmsj() {
        return zmsj;
    }

    /**
     * 照明时间
     * @param zmsj 照明时间
     */
    public void setZmsj(String zmsj) {
        this.zmsj = zmsj == null ? null : zmsj.trim();
    }

    /**
     * 上传位置图
     * @return ZCWZT 上传位置图
     */
    public String getZcwzt() {
        return zcwzt;
    }

    /**
     * 上传位置图
     * @param zcwzt 上传位置图
     */
    public void setZcwzt(String zcwzt) {
        this.zcwzt = zcwzt == null ? null : zcwzt.trim();
    }

    /**
     * 媒体状态
     * @return MTZT 媒体状态
     */
    public String getMtzt() {
        return mtzt;
    }

    /**
     * 媒体状态
     * @param mtzt 媒体状态
     */
    public void setMtzt(String mtzt) {
        this.mtzt = mtzt == null ? null : mtzt.trim();
    }

    /**
     * 最小投放周期
     * @return ZXTFZQ 最小投放周期
     */
    public String getZxtfzq() {
        return zxtfzq;
    }

    /**
     * 最小投放周期
     * @param zxtfzq 最小投放周期
     */
    public void setZxtfzq(String zxtfzq) {
        this.zxtfzq = zxtfzq == null ? null : zxtfzq.trim();
    }

    /**
     * 最早投放时间
     * @return ZZTFRQ 最早投放时间
     */
    public String getZztfrq() {
        return zztfrq;
    }

    /**
     * 最早投放时间
     * @param zztfrq 最早投放时间
     */
    public void setZztfrq(String zztfrq) {
        this.zztfrq = zztfrq == null ? null : zztfrq.trim();
    }

    /**
     * 所有权到期日
     * @return SSQDQR 所有权到期日
     */
    public String getSsqdqr() {
        return ssqdqr;
    }

    /**
     * 所有权到期日
     * @param ssqdqr 所有权到期日
     */
    public void setSsqdqr(String ssqdqr) {
        this.ssqdqr = ssqdqr == null ? null : ssqdqr.trim();
    }

    /**
     * 最小投放数量
     * @return ZXTFSL 最小投放数量
     */
    public Long getZxtfsl() {
        return zxtfsl;
    }

    /**
     * 最小投放数量
     * @param zxtfsl 最小投放数量
     */
    public void setZxtfsl(Long zxtfsl) {
        this.zxtfsl = zxtfsl;
    }

    /**
     * 广告所有权状况
     * @return GGSYQZK 广告所有权状况
     */
    public String getGgsyqzk() {
        return ggsyqzk;
    }

    /**
     * 广告所有权状况
     * @param ggsyqzk 广告所有权状况
     */
    public void setGgsyqzk(String ggsyqzk) {
        this.ggsyqzk = ggsyqzk == null ? null : ggsyqzk.trim();
    }

    /**
     * 
     * @return HWGLJJ 
     */
    public String getHwgljj() {
        return hwgljj;
    }

    /**
     * 
     * @param hwgljj 
     */
    public void setHwgljj(String hwgljj) {
        this.hwgljj = hwgljj == null ? null : hwgljj.trim();
    }

    /**
     * 
     * @return SHZT 
     */
    public String getShzt() {
        return shzt;
    }

    /**
     * 
     * @param shzt 
     */
    public void setShzt(String shzt) {
        this.shzt = shzt == null ? null : shzt.trim();
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
     * @return CJIP 
     */
    public String getCjip() {
        return cjip;
    }

    /**
     * 
     * @param cjip 
     */
    public void setCjip(String cjip) {
        this.cjip = cjip == null ? null : cjip.trim();
    }

    /**
     * 
     * @return REGISTER_ID 
     */
    public String getRegisterId() {
        return registerId;
    }

    /**
     * 
     * @param registerId 
     */
    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }

    /**
     * 
     * @return DATASTATUS 
     */
    public String getDatastatus() {
        return datastatus;
    }

    /**
     * 
     * @param datastatus 
     */
    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus == null ? null : datastatus.trim();
    }

    /**
     *
     * @mbggenerated 2018-02-28
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", area=").append(area);
        sb.append(", city=").append(city);
        sb.append(", xian=").append(xian);
        sb.append(", tvId=").append(tvId);
        sb.append(", qy=").append(qy);
        sb.append(", xs=").append(xs);
        sb.append(", name=").append(name);
        sb.append(", advertType=").append(advertType);
        sb.append(", mtcz=").append(mtcz);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", sfybz=").append(sfybz);
        sb.append(", gjrll=").append(gjrll);
        sb.append(", gjcll=").append(gjcll);
        sb.append(", mtggK=").append(mtggK);
        sb.append(", mtggG=").append(mtggG);
        sb.append(", mtggM=").append(mtggM);
        sb.append(", mtggPfm=").append(mtggPfm);
        sb.append(", zxjgMonth=").append(zxjgMonth);
        sb.append(", zxjgYear=").append(zxjgYear);
        sb.append(", scxgt=").append(scxgt);
        sb.append(", zmsj=").append(zmsj);
        sb.append(", zcwzt=").append(zcwzt);
        sb.append(", mtzt=").append(mtzt);
        sb.append(", zxtfzq=").append(zxtfzq);
        sb.append(", zztfrq=").append(zztfrq);
        sb.append(", ssqdqr=").append(ssqdqr);
        sb.append(", zxtfsl=").append(zxtfsl);
        sb.append(", ggsyqzk=").append(ggsyqzk);
        sb.append(", hwgljj=").append(hwgljj);
        sb.append(", shzt=").append(shzt);
        sb.append(", cjsj=").append(cjsj);
        sb.append(", cjip=").append(cjip);
        sb.append(", registerId=").append(registerId);
        sb.append(", datastatus=").append(datastatus);
        sb.append("]");
        return sb.toString();
    }
}