package ch7;

class Outer2 {	// 틀림
	int value=10;
	
	class Inner {		// Outer 클래스의 인스턴스 내부 클래스
		int value=20;	// 내부 클래스의 인스턴스변수
		void method1() {
			int value=30;
//			System.out.println(value);		// 실행결과 : 30
//			System.out.println(Inner.this);	// 실행결과 : 20	// 지역내부 클래스에서는 상수만 접근 가능함
//			System.out.println(Outer.this);	// 실행결과 : 10
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer2.this.value);
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

public class Exercise7_27 {

	public static void main(String[] args) {
		//[7-27] 다음과 같은 실행결과를 얻도록 (1)~(4)의 코드를 완성하시오. 
		// (4)
		// 인스턴스 내부 클래스는 객체를 생성해야 한다.
		Outer2 outer = new Outer2();
		Outer2.Inner inner = outer.new Inner();
		inner.method1();
	}

}
