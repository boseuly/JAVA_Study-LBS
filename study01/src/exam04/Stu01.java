package exam04;

class SutdaDeck{
	final int CARD_NUM = 20;	
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		/*
		 * (1) 배열 SutdaCard를 적절히 초기화 하시오.
		 */
		 
		int idx = 0;
		boolean bool = false;
		for(int i = 0; i < 2; i++) {
			for(int j = 1; j < 11; j++) {
				
				if((idx+1) == 1 || (idx+1) == 3 || (idx+1) == 8) { // 광인 경우
					bool = true;
				}else {
					bool = false;
				}
				cards[idx] = new SutdaCard(j, bool);
				idx++;
			}
		}
	}
	
	
	/*
	 * [7-2] 문제 7-1의 SutdaDeck 클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트 하시오
	 *
	 * 1. 메서드명 : shuffle
	 * 		기능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다. (Math.random() 사용)
	 * 		반환타입 : 없음
	 * 		매개변수 : 없음
	 * 
	 */
	void shuffle(){
		SutdaCard tmp;
		for(int i = 0; i < cards.length; i++) {
			int idx = (int) (Math.random() * 20);
			
			tmp = cards[i];
			cards[i] = cards[idx];
			cards[idx] = tmp;
			
		}
		
	}
	
	
	/*
	 *  2. 메서드명 : pick 
	 *  	기능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
	 *  	반환타입 : SutdaCard
	 *  	매개변수 : int index - 위치
	 */
	
	// 매개변수 있을 때는 유효성 검사 해주기
	SutdaCard pick(int index) {
		
		return cards[index];
	}
	
	
	/*
	 * 3. 메서드명 : pick 
	 *		기능 : 배열 cards에서 임의의 위치를 SutdaCard를 반환한다.(Math.random() 사용)
	 *		반환타입 : SutdaCard
	 *		매개변수 : 없음
	 */
	
	SutdaCard pick() {
		int idx = (int)(Math.random()*20);
		
		return cards[idx];
	}
	
	
	
	
	
}
class SutdaCard{
	int num;
	boolean isKwang;
	
	SutdaCard(){
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
		
	}
// info() 대신 object클래스의 toString()을 오버라이딩 했다. 
	public String toString() {
		return num + (isKwang ? "k" : "");
	}
}

class Stu01{

	public static void main(String[] args) {
		/*
		 * [7-1] 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck 클래스)를 정의한 것이다.
		 * 섯다카드 20장을 담는 SutdaCard 배열을 초기화하시오. 단, 섯다 카드는 1부터 10까지의 숫자가 적힌
		 * 카드가 한 쌍씩 있고, 숫자가 1,3,8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다.
		 * 즉, SutdaCard의 인스턴스변수 isKwang의 값이 true여야 한다.
		 */
		SutdaDeck deck = new SutdaDeck();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + "," );
		}
		System.out.println();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		System.out.println();
		System.out.println(deck.pick(0));
			
			
	}

}
