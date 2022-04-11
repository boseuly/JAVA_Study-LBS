package study01;

public class stu01 {

	public static void main(String[] args) {
		// [3-1] 다음 연산의 결과를 적으시오.
		
		int x = 2;
		int y = 5;
		char c = 'A';		// 'A'의 문자코드 : 65
		
		System.out.println(1+x << 33);  // 0~32		// 6
		System.out.println(y >= 5 || x < 0 && x > 2); 	// ?	// true // &&연산자가 우선순위
		System.out.println(y += 10 - x++);		// 12	// 후위연산자이기 때문에 x: 3
		System.out.println(x += 2); 			// 5
		System.out.println(!('A' <= c && c <= 'Z'));	// false
		System.out.println('C' - c);	// 2
		System.out.println('5' - '0');	// 5
		// char형 숫자끼리 덧셈 뺄샘 가능
		System.out.println(c + 1); 		// 66
		System.out.println(++c); 		// 67	// B
		System.out.println(c++); 		// 67	// B
		System.out.println(c);			// 68	// C
		
		
		/* [3-2] 아래의 코드는 사과를 담는데 필요한 바구니의 수를 구하는 코드이다. 만일 사과의 수가 123개이고 
		 * 하나의 바구니에는 10개의 사과를 담을 수 있다면, 13개의 바구니가 필요할 것이다. (1)에 알맞은 코드를 넣으시오.
		 */
		
		int numOfApples = 123;		// 사과의 개수
		int sizeOfBuket = 10;		// 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int numOfBuket = (int) Math.ceil(numOfApples / sizeOfBuket); 	// 모든 사과를 담는데 필요한 바구니 수
		System.out.println("필요한 바구니의 수 : " + numOfBuket);		
		// 내가 쓴 답안 : (int) Math.ceil(numOfApples / sizeOfBuket)
		// 정답 : numOfApples/sizeOfBuket + (numOfApples%sizeOfBucket > 0 ? 1 : 0)
		
		// int numOfBucket = (numOfApples / sizeOfBucket) % sizeOfBucket == 0 ? 
		// (numOfApples / sizeOfBucket) : (numOfApples / sizeOfBucket) + 1;
		
		
		
		/*[3-3] 아래는 변수 num의 값에 따라 '양수','음수','0'을 출력하는 코드이다. 삼항 연산자를 이용해서 (1)에 알맞은 코드를 넣으시오.
		 * [Hint] 삼항 연산자를 두 번 사용하라
		 */
		int num = 10;
		System.out.println(/*(1)*/); 
		// 내가 쓴 답안 : (num = 0)? 0 : (num > 0)? "양수" : "음수";
		
		
		
		/*[3-4] 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다. 만일 변수 num의 값이 '456'이라면 '400'이 되고
		 * '111'이라면 '100'이 된다. (1)에 알맞은 코드를 넣으시오.
		 */
		num = 456;
		System.out.println(/*(1)*/); 	
		// 내가 쓴 답안 : (num/100)*100
		
		
		/*
		 * [3-5] 아래는 변수 num의 값 중에서 일의 자리를 1로 바꾸는 코드이다. 만일 변수 num의 값이 333이라면 331이 되고, 
		 * 777이라면 771이 된다. (1)에 알맞은 코드를 넣으시오.
		 */
		num = 333;
		System.out.println((num / 10 ) + "1");	/*(1)*/
		// 내가 쓴 답안 : (num / 10 ) + "1"
		
		/*
		 * [3-6] 아래는 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을 뺀
		 * 나머지를 구하는 코드이다. 예를 들어, 24의 크면서도 가장 가까운 10의 배수는 30이다. 19의 경우 20이고,
		 * 81의 경우 90이 된다. 30에서 24를 뺀 나머지는 6이기 때문에 변수 num의 값이 24라면 6을 결과로 얻어야 한다.
		 * (1)에 알맞은 코드를 넣으시오.
		 */
		
		num = 24;
		System.out.println(/*(1)*/);
		// 내가 쓴 답안 : ((num / 10) + 1) * 10 - num (이것도 맞음)
		// 만약 20인 경우에는 10의 배수는 30, num의 값보다 크면서도 가장 가까워야 하기 때문에
		// 정답 : 10 - (num % 10)
		
		/*
		 * [3-7] 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다. 변환공식이 'c = 5/9 * (F - 32)'
		 * 라고 할 때, (1)에 알맞은 코드를 넣으시오. 단, 변환 결과값은 소수점 셋째자리에서 반올림해야 한다.
		 * (Math.rount()를 사용하지 않고 처리할 것)
		 */
		
		int fahrenheit = 100;
		float celcius = 5/9 * (fahrenheit - 32);
		
		System.out.println("Fahrenheit : " + fahrenheit);
		System.out.println("Celcius : " + celcius);
		
		// 내가 쓴 답안 : 
		// 정답 : 
		
		/*
		 * [3-8] 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.
		 */
		byte a1 = 10;
		byte b1 = 20;
		byte c1 = (byte) (a1 + b1);	// 답안 : (byte)(a1 + b1)  byte랑 byte를 더하는데 형변환을 하는 줄 몰랐음
		
		char ch = 'A';
		ch =(char)(ch + 2);			// 답안 : (char)(ch + 2) 결과값이 'C'가 나와야 하기 때문에 char형으로 형변환
	
		double f = (Math.round((3/2) * 10) / 10.0);		// 답안 : ? 이거 모르겠음..		
		long l = 3000 * 3000 * 3000;					// 답안 : 3000*3000*3000L
		
		float f2 = 0.1f;	
		double d = 0.1;
		
		boolean result = d==f2;		// (float)d==f2  서로 다른 자료형이기 때문에 더 큰 자료형인 float으로 형변환
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
		
		
		/*
		 * [3-9] 다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수 b의 값이 true가 되도록 하는 코드이다.
		 * (1)에 알맞은 코드를 넣으시오.
		 */
		
		char ch1 = 'z';
//		boolean b = (/*(1)*/);
//		boolean, 대문자, 소문자, 숫자를 이용해서 범위를 
//		System.out.println(b);
		
		// 정답 : 'a' 
		
		
		
		/*
		 * [3-10] 다음은 대문자를 소문자로 변경하는 코드인데, 문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경한다.
		 * 문자코드는 소문자가 대문자보다 32만큼 더 크다. 예를 들어 'A'의 코드는 65이고, 'a'의 코드는 97이다.
		 * (1)~(2)에 알맞은 코드를 넣으시오.
		 */
//		char lowerCase = (/*(1)*/) ? (/*(2)*/) : ch2;
		
		char ch2 = 'A';		// 아스키코드 65
		
		// 내 답안 
		// lowerCase = (ch2 > 65 && ch2 <= 91) ?  Character.toLowerCase(ch2): ch2;
		
		// 정답('A' <= ch && ch <= 'z')
		char lowerCase = (ch2 > 65 && ch2 <= 91)? (char)(ch + 32) : ch2;
		
		System.out.println("ch2:"+ch2);
		System.out.println("ch2 to lowerCase :" + lowerCase);
		
		/*
			대문자인 경우에만 문자코드의 값을 32만큼 증가시키면 소문자가 됨. 
			
		*/
	}
		
}
