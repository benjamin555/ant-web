package com.sp.net.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sp.net.domain.Site;

/**
* @author 陈嘉镇
* @version 创建时间：2014-3-31 上午10:56:21
* @email benjaminchen555@gmail.com
* 
* 需求系统操作
*/
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@Namespace("/qunar")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp") })
public class QunarAction  extends ActionSupport {
	private Logger logger = LoggerFactory.getLogger(QunarAction.class);
	private static final String RULES = "rules";
	@Autowired
	private Site qunarSite;
	private String userName;
	private String password;
	private String vcode;
	private String formKey;
	private String ruleKey;
	private String no;
	
	@Action(value="login")
	public String login() throws Exception {
		qunarSite.login(userName,password,vcode);
		return RULES;
	}
	
	

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getFormKey() {
		return formKey;
	}


	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}


	public String getRuleKey() {
		return ruleKey;
	}


	public void setRuleKey(String ruleKey) {
		this.ruleKey = ruleKey;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}





	public String getVcode() {
		return vcode;
	}





	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	
	


}
