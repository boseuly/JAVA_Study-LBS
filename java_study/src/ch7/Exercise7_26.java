package ch7;
/*
 * 내부 클래스(Inner class)
 * A클래스 안에서만 사용하는 클래스라면 A클래스 내부에 넣어서 B클래스를 내부 클래스로 만들어준다.
 * 그렇게 하면 객체 타입 변수를 선언하지 않아도 B클래스의 객체를 쉽게 사용할 수 있다. 
 * 단, 외부에서 B클래스를 사용할 수 없다. (B클래스 타입의 변수를 선언한다던가 할 수 없다.)
 * 
 * 외부,내부클래스는 내부,외부 클래스의 멤버를 바로 사용할 수 있다.
 */

class Outer1 {
	static class Inner{		// static 클래스 -> 공용으로 사용 가능한 클래스
		int iv = 200;		// static 내부 클래스에서도 인스턴스 
	}
}


public class Exercise7_26 {
	
	public static void main(String[] args) {
		/*
		 * [7-26] Outer Inner iv 클래스의 내부 클래스 의 멤버변수 의 값을 출력하시오.
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		
		// static 내부 클래스는 외부 객체를 생성하지 않아도 된다.
		Outer1.Inner in = new Outer1.Inner();
		System.out.println(in.iv);
	
		
	}

}
