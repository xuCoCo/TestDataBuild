package main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class comment {
	/**
	 * 随机生产一个UUID
	 * */
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
	/**
	 * 随机生产特定数量的UUID
	 * */
	public static String[] getUUID(int number){
		if(number <1 ){
			return null;
		}
		String[] ss=new String[number];
		for(int i=0;i < number; i++){
			ss[i]=getUUID();
		}
		return ss;
	}
	/**
	 * 多组数据，随机返回一组
	 * */
	public static String getRandon(String[] data){
		int length=data.length;
		if(length<0)
			return null;
		Random random=new Random();
		int index=random.nextInt(length);
		return data[index];
	}
	/**
	 * 随机产生一个long随机数
	 * */
	public static long nextLong(){
		Random random=new Random();
		return random.nextLong();
	}
	/**
	 * long之间随机生产一个随机数
	 * */
	 public static long nextLong(long origin, long bound) {
		   long r = nextLong();
		   long n = bound - origin, m = n - 1;
		   if ((n & m) == 0L)  // power of two
		     r = (r & m) + origin;
		   else if (n > 0L) {  // reject over-represented candidates
		     for (long u = r >>> 1;            // ensure nonnegative
		          u + m - (r = u % n) < 0L;    // rejection check
		          u = nextLong() >>> 1) // retry
		         ;
		     r += origin;
		   }
		   else {              // range not representable as long
		     while (r < origin || r >= bound)
		       r = nextLong();
		   }
		   return r;
	 }
	 /**
	  * 随机产生特定数量的long
	  * */
	 public static long[] nextLong(long origin,long bound,int n){
		 long[] rs=new long[n];
		 long length=(bound-origin)/n;
		 for(int i=0;i<n;i++){
			 //origin+=length;
			 long temp=nextLong(origin+(i*length), origin+((i+1)*length));
			 if(i==0){
				 rs[0]=temp;
			 }else{
				 int j=i;
				 while(j>0 && temp<rs[j-1]){
					 rs[j]=rs[j-1];
					 j--;
				 }
				 rs[j]=temp;
			 }

		 }
		 return rs;		 
	 }
	 /**
	  * 分割字符串为数组
	  * */
	 public static String[] getArray(String str){
		 return str.split(",");
	 }
	 /**
	  * 字符数组组合成字符串
	  * */
	 public static String getString(String[] strArr){
		 String rs="";
		 if(strArr.length>0){
			 rs=strArr[0];
		 }
		 for(int i=1;i<strArr.length;i++){
			 rs+=",";
			 rs+=strArr[i];
		 }
		 return rs;
	 }
	 /**
	  * long数组组合成字符串
	 * @throws ParseException 
	  * */
	 public static String getString(long[] Arr) throws ParseException{
		 String rs="";
		 if(Arr.length>0){
			 rs=getFormat(Arr[0]);
		 }
		 for(int i=1;i<Arr.length;i++){
			 rs+=",";
			 rs+=getFormat(Arr[i]);
		 }
		 return rs;
	 }
	 /**
	  * yyyy-MM-dd转为long
	 * @throws ParseException 
	  * */
	 public static long getCalendar(String format) throws ParseException{
		 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		 Date date=sf.parse(format);
		 Calendar cal=Calendar.getInstance();
		 cal.setTime(date);
		 return cal.getTimeInMillis();
	 }
	 /**
	  * long转为yyyy-MM-dd hh:mm:ss
	 * @throws ParseException 
	  * */
	 public static String getFormat(long millis) throws ParseException{
		 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		 Calendar cal=Calendar.getInstance();
		 cal.setTimeInMillis(millis);
		 String date=sf.format(cal.getTime());
		 return date;
	 }
	 
	 
}
