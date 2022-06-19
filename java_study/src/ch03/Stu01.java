package ch03;

import java.util.Arrays;
import java.util.Random;

public class Stu01 {
	/*
	 *  [6-18] 다음의 코드를 컴파일하면 에러가 발생한다. 컴파일 에러가 발생하는 라인과 그 이유를 설명해라
	 *  
	 *  라인 A 
	 */
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
//	static int cv = iv;		// 라인A : static 변수가 인스턴스 변수값을 가져올 수 없다. 이유 : 인스턴스변수는 객체를 생성해야 하기 때문에
	
	static void staticMethod1() {
		System.out.println(cv);
//		System.out.println(iv);	// 라인 B : static 메소드가 인스턴스 변수를 가져올 수 없다.
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println();
	}
	
	static void staticMethod2() {
		staticMethod1();
//		instanceMethod1();		// 라인 D: static 메소드에서 instance메소드 호출 불가
	}
	
	void instanceMethod2() {
		staticMethod1();		
		instanceMethod1();
	}
	
	// 알게 된 사실 : 인스턴스 메소드에서는 static메소드나 멤버변수 사용 가능, but static메소드에서 인스턴스 메소드, 변수 사용 불가
	
	/*
	 * [6-19] 다음 코드의 실행 결과를 예측하여 적으시오.
	 * 
	 * ABC123
	 * After change : ABC123456 (틀림)
	 * 
	 * 정답 : ABC1234
	 * 
	 */

	/*
	 * [6-20] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
	 * [주의] Math.random()을 사용하는 경우 실행결과 다를 수 있음
	 * 
	 * 메서드명 : shuffle
	 * 기능 : 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다.
	 * 		처리한 배열을 반환한다.
	 * 반환타입 : int[]
	 * 매개변수 : int[]arr - 정수값이 담긴 배열
	 */
	
	/*
	 *(1) shuffle메서드 작성
	 */
	static int[] shuffle(int[] arr) {	// static으로 한 이유 : main에서 객체생성을 하지 않았기 때문에 
		// 유효성 검사도 해줘야 한다.
		if(arr==null || arr.length==0) {
			return arr;
		}
		
		
		Random rand = new Random();		// 랜덤으로 인덱스 결정
		int tmp = 0;					// 임시공간
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			index = rand.nextInt(arr.length)-1;		// 랜덤값 인덱스로
			tmp = arr[i];	// 임시저장
			arr[i] = arr[index];
			arr[index] = tmp;
		}
		return arr; 
	}
	
	
	
	
	public static void main(String[] args) {
		
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
		
		
		
		
		/*
		 * [6-13] 다음 중 아래의 add메서드를 올바르게 오버로딩 한 것은 (모두 고르시오.)
		 * 지문 : long add (int a, int b) {return a+b}
		 * 
		 * 오버로딩 : 리턴타입은 상관없고, 매개변수 타입, 개수, 순서 달라야 하고, 메소드명 같아야 한다. 
		 *a. long add(int x, int y){return x+y} (X)
		 *b. long add(long a, long b) {return a+b}	(O)
		 *c. int add(byte a, byte b){return a+b}	(O)
		 *d. int add(long a, int b){return (int)(a+b);}	(O)
		 *	
		 *	정답 : b,c,d 
		 */
		
		/*
		 * [6-14] 다음 중 초기화에 대한 설명으로 옳지 않은 것은? (모두 고르시오)
		 * a. 멤버변수는 자동 초기화되므로 초기화하지 않고도 값을 참조할 수 있다. (O)
		 * b. 지역변수는 사용하기 전에 반드시 초기화해야 한다.	(O)
		 * c. 초기화 블럭보다 생성자가 먼저 수행된다.		(O)
		 * d.명시적 초기화를 제일 우선적으로 고려해야 한다.	(X)
		 * e.클래스변수보다 인스턴스 변수가 먼저 초기화된다.	(X)
		 * 
		 * 클래스변수는 클래스가 처음 메모리에 로딩될 때, 자동 초기화되므로 인스턴스 변수보다 
		 * 먼저 초기화 된다. 그리고 생성자는 초기화 블럭이 수행된 다음에 수행
		 * 정답 : d,e (틀림)
		 * 정답 : c,e
		 */
		
		
		/*
		 * [6-15] 다음 중 인스턴스변수의 초기화 순서가 올바른 것은?
		 * 
		 * 정답 : 기본값 - 명시적초기화 - 초기화 블럭 - 생성자
		 */
	
		
		/*
		 * [6-16] 다음 중 지역변수에 대한 설명으로 옳지 않은 것은(모두 골라라)
		 * a. 자동 초기화되므로 별도의 초기화가 필요 없다.	(X)
		 * b. 지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다.	(O)
		 * c. 매서드의 매개변수로 선언된 변수도 지역변수이다.		(O)
		 * d. 클래스변수가 인스턴스 변수보다 메모리 부담이 적다. 	(O) 메서드가 종료되면 소멸되므로 메모리 부담이 적다.
		 * e. 힙 영역에 생성되며 가비지 컬렉터(메모리를 자동으로 정리해주는 것)에 의해 소멸된다.	(O) 모름
		 * 
		 * a (틀림)
		 * 정답 : a,e
		 * 
		 * 
		 */
		
		
		/*
		 * [6-17] 호출스택이 다음과 같은 상황일 때 옳지 않은 설명은?(모두 골라라)
		 * a. (O)
		 * b. (O)
		 * c. (O)
		 * d. (X)
		 * e. (O)
		 * f. (X) 
		 * 정답 : d,f (틀림)
		 * 
		 * 정답 : b
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
