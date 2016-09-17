package main;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.junit.Test;

public class RuleTest {

	@Test
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		fieldDetail field1=new fieldDetail();
		field1.setFieldName("test");
		field1.setRule("getUUID");		
		Map map1 =field1.toFieldSQL();
		assertTrue(map1.get("test")!=null);
		System.out.println(map1.get("test"));
		
		fieldDetail field2=new fieldDetail();
		field2.setFieldName("test");
		field2.setRule("getUUID");	
		field2.setParam("2");
		Map map2 =field2.toFieldSQL();
		assertTrue(map2.get("test")!=null);
		System.out.println(map2.get("test"));
		
		fieldDetail field3=new fieldDetail();
		field3.setFieldName("test");
		field3.setRule("getRandon");	
		field3.setParam("1,2,3,4,5");
		Map map3 =field3.toFieldSQL();
		assertTrue(map3.get("test")!=null);
		System.out.println(map3.get("test"));
		
		fieldDetail field4=new fieldDetail();
		field4.setFieldName("test");
		field4.setRule("nextLong");	
		Map map4 =field4.toFieldSQL();
		assertTrue(map4.get("test")!=null);
		System.out.println(map4.get("test"));
		
		fieldDetail field5=new fieldDetail();
		field5.setFieldName("test1,test2");
		field5.setRule("nextLong");	
		field5.setParam("1380000000000,1389999999998,2");
		Map map5 =field5.toFieldSQL();
		assertTrue(map5.get("test1")!=null);
		System.out.println(map5.get("test1"));
		
	}

}
