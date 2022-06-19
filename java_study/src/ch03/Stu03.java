package ch03;

public class Stu03 {

	 /*
	 * (1) isNumber메서드를 작성하시오.
	 */
	
	static boolean isNumber(String str) {
		boolean result = true;
		char tmp = 0;
		for(int i = 0; i < str.length(); i++) {		// 하나씩 뽑아서 숫자범위에 해당하는지 확인
			tmp = str.charAt(i);	// 문자열 하나 저장
			if(tmp >= 48 && tmp <= 57) {			// 숫자 범위
				result = true;		  
			}else {
				return false;		// 숫자 중에 하나라도 FALSE가 있다면 false 반환
			}
		}
		
		return true;
	}
	
	/* 유라언니 풀이
	 *   if(str == null || str.equals("")) {
            return false;
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
	
	*/
	public static void main(String[] args) {
		/*
		 * [6-22] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
		 * 
		 * 메서드명 : isNumber
		 * 기능 : 주어진 문자열이 모두 숫자로만 이루어져 있는지 확인한다.
		 * 		모두 숫자로만 이루어져 있으며 true를 반환하고, 그렇지 않으면 false를 반환한다.
		 * 		만일 주어진 문자열이 null이거나 빈문자열 ""이라면 false를 반환한다.
		 * 반환타입 : boolean
		 * 매개변수 : String str - 검사할 문자열
		 * 
		 * [hint]String 클래스의 charAt(int i) 메서드를 사용하면 문자열의 i번째 위치한 문자를 얻을 수 있다
		 */
		String str = "123";
		System.out.println(str + "은 숫자입니까 ? " + isNumber(str));
		
		str = "i1234o";
		System.out.printf(str + "은 숫자입니까 ? " + isNumber(str));
		
		
	}

}
