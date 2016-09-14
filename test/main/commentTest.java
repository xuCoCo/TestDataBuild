package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class commentTest {

	@Test
	public void testgetUUID() {
		assertNotNull(comment.getUUID());
		assertEquals(comment.getUUID(5).length, 5);
	}	
	@Test
	public void testgetRandon(){
		String[] s={"1","2","3","4","5"};
		String rs=comment.getRandon(s);
		int i=0;
		for(;i<s.length;i++){
			if(s[i].equals(rs)){
				break;
			}
		}
		assertTrue(i<s.length);
	}
	@Test
	public void testnextLong(){
		long[] rs=comment.nextLong(100, 9999999, 5);
		assertEquals(rs.length, 5);
		for(int i=0;i<rs.length;i++){
			assertTrue(rs[i]>=100 && rs[i]<9999999);
			if(i<rs.length-1){
				assertTrue(rs[i]<=rs[i+1]);
			}
		}
	}
	@Test
	public void testgetArray(){
		String[] arr=comment.getArray("1,2,3,4,5");
		assertEquals(arr.length, 5);
	}
	@Test
	public void testgetString(){
		String[] arr={"1","2","3","4","5"};
		String str=comment.getString(arr);
		assertEquals("1,2,3,4,5", str);
		arr=new String[]{"1"};
		str=comment.getString(arr);
		assertEquals("1", str);
	}

}
