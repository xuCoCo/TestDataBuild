package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class tableDetail {
	String tableName;  //表名
	int	 number;		//数据量
	List<fieldDetail> fieldDetails;  //字段
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void addField(fieldDetail field){
		if(fieldDetails==null){
			fieldDetails=new ArrayList<fieldDetail>();
		}
		fieldDetails.add(field);
	}
	
	public List<fieldDetail> getFieldDetails() {
		return fieldDetails;
	}
	public void setFieldDetails(List<fieldDetail> fieldDetails) {
		this.fieldDetails = fieldDetails;
	}
	/**
	 * 得到批量insert语句
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * */
	public String toSQL() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
	
		String SQL="";
		for(int i=0;i<number;i++){			
			String insert="INSERT INTO table_name (columns) VALUES (values);\n";
			insert=insert.replaceAll("table_name", tableName);	
			String columns="";
			String values="";
			for(fieldDetail f:fieldDetails){
				Map<String, String> map=f.toFieldSQL();
				Set<String> set=map.keySet();
				for(String str:set){
					columns+=(","+str);
					values+=(",'"+map.get(str)+"'");
				}
			}
			insert=insert.replaceFirst("columns", columns.replaceFirst(",", ""));
			insert=insert.replaceFirst("values", values.replaceFirst(",", ""));
			SQL+=insert;
		}
		return SQL;
	}
	
}
