package ch10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Exercise10_4 {

	public static void main(String[] args) {
	// [10-4]
	/*화면으로부터 날짜를 “2007/05/11”의 형태로 입력받아서 무슨 요일인지 출력하
		는 프로그램을 작성하시오.
		단 입력된 날짜의 형식이 잘못된 경우 메세지를 보여주고 다시 입력받아야 한다 .
	*/
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 yyyy/MM/dd 형식으로 입력해주세요.(입력예 : 2022/06/18)");
		
		// input 이 형식에 맞는지 확인하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// 받은 문자열을 date로 바꿔야 한다.
		Date inDate = new Date();
		while(true) {
			try {
				// input을 Number로 바꾼 다음에 sdf의 형식에 맞추기
				String input = sc.nextLine(); // 날짜를 입력 받는다.
				inDate =sdf.parse(input);
				break;
			} catch (ParseException e) {
				System.out.println("날짜를 yyyy/MM/dd 형식으로 입력해주세요.(입력예 : 2022/06/18)");
			} 
		}
		System.out.println(sdf.format(inDate));
		SimpleDateFormat sdf2 = new SimpleDateFormat("입력하신 날짜는 E요일입니다.");
		System.out.println(sdf2.format(inDate));
	}

}
