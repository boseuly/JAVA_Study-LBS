package ch10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10_6 {
//	[10-6] 자신이 태어난 날부터 지금까지 며칠이 지났는지 계산해서 출력하시오.

	public static void main(String[] args) {
		// birth day = 1999-05-15
		// today = 2022-06-19
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthday = "1999-05-15";
		Date today = new Date(); // 오늘 날짜
		Date birth = null;				// 생일 날짜
		
		try {
			birth = sdf.parse(birthday); // 문자 -> date() 형식으로
			
		} catch (ParseException e) {
			System.out.println("형식이 올바르지 않습니다.");
		}
		// date()를 Calendar 으로 변환(수를 빼주기 위해서) 
		Calendar bd = Calendar.getInstance();
		Calendar td = Calendar.getInstance();
		bd.setTime(birth);
		td.setTime(today);
		
		long dayDiff = (td.getTimeInMillis() -  bd.getTimeInMillis()) / (1000*60*60*24);
		
		System.out.println("birth day = " + sdf.format(birth));
		System.out.println("today = " + sdf.format(today));
		System.out.println(dayDiff + "days");
		
		
	}
}
