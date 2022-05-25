package ch8;

public class Exercise8_9 {

	public static void main(String[] args) throws Exception { //(틀림)
		/*
		 *  다음과 같은 조건의 예외클래스를 작성하고 테스트하시오.
		 *	[참고] 생성자는 실행결과를 보고 알맞게 작성해야한다.
		 */

		/*
		  - 클래스명: UnsupportedFuctionException
		  - 조상클래스명: RuntimeException 
		  - 멤버변수 : 
				이 름 : ERR_CODE
				저장값 : 에러코드 
				타 입 : int
				기본값 : 100
				제어자 : final private
		   - 메서드
				1. : getErrorCode 메서드명
					기 능 : 에러코드(ERR_CODE)를 반환한다  
					반환타입 : int
					매개변수 :없음
					제어자 : public
				2. : getMessage 메서드명
					기 능: 메세지의 내용을 반환한다. (Exception클래스의 getMessage()를 오버라이딩 )
					반환타입 : String
					매개변수 : 없음
					제어자 : public

		 */
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.", 100); 	// 에러코드가 final인데 왜 또 지정해줄까?
		
	}

}

class UnsupportedFuctionException extends RuntimeException {
	private final int ERR_CODE = 100;		//에러코드 저장
	
	
	//생성자
	public UnsupportedFuctionException (String msg, int code) {
		super(msg);
		//ERR_CODE = code;	//ERR_CODE는 상수라서 자꾸 에러 뜸
	}
	
	public UnsupportedFuctionException(String msg) {
		this(msg, 100);
		
	}
	// 에러코드(ERR_CODE) 반환
	public int getErrorCode() {
		return this.ERR_CODE;
	}
	// 메세지의 내용을 반환한다. 
	@Override
	public String getMessage() {
		return "[" + this.ERR_CODE + "]" + super.getMessage();
	}

}



















