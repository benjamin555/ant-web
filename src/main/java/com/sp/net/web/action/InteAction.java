package com.sp.net.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

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

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;
import com.opensymphony.xwork2.ActionSupport;
import com.sp.net.domain.Form;
import com.sp.net.domain.Rule;
import com.sp.net.domain.Site;
import com.sp.net.domain.rule.inte.LoopDelApplyRule;
import com.sp.net.domain.rule.inte.SingleInputRule;
import com.sp.net.domain.rule.inte.SuffixInputRule;

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
@Namespace("/inte")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp"),@Result(name = "json", location = "/WEB-INF/content/json.jsp"),@Result(name = "rules", location = "/WEB-INF/content/inte/rules.jsp") })
public class InteAction  extends ActionSupport {
	private Logger logger = LoggerFactory.getLogger(InteAction.class);
	private static final String RULES = "rules";
	@Autowired
	private Site inteSite;
	private String userName;
	private String password;
	private String formKey;
	private String ruleKey;
	private String no;
	private boolean loop;
	private int interval;
	private String jsonStr;
	
	@Action(value="login")
	public String login() throws Exception {
		inteSite.login(userName,password);
		return RULES;
	}
	
	
	@Action(value="perform")
	public String perform()  {
		try {
			Form form = inteSite.findForm(formKey);
			
			Rule rule =form.findRule(ruleKey) ;
			
			Map<String, Object> formValueMap = new HashMap<String, Object>();
			if (rule instanceof SingleInputRule) {
				formValueMap.put("applyNO", no.trim());
			}else if (rule instanceof SuffixInputRule) {
				formValueMap.put("suffix", no.trim());
			}else if (rule instanceof LoopDelApplyRule) {
				rule.setLoop(loop);
				rule.setInterval(interval);
			}else {
				logger.error("规则异常");
			}
			form.setFormValueMap(formValueMap );
			form.perform(rule);
		} catch (Exception e) {
			logger.error("error.",e);
			throw new RuntimeException(e);
		}
		return RULES;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value="monitor")
	public String monitor()  {
		try {
			Form form = inteSite.findForm(formKey);
			Rule rule =form.findRule(ruleKey) ;
			HtmlPage p = (HtmlPage) rule.turn2Page();
			List<HtmlTableDataCell> l = (List<HtmlTableDataCell>) p.getByXPath("//table//tr/td[3]");
			List<Map<String, String>> list = new ArrayList<Map<String,String>>();
			for (HtmlTableCell htmlTableCell : l) {
				Map<String, String> m = new HashMap<String, String>();
				m.put("no", htmlTableCell.asText());
				list.add(m);
			}
			jsonStr = JSONArray.fromObject(list).toString();
			
		} catch (Exception e) {
			logger.error("error.",e);
			throw new RuntimeException(e);
		}finally{
		}
		return "json";
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

	public Site getInteSite() {
		return inteSite;
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


	public Logger getLogger() {
		return logger;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}


	public boolean isLoop() {
		return loop;
	}


	public void setLoop(boolean loop) {
		this.loop = loop;
	}


	public int getInterval() {
		return interval;
	}


	public void setInterval(int interval) {
		this.interval = interval;
	}


	public void setInteSite(Site inteSite) {
		this.inteSite = inteSite;
	}


	public String getJsonStr() {
		return jsonStr;
	}


	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	
	


}
