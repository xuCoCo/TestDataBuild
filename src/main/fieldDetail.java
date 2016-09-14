package main;

import java.util.Map;

public class fieldDetail {
	String fieldName;  //字段名
	String rule;		//规则名
	String param;		//参数
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	/**
	 * 规则生产字段值
	 * */
	public Map<String,String> getFieldSQL(){
		//TODO
		return null;
	}
	
}
