package ch07;

public class Exercise7_20 {

	public static void main(String[] args) {
		/*
		 * [7-20] 다음의 코드를 실행한 결과를 적으시오.
		 * 
		 */
		
		Parent p = new Child();
		Child c = new Child();
		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;
	void method() {
		System.out.println("Child Method");
	}

}

/* 
 * 내 답안 : 100
 * 		   Parent Method
 * 		   200
 *         Child Method
 *         
 * 정답 : 100
 * 		Child Method
 * 		200
 * 		Child Method
 *         
 * 메서드의 경우 조상 클래스의 메서드를 자손 클래스에서 오버라이딩한 경우에도 참조변수의 타입에 관계없이 항상 실제 인스턴스의 메서드(오버라이딩된 메서드)가
 * 호출되지만, 멤버변수의 경우 참조변수의 타입에 따라 달라진다.
 */

/*
 * [7-21] 다음과 같이 attack 메서드가 정의되어 있을 때, 이 메서드로 매개변수로 가능한 것 두 가지를 적으시오.
 * 
 * 내 답안 : move(int x, int y)
 * 		   null
 */



