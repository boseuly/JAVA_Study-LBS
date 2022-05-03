package exam04;

// 수정본
class Product{
	int price;
	int bonusPoint;
	
	Product(){}
	
	Product(int price){
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product{
	Tv(){
		super();
		
	}
	
	public String toString() {
		return "TV";
	}
	
}




public class Stu02 {

	public static void main(String[] args) {
		
		/*
		 * [7-3] 오버라이딩의 정의와 필요성에 대해서 설명하시오.
		 * 정의 : 오버라이딩은 조상클래스를 자식클래스가 필요에 맞게 재정의하는 것이다. 메소드에 기능을 추가, 삭제, 수정 하면서 
		 * 		자신에게 적합한 도구로 만들 수 있다.
		 * 필요성 : 조상클래스의 메소드를 재사용함으로써 코드의 불필요한 반복을 줄일 수 있다. 
		 * 
		 * [7-4] d		 
		 */
		
		/*
		 * [7-5] 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 위해서는
		 *  코드를 어떻게 바꿔야 하는가?
		 *  
		 * 이유 : 자식클래스인 Tv의 생성자 안에 부모 클래스인 Product의 생성자를 넣어줘야 한다.
		 *  
		 *  
		 *  [7-6] 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야 하는 이유는 무엇인가?
		 *  이유 : 자손 클래스에서 조상 클래스의 변수와 메소드를 사용하기 위해서는 부모 클래스의 객체를 생성해줘야 하기 때문이다.
		 *  
		 *  답안 : 조상에 정의된 인스턴스 변수들이 초기화되도록 하기 위해서
		 *  
		 */
		
	}

}
