package main;

import java.util.ArrayList;
import java.util.List;

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
	/**
	 * 得到批量insert语句
	 * */
	public void getSQL(){
		//TODO
	}
}
