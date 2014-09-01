package com.sp.net.web.action;

import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sp.net.domain.Site;
import com.sp.net.utils.ComponentFactory;

/**
* @author 陈嘉镇
* @version 创建时间：2014-4-3 下午3:49:45
* @email benjaminchen555@gmail.com
*/
@Controller
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp") })
public class LocationAction extends ActionSupport {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private String site;
	
	private String imgSrc ;
	
	private String formUrl;
	
//	@Autowired
//	private Site qunarSite;
//	@Autowired
//	private Site doubanSite;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		
		String siteId = site+"Site";
		logger.info("siteId:{}",siteId);
		Site site = (Site) ComponentFactory.getBean(siteId);
		site.turn2LoginPage();
		formUrl = site.getLoginForm().getFormUrl();
		if(site.isLoginFormHasVcode()){
			imgSrc = site.getLoginFormVcodeImgSrc();
			logger.info("forward:{}","login-vcode");
			return "login-vcode";
		}else {
			logger.info("forward:{}","login-simple");
			return "login-simple";
		}
		
//		if ("inte".equals(site)) {
//			return "inte";
//		} else if ("qunar".equals(site)) {
//			qunarSite.turn2LoginPage();
//			HtmlPage  h =qunarSite.getCurrentPage();
//			HtmlImage image =  (HtmlImage)h.getHtmlElementById("vcodeImg");
//			 imgSrc = image.getSrcAttribute();
//			return "qunar";
//		} else if ("douban".equals(site)) {
//			doubanSite.turn2LoginPage();
//			HtmlPage  h =doubanSite.getCurrentPage();
//			HtmlImage image =  (HtmlImage)h.getHtmlElementById("captcha_image");
//			 imgSrc = image.getSrcAttribute();
//			return "douban";
//		}

//		return "site-not-found";
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}


	public String getFormUrl() {
		return formUrl;
	}


	public void setFormUrl(String formUrl) {
		this.formUrl = formUrl;
	}
	
	
}
