package com.sp.net.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sp.net.domain.Form;
import com.sp.net.domain.Rule;
import com.sp.net.domain.Site;
import com.sp.net.domain.rule.redmine.Case;
import com.sp.net.domain.rule.redmine.ImportExcelRule;
import com.sp.net.utils.JxlsUtils;

/**
* @author 陈嘉镇
* @version 创建时间：2014-3-31 上午10:56:21
* @email benjaminchen555@gmail.com
* 
* 需求系统操作
*/
@SuppressWarnings({ "rawtypes", "unchecked","serial" })
@Controller
@Scope("prototype")
@Namespace("/redmine")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp"),@Result(name = "json", location = "/WEB-INF/content/json.jsp")})
public class RedmineAction  extends ActionSupport {
	private static final String EXCEL_XML_CONFIG_EXCEL_MAPPING_CASE_XML = "/excelXMLConfig/excelMappingCase.xml";
	private Logger logger = LoggerFactory.getLogger(RedmineAction.class);
	private static final String RULES = "rules";
	@Autowired
	private Site redmineSite;
	private String userName;
	private String password;
	private String formKey;
	private String ruleKey;
	private String jsonStr;
	
	private File dataExcel ;
	
	@Action(value="login")
	public String login() throws Exception {
		redmineSite.login(userName,password);
		return RULES;
	}
	
	
	@Action(value="perform")
	public String perform()  {
		try {
			Form form = redmineSite.findForm(formKey);
			Rule rule =form.findRule(ruleKey) ;
			if (rule instanceof ImportExcelRule) {
				List<Case> c = getImportBeans();
				Map<String, Object> formValueMap = new HashMap<String, Object>();
				for (Case case1 : c) {
					formValueMap.put("data", case1);
					form.setFormValueMap(formValueMap );
					form.perform(rule);
				}
			}else {
				logger.error("规则异常");
			}
		} catch (Exception e) {
			logger.error("error.",e);
			throw new RuntimeException(e);
		}
		return RULES;
	}
	
	
	
	private List<Case> getImportBeans() throws FileNotFoundException, Exception {
		
		InputStream inputXLS = new FileInputStream(dataExcel);
		InputStream inputXML = getClass().getResourceAsStream(EXCEL_XML_CONFIG_EXCEL_MAPPING_CASE_XML);
		Map beans = new HashMap();
		List<Case> c = new ArrayList<Case>();
		beans.put("result01", c);
		JxlsUtils.readXLS(inputXLS, inputXML, beans);
		return c;
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




	public Logger getLogger() {
		return logger;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}





	public String getJsonStr() {
		return jsonStr;
	}


	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}


	public File getDataExcel() {
		return dataExcel;
	}


	public void setDataExcel(File dataExcel) {
		this.dataExcel = dataExcel;
	}


	public Site getRedmineSite() {
		return redmineSite;
	}

	
	


}
