package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
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
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * */
	public Map<String,String> toFieldSQL() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Rule com=new Rule();
		Class<? extends Rule> classType = com.getClass();
		Method m;
		String rs;
		if(this.getParam()!=null){
			m = classType.getDeclaredMethod(this.getRule(), String.class);
			rs=(String)m.invoke(com, this.getParam());
		}
		else{
			m= classType.getDeclaredMethod(this.getRule());
			rs=(String)m.invoke(com);
		}
		Map<String,String> map = new HashMap<String,String>();
		String[] fields=comment.getArray(this.getFieldName());
		String[] value=comment.getArray(rs);
		for(int i=0;i<fields.length;i++)
			map.put(fields[i],value[i]);
		return map;
	}
	
}
