package com.wisedu.crowd.common.util;

import com.pope.advert.common.code.DictionaryEnum;

public class DictionaryUtil {

	public static  DictionaryEnum getDictionary(Integer flag){
		switch(flag){
		case 1:
			return DictionaryEnum.T_ADVERT_SJZD_GGXS;
		case 2:
			return DictionaryEnum.T_ADVERT_SJZD_XZQH;
		case 3:
			return DictionaryEnum.T_ADVERT_SJZD_DST;
		case 4:
			return DictionaryEnum.T_ADVERT_SJZD_HY;
		case 5:
			return DictionaryEnum.T_ADVERT_SJZD_GGDLFS;
		case 6:
			return DictionaryEnum.T_ADVERT_SJZD_LX;
		case 7:
			return DictionaryEnum.T_CROWD_SJZD_SDPD;
		case 8:
			return DictionaryEnum.T_ADVERT_SJZD_SHZT;
		case 9:
			return DictionaryEnum.T_ADVERT_SJZD_DLLM;
		case 10:
			return DictionaryEnum.T_ADVERT_SJZD_TBBCCSLX;
		case 11:
			return DictionaryEnum.T_ADVERT_SJZD_ZTSJD;
		case 12:
			return DictionaryEnum.T_ADVERT_SJZD_GMGGJGPC;
		case 13:
			return DictionaryEnum.T_ADVERT_SJZD_GBLX;
		case 14:
			return DictionaryEnum.T_ADVERT_SJZD_GBDST;
		case 15:
			return DictionaryEnum.T_ADVERT_SJZD_GBDSTPD;
		case 16:
			return DictionaryEnum.T_ADVERT_SJZD_BZXX;
		case 17:
			return DictionaryEnum.T_ADVERT_SJZD_BZLX;
		case 18:
			return DictionaryEnum.T_ADVERT_SJZD_XBMGGLX;
		case 19:
			return DictionaryEnum.T_ADVERT_SJZD_BZYS;
		case 20:
			return DictionaryEnum.T_ADVERT_SJZD_ZZZYLX;
		case 21:
			return DictionaryEnum.T_ADVERT_SJZD_ZZXX;
		case 22:
			return DictionaryEnum.T_ADVERT_SJZD_WLGZWZ;
		case 23:
			return DictionaryEnum.T_ADVERT_SJZD_GGLX;
		case 24:			
			return DictionaryEnum.T_ADVERT_SJZD_XMTLX;
		case 25:
			return DictionaryEnum.T_ADVERT_SJZD_XMTZY_SZRQ;
		case 26:
			return DictionaryEnum.T_ADVERT_SJZD_XMTZY_JYCD;
		case 27:
			return DictionaryEnum.T_ADVERT_SJZD_XMTZY_ZYFB;
		case 28:
			return DictionaryEnum.T_ADVERT_SJZD_XMTZY_SRZK;
		case 29:
			return DictionaryEnum.T_ADVERT_SJZD_COMPANYXZ;
		case 30:
			return DictionaryEnum.T_ADVERT_SJZD_COMPANY_NYYE;
		case 31:
			return DictionaryEnum.T_ADVERT_SJZD_COMPANY_ZZLX;
		case 32:
			return DictionaryEnum.T_ADVERT_SJZD_SJLX;
		default:
			return DictionaryEnum.T_ADVERT_SJZD_SF;
		}
	}
}
