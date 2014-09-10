package com.sp.net.web.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author 陈嘉镇
* @version 创建时间：2014-9-10 上午10:03:08
* @email benjaminchen555@gmail.com
*/
public class ServletUtils {

	private static Logger logger = LoggerFactory.getLogger(ServletUtils.class);
	
	public static String getBasepath(HttpServletRequest request) {
		String basePath = request.getSession().getServletContext().getRealPath("/");
	    return basePath;
	}
	
	public static void sendExcel(String filepath,String rename,  HttpServletResponse response) {
		File excel = new File(filepath);
		sendExcel(excel,rename,response);
	}

	public static void sendExcel(File file, String rename,HttpServletResponse response) {
		String fileName = file.getName();
		if (StringUtils.isNoneBlank(rename)) {
			try {
				fileName= java.net.URLEncoder.encode(rename, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				logger.error("error.",e);
			}
		}
		response.setHeader("Content-disposition", "attachment; filename="+fileName+".xls");
		response.setHeader("Content-Type", "application/vnd.ms-excel");
		InputStream inputXLS = null;
		OutputStream os = null;
		try {
			inputXLS = new FileInputStream(file);
			os = new BufferedOutputStream(response.getOutputStream());
			int c;
			while ((c = inputXLS.read()) != -1) {
				os.write(c);
			}
			os.flush();
		} catch (IOException e) {
			logger.error("error.", e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error("error.", e);
				}
			}
			if (inputXLS!=null) {
				try {
					inputXLS.close();
				} catch (IOException e) {
					logger.error("error.", e);
				}
			}
		}

	}

}
