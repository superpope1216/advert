package com.pope.advert.entity.gggl.zzzy.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;

public class ZzzyExtInfoExtend extends ZzzyExtInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String ggdlfsDisplay;
	
	private String hyDisplay;
	
	private String sfxzhyDisplay;

	public String getSfxzhyDisplay() {
		return sfxzhyDisplay;
	}

	public void setSfxzhyDisplay(String sfxzhyDisplay) {
		this.sfxzhyDisplay = sfxzhyDisplay;
	}

	public String getHyDisplay() {
		return hyDisplay;
	}

	public void setHyDisplay(String hyDisplay) {
		this.hyDisplay = hyDisplay;
	}

	public String getGgdlfsDisplay() {
		return ggdlfsDisplay;
	}

	public void setGgdlfsDisplay(String ggdlfsDisplay) {
		this.ggdlfsDisplay = ggdlfsDisplay;
	}

}