package ch10;

import java.time.LocalDate;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

public class Exercise10_7 {  // 틀림

	public static void main(String[] args) {
		//[10-7] 2016 년 12월 네번째 화요일의 날짜를 아래의 실행결과와 같은 형식으로 출력하시오.
		// 일: 1 ~ 토: 7
		// 1일이 몇 요일인지가 중요! 만약 1일이 화요일이라면
//		Date d = new Date();
//		String date = "2016-12-01";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		try {
//			d = sdf.parse(date);	// 문자 -> 날짜로
//			
//		} catch (ParseException e) {
//			System.out.println("형식 틀림");
//		}
//		Calendar cal = Calendar.getInstance();
//		int day=0;
//		cal.setTime(d); // date -> Calendar
//		if (cal.get(Calendar.DAY_OF_WEEK) == 3) { // 만약 1일이 화요일이라면
//			day = 21; 
//		}else if(cal.get(Calendar.DAY_OF_WEEK) == 2){ // 만약 월(2) 이라면 요일을 더해줘야 한다.
//			day = 21+ 1; // 화 - 월 = 1 
//		}else if(cal.get(Calendar.DAY_OF_WEEK) == 1){// 만약 일(1)이라면 (일 - 화 < 0 라서 따로 해줌 ) 
//			day = 28 - (3 + 1); // 화 + 일 = 4
//		}else {																	// 만약 화요일이 아니라면
//			day= (28 - (Calendar.DAY_OF_WEEK  - 3)); // 해당 요일 - 화  
//		}
//		cal.set(Calendar.DAY_OF_MONTH, day + 1);
//		// date로 변환
//		d = new Date( cal.getTimeInMillis());
//		System.out.println(sdf.format(d));
//		// 27 이 출력되어야 하는데 29가 출력됨
		
		// LocalDate()
		LocalDate date = LocalDate.of(2016, 12,1);
		System.out.println(date.with(dayOfWeekInMonth(4, TUESDAY)));
		
		
		//[10-7] 2016 년 12월 네번째 화요일의 날짜를 아래의 실행결과와 같은 형식으로 출력하시오.
		/* 재은언니
		 * for(int i = 1; i <= 31; i++) {
            LocalDate date16 = LocalDate.of(2016, 12, i);
            if(date16.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 4 && date16.get(ChronoField.DAY_OF_WEEK) ==2) {
                System.out.println(date16);
                break;
            } else {
                continue;
            }
        }
		 */
	}

}
