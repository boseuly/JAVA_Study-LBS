package exam02;

class Stu01{
	public static void main(String args[]) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
		
	}
}
	



class SutdaCard {
	/*
	 * [6-1] 다음과 같은 멤버변수를 갖는 SutdaCard 클래스를 정의하시ㅇ.
	 * 	타입 			변수명			설명
	 * ------------------------------------------
	 * 	int			num		카드의 숫자(1~10사이의 정수)
	 * ------------------------------------------
	 * boolean    isKwang	광이면 true, 아니면 false
	 * 
	 */
	int num;
	boolean isKwang;	// 기본값이 true
	
	// 매개 변수 없는 생성자 & 매개변수 있는 생성자
	public SutdaCard() {
		this(1, true);
	}
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String info() {		
		if(isKwang) {		// 만약 isKwang이 true면 
			return num+"k";	// 숫자를 문자열로 변환하기 위해서는 ""를 해주면 된다.
		}
		return num + "";		// 만약 광이 아니라면 그냥 num만 리턴한다.
	}
	
	
}
