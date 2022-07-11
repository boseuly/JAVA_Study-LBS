package ch10;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;

public class Exercise10_3 {
/*[10-3] 문자열 “123,456,789.5”를 소수점 첫 번째 자리에서 반올림하고,
 *  그 값을 만 단위마다 콤마(,) 로 구분해서 출력하시오.
*/
	public static void main(String[] args) {
		String str = "123,456,789.5";
		DecimalFormat df1 = new DecimalFormat("#,###.#");
		DecimalFormat df2 = new DecimalFormat("#,###");
//		DecimalFormat df2 = new DecimalFormat("#");  반올림 방법 중 하나
		Number num;
		try {
			// parseInt메서드는 콤마가 있는 문자열을 숫자로 변환할 수 없다.
			num = df1.parse("123,456,789.5");
			double d = num.doubleValue();
			int i = (int)Math.round(d);		// 반올림 해준다.
			
			System.out.println("반올림 : " + i);	// 반올림한 숫자를 출력
			System.out.println("만단위 : " + df2.format(i));	// 반올림한 숫자를 df2 형식에 맞춰서 문자열로 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
