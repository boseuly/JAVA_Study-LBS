package ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10_5 {
	/*
	 * (1) getDayDiff 메서드를 작성하시오.
	 */
	static int getDayDiff (String yyyymmdd1, String yyyymmdd2) {
		Date date1 = null;
		Date date2 =null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		try{
			date1 = sdf.parse(yyyymmdd1);	// NUMBER 로 바꿔주고
			date2 = sdf.parse(yyyymmdd2);
		}catch (Exception e) {
			return 0;
		}
			
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		long dateDiff = ( cal1.getTimeInMillis() - cal2.getTimeInMillis())/ (1000*24*60*60);
		
		
		return (int)dateDiff;
	}
	
	public static void main(String[] args) {
		// [10-5]
		System.out.println(getDayDiff("20010103","20010101"));
		System.out.println(getDayDiff("20010103","20010103"));
		System.out.println(getDayDiff("20010103","200103"));

	}

}
