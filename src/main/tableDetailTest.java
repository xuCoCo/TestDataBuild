package main;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class tableDetailTest {

	@Test
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		tableDetail table= new tableDetail();
		table.setTableName("student");
		table.setNumber(1000);
		
		fieldDetail field=new fieldDetail();
		field.setFieldName("uuid");
		field.setRule("getUUID");
		table.addField(field);
		
		field=new fieldDetail();
		field.setFieldName("createdate,updatedata");
		field.setRule("getTimes");
		field.setParam("2016-09-15,2016-09-18,2");
		table.addField(field);
		
		field=new fieldDetail();
		field.setFieldName("callType");
		field.setRule("getRandon");
		field.setParam("0,1,2,3,4");
		table.addField(field);
		
		
		String jsonString= JSON.toJSONString(table);
		System.out.println(jsonString);
		
		
	}

}
