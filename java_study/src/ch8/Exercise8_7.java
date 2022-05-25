package ch8;

public class Exercise8_7 {
	// [8-7]
	static void method(boolean b) {	// (틀림)
		/*
		 * 실행 결과 : 
		 * 1
		 * 1,2,5,6
		 * 
		 * 정답 : 1
		 */
		try {
			System.out.println(1);
			if(b) System.exit(0);			// 시스템을 종료
			System.out.println(2);
		} catch(RuntimeException r) {
			System.out.println(3);
			return;
		} catch(Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		}
		
		System.out.println(6);
	}
	
	public static void main(String[] args) {
		method(true);
		method(false);	// 위에서 종료한 게 영향을 미칠 줄 몰랐음... 생각해보면 당연한 거
	}

}
