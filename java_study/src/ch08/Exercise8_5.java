package ch08;

public class Exercise8_5 {
	// [8-5]
	static void method(boolean b) {	//(틀림)
		try {
			System.out.println(1);
			if(b) throw new ArithmeticException();	// 예외  
			System.out.println(2);					// 얘는 실행 안 됨 
		} catch(RuntimeException r) {
			System.out.println(3);					// 예외처리
			return;									// return을 하더라도 finally는 실행
		} catch(Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);			
		}
		System.out.println(6);		// return; 을 통해 메서드를 빠져나가니까 예외가 발생하면 이 코드는 실행되지 않는다. 
	}
	/*
	 * 실행 결과 : 
	 * 1, 3, 4, 5, 6
	 * 1, 2, 5, 6
	 * 
	 * 정답
	 * 1,3,5,
	 * 1,2,5,6
	 * 
	 * 순간 ArithmeticException 예외가 RuntimeException 예외에 포함 안 되는 줄,, 
	 * 처음에 작성한 답이 맞았는데 수정함
	 */

	public static void main(String[] args) {
		method(true);
		method(false);
	}

}
	// 알게된 것 : return; 을 통해 메서드를 빠져나가니까 예외가 발생하면 이 코드는 실행되지 않는다.
