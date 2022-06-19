package ch02;

class Marine{
	/*
	 * [6-9]
	 */
	int x = 0, y = 0;	// marine의 위치좌표(x,y)		-> 인스턴스
	int hp = 60;		// 현재 체력					-> 인스턴스
	int weapon = 60;	// 공격력						-> static
	int armor = 0;		// 방어력						-> static
	
	void weaponUp() {	//							-> static
		weapon++;
	}
	
	void armorUp() {							//	-> static
		armor++;
	}
	void move(int x, int y) {					//	-> 인스턴스
		this.x = x;
		this.y = y;
	}
	
	
	
}

public class Stu06 {

	public static void main(String[] args) {
		/*
		 * [6-9] 다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다. 이 클래스의 멤버 중에 static을 붙여야 하는 
		 * 것은 어떤 것들이고 그 이유는 무엇인가?
		 * (단, 모든 병사의 공격력과 방어력은 같아야 한다.)
		 */
		
		
		
		
	}

}
