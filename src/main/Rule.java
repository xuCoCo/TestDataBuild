package main;

import java.text.ParseException;
import java.util.Random;
import java.util.UUID;

public class Rule {
	/**
	 * 随机生产一个UUID
	 */
	public String getUUID() {
		return comment.getUUID();
	}

	/**
	 * 随机生产特定数量的UUID
	 */
	public String getUUID(String param) {
		int num = Integer.valueOf(param);
		String[] UUIDs = comment.getUUID(num);
		return comment.getString(UUIDs);
	}

	/**
	 * 多组数据，随机返回一组
	 */
	public String getRandon(String param) {
		String[] datas = comment.getArray(param);
		return comment.getRandon(datas);
	}

	/**
	 * 随机产生一个long随机数
	 */
	public String nextLong() {
		return String.valueOf(comment.nextLong());
	}

	/**
	 * long之间随机生产一个随机数,随机产生特定数量的long
	 * @throws ParseException 
	 */
	public String nextLong(String param) throws ParseException {
		String[] arr = comment.getArray(param);
		if (arr.length == 2) {
			// long之间随机生产一个随机数
			long or = Long.valueOf(arr[0]).longValue();
			long bo = Long.valueOf(arr[1]).longValue();
			return String.valueOf(comment.nextLong(or, bo));
		} else {
			// 随机产生特定数量的long
			long origin = Long.valueOf(arr[0]).longValue();
			long bound = Long.valueOf(arr[1]).longValue();
			int n = Integer.valueOf(arr[2]).intValue();
			long[] longs = comment.nextLong(origin, bound, n);
			return comment.getString(longs);
		}
	}
	/**
	 * 随机产生手机号码
	 * */
	public String getPhoneNumber(String param){
		String[] arr = comment.getArray(param);
		// long之间随机生产一个随机数
		long or = Long.valueOf(arr[0]).longValue();
		long bo = Long.valueOf(arr[1]).longValue();
		return String.valueOf(comment.nextLong(or, bo));
	}
	/**
	 * 产生一定数量的升序的时间点
	 * @throws ParseException 
	 * */
	public String getTimes(String param) throws ParseException{
		String[] arr = comment.getArray(param);
		// 随机产生特定数量的long
		long origin = comment.getCalendar(arr[0]);
		long bound = comment.getCalendar(arr[1]);
		int n = Integer.valueOf(arr[2]).intValue();
		long[] longs = comment.nextLong(origin, bound, n);
		return comment.getString(longs);
	}

}
