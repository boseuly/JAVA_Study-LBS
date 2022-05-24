package ch7;
import java.awt.*;
import java.awt.event.*;

public class Exercise7_28 {

	public static void main(String[] args) {
		// [7-28] 아래의 EventHandler를 익명 클래스 (anonymous class)로 변경하시오  
		// 답안
		Frame f = new Frame();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}

}

/*
 * 익명 클래스 : 이름이 없는 일회용 클래스, 정의와 생성을 동시에 한다.
 * 
 * 원래는 class MyClass extends Object { 멤버 선언 } 클래스가 있으면
 * MyClass mc = new MyClass(); 이렇게 객체를 생성하는데
 * 
 * 익명 클래스는 자신의 이름이 없기 때문에 객체를 생성할 때 조상이름 또는 인터페이스이름을 사용한다.
 * new 조상클래스이름() { 멤버선언 }
 * 
 * new 구현인터페이스이름() { 멤버 선언 }
 */



// [7-29] 지역 클래스에서 외부 클래스의 인스턴스 멤버와 멤버에 모두 접근할 수 있지만, 
// 지역변수는 final static이 붙은 상수만 접근할 수 있는 이유 무엇인가?

// 내 답안 : 지역 메서드는 실행이 종료되면 바로 소멸 되기 때문에 내부 클래스가 메서드보다
// 오래 존재하게 되어 메소드 내의 (상수를 제외한) 지역변수를 사용하지 못 하는 것이다.  
// 상수는 다른 메모리 공간에 저장되어 있기 때문에 메서드가 종료되어도 소멸되지 않음.