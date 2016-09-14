package main;

import java.util.Random;
import java.util.UUID;

public class Rule {
	/**
	 * 随机生产一个UUID
	 * */
	public static String getUUID(){		
		return comment.getUUID();
	}
	/**
	 * 随机生产特定数量的UUID
	 * */
	public static String getUUID(String param){
		int num=Integer.valueOf(param);
		String[] UUIDs=comment.getUUID(num);
		return comment.getString(UUIDs);
	}
	/**
	 * 多组数据，随机返回一组
	 * */
	public static String getRandon(String param){
		String[] datas=comment.getArray(param);
		return comment.getRandon(datas);
	}
	/**
	 * 随机产生一个long随机数
	 * */
	public static String nextLong(){
		return String.valueOf(comment.nextLong());
	}
	/**
	 * long之间随机生产一个随机数
	 * */
	 public static String nextLong(String param) {
		 String[] arr=comment.getArray(param);
	   long or = Long.valueOf(arr[0]).longValue();
	   long bo = Long.valueOf(arr[1]).longValue();
	   return String.valueOf(comment.nextLong(or, bo));
	 }
	 /**
	  * 随机产生特定数量的long
	  * */
	 public static String nextLongs(String param){
		 String[] arr=comment.getArray(param);
		 long origin=Long.valueOf(arr[0]).longValue();
		 long bound=Long.valueOf(arr[1]).longValue();
		 int n=Integer.valueOf(arr[2]).intValue();
		 long[] longs=comment.nextLong(origin, bound, n);
		 return comment.getString(longs);		 
	 }
}
