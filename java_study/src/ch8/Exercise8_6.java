package ch8;

public class Exercise8_6 {

	public static void main(String[] args) {	//(틀림)
		//[8-6]
		// 실행순서 : 3,4,5
		// 정답 : 3,5
		try {
			method1();				// 예외가 아직 안 잡힘
		} catch(Exception e) {		// NullPointException은 Exception을 상속함 -> 처리 가능
			System.out.println(5);	// 실행 o
		}
	}
	
	static void method1() {
		try {
			method2();
			System.out.println(1);			// 예외 발생해서 여기 실행 x
		} catch(ArithmeticException e) {	// NullPointerException은 ArithmeticExcption을 상속하지 않아서 예외 처리 x -> 예외를 처리해줄 catch가 없으니까 메소드 빠져나감 
			System.out.println(2);			// 여기 실행 x
		} finally {							// 예외가 발생하든 안 하든 실행 o
			System.out.println(3);
		}
			
		System.out.println(4);		// 예외를 처리해줄 catch가 없어서 메소드 빠져나감 -> 실행 x
	} // method1()
	
	static void method2() {
		throw new NullPointerException();

	}
	// 알게된 것 : 예외를 처리해줄 catch가 없으면 메소드 빠져나감 
}
