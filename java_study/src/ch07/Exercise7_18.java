package ch07;


public class Exercise7_18 {
	/*
	 * (1) action 메서드를 작성하시오.
	 */
	static void action(Robot r) {	
		if(r instanceof DanceRobot) {			// 만약 r이 참조하고 있는 타입이 DanceRobot이라면 
			DanceRobot robot = (DanceRobot)r;	// 1. r을 DanceRobot으로 형변환한다.
			 robot.dance();						// 2. DanceRobot 클래스의 dance() 메소드를 호출한다.
		}else if(r instanceof SingRobot) {		// 만약 r이 참조하고 있는 타입이 SingRobot이라면
			SingRobot robot = (SingRobot)r;		// 1. r을 SingRobot으로 형변환한다.
			robot.sing();						// 2. SingRobot 클래스의 sing() 메소드를 호출한다.
		}else {									// 반복
			DrawRobot robot = (DrawRobot)r;	
			robot.draw();
		}
	}
	
	
	public static void main(String[] args) {
		/*
		 * [7-18] 다음과 같은 실행결과를 얻도록 코드를 완성하시오.
		 * [hint] instanceof연산자를 사용해서 형변환한다.
		 * 
		 * 메서드명 : action
		 * 기능 : 주어진 객체의 메서드를 호출한다.
		 * 		DanceRobot인 경우, dance()를 호출,
		 * 		SingRobot인 경우, sing()을 호출,
		 * 		DrawRobot인 경우, draw()를 호출
		 * 반환타입 : 없음
		 * 매개변수 : Robot r - Robot 인스턴스 또는 Robot의 자손 인스턴스
		 */
		
		Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
	
		for(int i = 0; i < arr.length;i++) {
			action(arr[i]);
		}
	}
}
	
class Robot{}

class DanceRobot extends Robot{
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot{
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot{
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}
	

