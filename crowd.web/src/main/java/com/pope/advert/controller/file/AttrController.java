package com.pope.advert.controller.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.pope.advert.common.code.XtcsEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.xtgl.FjxxInfo;
import com.pope.advert.entity.xtgl.extend.XtcsbInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.xtgl.FjxxInfoService;
import com.pope.advert.service.xtgl.XtcsbInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.StringUtil;


/**
 * 附件控制类
 * 
 * @author 01113120
 * 
 */
@Controller
@RequestMapping(value = "attr")
public class AttrController extends BaseController {
	
	private static final Logger LOG=LoggerFactory.getLogger(AttrController.class);

	@Autowired
	private XtcsbInfoService  xtcsbInfoService;
	
	@Autowired
	private FjxxInfoService  fjxxInfoService;
	
	/**
	 * 上传文件
	 * @throws Exception 
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "upload")
	public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try{
			// 获取并检查附件路径
			String fjlj = getFilePath();
		
			if (StringUtils.isBlank(fjlj)) {
				throw new RuntimeException("未配置上传路径！");
			}
			File f = new File(fjlj);
			if (!f.exists() && !f.isDirectory()) {
				System.out.println("目录路径不存在,重新建立");
				f.mkdir();
			}

			String userId = this.getYhId();
			String sjh = this.getSjh();
			String ip = null;

			String r_fileWids = "";
			String r_fileViewNames = "";

			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					MultipartFile file = multiRequest.getFile(iter.next());// 取得上传文件
					if (file != null) {
						String fileName = file.getOriginalFilename();// 取得当前上传文件的文件名称
						if (fileName.trim() != "") {
							String extName = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();// 上传文件后缀
                            // 重命名上传后的文件名,使用UUID作为文件名称
							String uuid = UUID.randomUUID().toString().replaceAll("-", "");
							String newfileName = uuid + extName;
							File targetFile = new File(fjlj, newfileName);
							if (!targetFile.exists()) {
								targetFile.mkdirs();
							}
							file.transferTo(targetFile);
							//保存附件信息
							FjxxInfo  fjxxInfo=new FjxxInfo();
							fjxxInfo.setWid(uuid);
							fjxxInfo.setWjmc(newfileName);
							fjxxInfo.setWjxsmc(fileName);
							fjxxInfo.setWjlj(targetFile.getPath());
							fjxxInfo.setScrid(userId);
							fjxxInfo.setScrip(this.getRemoteHost());
							fjxxInfo.setScrxm(sjh);
							fjxxInfo.setScsj(DateUtil.getCurrentDate());
							fjxxInfoService.insertSelective(fjxxInfo,createCustomOperateLog());
					
							if (StringUtils.isNotBlank(r_fileWids)) {
								r_fileWids += ",";
								r_fileViewNames += ",";
							}
							r_fileWids += uuid;
							r_fileViewNames += fileName;
						}
					}
				}
			}

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", "200");
			jsonObject.put("src", request.getContextPath()+"/image/preView?wid="+r_fileWids);
			jsonObject.put("fileWids", r_fileWids);
			jsonObject.put("fileNames", r_fileViewNames);
			out.print(jsonObject);
			out.close();
			
			
		}catch(Exception e){
			LOG.info("上传异常");
			e.printStackTrace();
		}
	
	}
	
	
	


	



	/**
	 * 删除文件
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(value = "remove")
	public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String wid=request.getParameter("wid");
		DataResult<FjxxInfo>  result=fjxxInfoService.selectByPrimaryKey(wid,createCustomOperateLog());
		if(!StringUtil.isEmpty(result.getDatas())){
			File file = new File(result.getDatas().getWjlj());
			if (file.exists()){
				file.delete();
			}
			fjxxInfoService.deleteByPrimaryKey(wid,createCustomOperateLog());
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", "1");
		out.print(jsonObject);
		out.close();
	}
	
	private String encodingFileName(String fileName) {
		String returnFileName = "";
		try {
			returnFileName = URLEncoder.encode(fileName, "UTF-8");
			returnFileName = StringUtils.replace(returnFileName, "+", "%20");
			if (returnFileName.length() > 150) {
				returnFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
				returnFileName = StringUtils.replace(returnFileName, " ", "%20");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnFileName;
	}
  
	
	@RequestMapping(value = "download")
	public String download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String wid = request.getParameter("wid");
		
        if(StringUtil.isEmpty(wid)){
        	return null;
        }
		DataResult<FjxxInfo>  result=fjxxInfoService.selectByPrimaryKey(wid, createCustomOperateLog());
       
		if(!StringUtil.isEmpty(result.getDatas())){
			FjxxInfo  fjxxInfo=result.getDatas();
			String fileName=new String(fjxxInfo.getWjxsmc().getBytes(), "ISO-8859-1");
			System.out.println("---fjxxInfo.getWjxsmc()----"+fjxxInfo.getWjxsmc());
			System.out.println("---fileName----"+fileName);
			response.setContentType("appaction/octet-stream");

			response.setHeader("Location", fileName);
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            OutputStream outputStream = response.getOutputStream();
			InputStream inputStream = new FileInputStream(fjxxInfo.getWjlj());
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, i);
			}
			outputStream.flush();
			outputStream.close();
			return null;
		}
     return null;
	}
	
	/**
	 * 获取文件路径
	 * 
	 * @return
	 * @throws Exception 
	 */
	private String getFilePath() throws Exception {
		
		if(StringUtil.isEmpty(ConstantsUtil.SYSATTACHMENTFILEPATH)){
			    LOG.info("系统配置路径未设置     查询数据库");
			    XtcsbInfoExtend xtcsbInfo=new XtcsbInfoExtend();
			    xtcsbInfo.setCsmc(XtcsEnum.XTGL_FJLJ.getCode());
			    DataResult<List<XtcsbInfoExtend>> list=xtcsbInfoService.selectByCondition(xtcsbInfo);
			    if(!StringUtil.isEmpty(list)&&CommonUtil.isNotEmptyList(list.getDatas())){
			    	  ConstantsUtil.SYSATTACHMENTFILEPATH=list.getDatas().get(0).getCsz();
			    }
		      
		}
		return ConstantsUtil.SYSATTACHMENTFILEPATH;
		
	}
	
	/**
	 * 获取文件
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getFileViewName")
	public void getFileViewName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String wid = request.getParameter("wid");
		
        if(StringUtil.isEmpty(wid)){
        	return;
        }
		DataResult<FjxxInfo>  result=fjxxInfoService.selectByPrimaryKey(wid, createCustomOperateLog());
		if(StringUtil.isEmpty(result.getDatas())){
			System.out.println("---附件数据不存在----");
			return;
		}
        String wjxsmc=result.getDatas().getWjxsmc();
        response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("wjxsmc",wjxsmc);
		out.print(jsonObject);
		out.close();
	}
	
	

}
