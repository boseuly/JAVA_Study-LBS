package ch07;

import ch07.Outer.Inner;

class Outer {
	class Inner {
		int iv=100;
	}
}


public class Exercise7_25 {
	public static void main(String[] args) {
		/*
		 * [7-25] Outer Inner iv 클래스의 내부 클래스 의 멤버변수 의 값을 출력하시오.
		 *(1) 알맞은 코드를 넣어 완성하시오.
		 */
		
		Outer o = new Outer();	// 외부 클래스를 먼저 선언해줘야 한다. 
		Inner i = o.new Inner();	// 내부 클래스 객체를 생성하기 위해서는 외부클래스의 인스턴스를 통해 접근해야 한다.
		System.out.println(i.iv);
		
		
	}

}
