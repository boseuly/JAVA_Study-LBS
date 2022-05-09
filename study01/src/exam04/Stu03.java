package exam04;

public class Stu03 {
	/*
	 * [7-7] 다음 코드를 실행했을 때 호출되는 생성자의 순서와 실행결과를 적으시오. (틀림)
	 * 
	 * child(){this(1000)}	-> Parent(){this(200)} -> getX(){return x;}
	 * 
	 * 답안 : child() -> child(int x) -> Parent() -> Parent(int x) -> Object()
	 * x = 200
	 * 
	 * 
	 */
	
class Parent{
	int x = 100; 
	
	Parent(){
		this(200);
		
	}
	Parent(int x){
		this.x = x;
	}
	
	int getX() {
		return x;
	}
}
	
	/*
	 * [7-8] 다음 중 접근제어자를 접근범위가 넓은 것에서 좁은 것의 순으로 바르게 나열한 것은?
	 * 내가 쓴 답안 : public - protected - (default) - private
	 * 				전체	  -  자손클래스  -  같은패키지  -   같은클래스
	 */
	
	/*
	 * [7-9] 다음 중 제어자 final 을 붙일 수 있는 대상과 붙였을 때 그 의미를 적은 것이다. 옳지 않은 것을 모두 골라라.
	 * a. 지역변수 - 값을 변경할 수 없다.(X)
	 * b. 클래스 - 상속을 통해 클래스에 새로운 멤버를 추가할 수 없다. (O)
	 * c. 메서드 - 오버로딩을 할 수 없다. (O) 
	 * d. 멤버변수 - 값을 변경할 수 없다. (O)
	 * 
	 * 답안 : a
	 */
	
	
	
	/*
	 * [7-12] 다음 중 접근 제어자에 대한 설명으로 옳지 않은 것은? (모두)
	 * c. 지역변수에도 접근 제어자 사용 가능
	 * e. prodected 다른 패키지의 자손 클래스에서 접근 가능 
	 * 
	 * [7-13] 패드에 정리
	 */ 
	
	
	
	public static void main(String[] args) {
		
	
	
	}
}
