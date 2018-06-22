package com.pope.advert.controller.file;

import java.io.FileInputStream;
import java.io.OutputStream;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.xtgl.FjxxInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.xtgl.FjxxInfoService;
import com.wisedu.crowd.common.util.StringUtil;


/**
 * 图片控制类
 * 
 * @author 01113120
 * 
 */
@Controller
@RequestMapping(value = "image")
public class ImageController extends BaseController {
	
	@Autowired
	private FjxxInfoService  fjxxInfoService;
	
	@RequestMapping(value="preView")
	public void preView(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		try{
			String wid=request.getParameter("wid");
			if(!StringUtil.isEmpty(wid)){
				DataResult<FjxxInfo>  result=fjxxInfoService.selectByPrimaryKey(wid,createCustomOperateLog());
				if(!StringUtil.isEmpty(result.getDatas())){
					FileInputStream fis=new FileInputStream(result.getDatas().getWjlj());
					int i=fis.available();
					byte[] data=new byte[i];
					fis.read(data);
					fis.close();
					response.setContentType("image/*");
					OutputStream  toClient=response.getOutputStream();
					toClient.write(data);
					toClient.close();
				}
			}
		}catch(Exception e){
			System.out.println("----------preView image fail--------");
			e.printStackTrace();
		}
	 
	}
  
}
