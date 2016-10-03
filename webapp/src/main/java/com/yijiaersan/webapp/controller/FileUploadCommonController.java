package com.yijiaersan.webapp.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.utils.UuidUtil;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadCommonController {

	@RequestMapping("/toFileUploadpage")
	public String toFileUploadpage() {
		return "fileUpload";
	}

	@RequestMapping(value = "/imgFileUpload", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject imgFileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		JSONObject jSONObject = new JSONObject();
		String projectName = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ projectName;

		String pathStr = "/static/pic/";
		String path = request.getSession().getServletContext().getRealPath(pathStr);

		if (file == null) {
			jSONObject.put("retCode", "6");
			// jSONObject.put("retContent","上传的文件为空");
			jSONObject.put("retMessage", "上传的文件为空");
			return jSONObject;
		}
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+UuidUtil.get32UUID()+".jpg";
		System.out.println(fileName);
		if (fileName == null || fileName.equals("")) {
			jSONObject.put("retCode", "7");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "上传的文件为空");
			return jSONObject;
		}
		String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf("."), fileName.length())
				: null;
		System.out.println(type);
		if (type.equals(".jpg")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".jpg";
		} else if (type.equals(".png")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".png";
		} else if (type.equals(".jpeg")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".jpeg";
		} else if (type.equals(".bmp")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".bmp";
		} else if (type.equals(".gif")) {
			fileName = new Date().getTime() + UuidUtil.get32UUID() + ".gif";
		} else {
			jSONObject.put("retCode", "5");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "图片格式不支持");
			return jSONObject;
		}
		System.out.println(type);
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			jSONObject.put("retCode", "0");
			// jSONObject.put("retContent","");
			jSONObject.put("retMessage", "内部错误，图片上传失败");
		}
		jSONObject.put("retCode", "1");
		// jSONObject.put("retContent","");
		jSONObject.put("retMessage", "图片上传成功");
		jSONObject.put("url", basePath + pathStr + fileName);
		return jSONObject;
	}
}
