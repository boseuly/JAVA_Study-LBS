package ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10_2 {
	static int paycheckCount(Calendar from, Calendar to) {	// 틀림
		/*
		(1) 아래의 로직에 맞게 코드를 작성하시오.
		1. from  또는 to가  null이면  0을 반환한다.
		2. from 와  to 가 같고 날짜가 21일이면 1을 반환한다.
		3. to와  from이 몇 개월 차이인지 계산해서  monDiff변수 에 담는다.
		4. monDiff  가 음수이면 0을 반환한다.
		5. 만일 from 의 일 (DAY_OF_MONTH) 이 21일  이거나 이전이고
		to 의 일(DAY_OF_MONTH) 이 21 일이거나 이후이면 monDiff의 값을 1증가시킨다.
		6. from 만일 의 일(DAY_OF_MONTH) 이 21일 이후고
		to  의 일 (DAY_OF_MONTH) 이 21일 이전이면  monDiff 의 값을 1감소시킨다.
		*/
		
		if(from==null || to== null) {
			return 0;
		}
		if (from.equals(to) && from.get(Calendar.DAY_OF_MONTH) == 21) {
			return 1;
		}
//		else if (from.equals(to) && from.get(Calendar.DAY_OF_MONTH) != 21) {
//			return 0;
//		}
//		
		 // 년도, 월, 일 구해놓기
		 int toYear = to.get(Calendar.YEAR);
		 int toMonth = to.get(Calendar.MONTH);
		 int toDay = to.get(Calendar.DAY_OF_MONTH );
		 
		 int fromYear = from.get(Calendar.YEAR);
		 int fromMonth = from.get(Calendar.MONTH);
		 int fromDay = from.get(Calendar.DAY_OF_MONTH );
		 
		 // to와 from 이 몇 개월 차이인지 계산 )
//		monthDiff = toMonth - fromMonth; (이거 이렇게 계산하면 안 되는 이유 : 3월 1일과 4월 31일 달로 계산했을 때의 차이와 일로 계산했을 때의 차이가 다르다.)
		int monthDiff = (toYear * 12 + toMonth ) - (fromYear * 12 + fromMonth);
		 // monthDiff가 음수라면 0을 반환
		 if(monthDiff < 0 ) {
			 return 0;
		 }

		 // 이미 월급을 받은 이후인지, 월급을 받기 전인지 확인
		 if (fromDay < 21 && toDay >= 21) {
			 monthDiff++;
		 }
		 if(fromDay > 21 && toDay < 21) {
			 monthDiff--;
		 }
		return monthDiff;
		}
	static void printResult(Calendar from, Calendar to) {
		Date fromDate = from.getTime();
		Date toDate = to.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print(sdf.format(fromDate)+" ~ "+sdf.format(toDate)+":");
		System.out.println(paycheckCount(from, to));
	}

	public static void main(String[] args) {
/*
[10-2] 어떤 회사의 월급날이 매월 21일이다. 두 날짜 사이에 월급날이 몇 번있는지 계산해서 반환하는 메서드를 작성하고 테스트 하시오.
 */
//	
//				Calendar fromCal = Calendar.getInstance();
//				Calendar toCal = Calendar.getInstance();
//				
//				fromCal.set(2010,0,1);
//				toCal.set(2010,0,1);
//				printResult(fromCal, toCal);
//				
//				fromCal.set(2010,0,21);
//				toCal.set(2010,0,21);
//				printResult(fromCal, toCal);
//				
//				fromCal.set(2010,0,1);
//				toCal.set(2010,2,1);
//				printResult(fromCal, toCal);
//				
//				fromCal.set(2010,0,1);
//				toCal.set(2010,2,23);
//				printResult(fromCal, toCal);
//				
//				fromCal.set(2010,0,23);
//				toCal.set(2010,2,21);
//				printResult(fromCal, toCal);
//				
//				fromCal.set(2011,0,22);
//				toCal.set(2010,2,21);
//				printResult(fromCal, toCal);
//				
				// eDay.set(year, month-1, day) 이런 식으로 달에 -1을 해줘야 한다고 했는데 
				Calendar cal = Calendar.getInstance();
				Date date = new Date();
				
//				cal.set(2022,11, 1);			 // set에 11
//				System.out.println(cal.get(Calendar.MONTH));// 11 -> 12  교재 내용대로라면 -1이 된 3이 나와야 하는데 4가 나옴..
//				cal.add(cal.get(Calendar.MONTH), 1);	// 11 -> 12
//				System.out.println(cal.get(Calendar.MONTH));
//				
	}
/* 실행결과
 * 2010-01-01 ~ 2010-01-01:0
2010-01-21 ~ 2010-01-21:1
2010-01-01 ~ 2010-03-01:2
2010-01-01 ~ 2010-03-23:3
2010-01-23 ~ 2010-03-21:2
2011-01-22 ~ 2010-03-21:0
 */
}
