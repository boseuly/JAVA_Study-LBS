package ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10_1 {	// 틀림
    /*[10-1] Calendar 클래스와 SimpleDateFormat클래스를 이용해서 2010년의 매월 두 번째
    일요일의 날짜를 출력하시오.
    */
	public static void main(String[] args) {
		 Calendar cal = Calendar.getInstance();
	        cal.set(2010, 0, 1);

	        
	        // 달을 +1씩 해줘야 한다. 
	        for(int i=0; i < 12; i++){
	        	int weekday = cal.get(Calendar.DAY_OF_WEEK); // 1 . 일의 요일을 구한다
	            int secondSunday = (weekday==1) ? 8 : 16 - weekday;
	            cal.set(Calendar.DAY_OF_MONTH, secondSunday);

	            Date d = cal.getTime(); // Calendar Date . 를 로 변환한다
	            System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.").format(d));

	            cal.add(Calendar.MONTH, 1);
	            cal.set(Calendar.DAY_OF_MONTH,1);
	        }
	}

}