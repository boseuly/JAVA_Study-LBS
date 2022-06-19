package ch07;

abstract class Unit {
	int x,y; 	// 현재 위치
	abstract void move(int x, int y);
	void stop() {/*현재 위치에 정지*/}
}

class Marine extends Unit{
	void stimPack() {/*스팀팩을 사용한다.*/}

	@Override
	void move(int x, int y) {
		
	}
}

class Tank extends Unit{
	void changeMode() {/*공격모드를 변환한다.*/}

	@Override
	void move(int x, int y) {
		
	}
}

class Dropship extends Unit{
	void load() {/*선택된 대상을 태운다.*/}
	void unload() {/*선택된 대상을 내린다.*/}
	@Override
	void move(int x, int y) {
		
	}
}
// 인터페이스 -> 추상 메소드와 상수만 작성할 수 있다.

public class Exercise7_17 {
	public static void main(String[] args) {
		/*
		 * [7-17] 아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만들고
		 * 이 클래스를 상속받도록 코드를 변경하시오.
		 */
		
	}

}
