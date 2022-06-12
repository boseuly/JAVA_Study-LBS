package ch1;

public class Stu02 {

	public static void main(String[] args) {
		/*
		 * [4-1] 다음의 문장들을 조건식으로 표현하라.
		 * 
		 * 1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식 
		 * 	  내가 쓴 답안 : x > 10 && x < 20	 (O)
		 * 
		 * 2. char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
		 * 	  내가 쓴 답안 : ch != ' ' || ch != '\t'	(O)
		 * 
		 * 3. char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식
		 *    내가 쓴 답안 : ch == 'x' || ch == 'X'		(O)
		 *    
		 * 4. char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식	 ** '0' : 48
		 *    내가 쓴 답안 : ch >= '0' && ch <= '9'		(O) 
		 * 
		 * 5. char형 변수 ch가 영문자 (대문자 또는 소문자)일 때 true인 조건식
		 * 	  내가 쓴 답안 : (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')	(O)
		 * 
		 * 6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true인 조건식
		 * 	  내가 쓴 답안 : year % 400 == 0 || year % 4 == 0 && year % 100 != 0	(O)
		 * 
		 * 7. boolean형 변수 powerOn가 false일 때 true인 조건식
		 * 	  내가 쓴 답안 : powerOn == false		(O)
		 * 
		 * 8. 문자열 참조변수 str이 "yes"일 때 true인 조건식
		 * 	  내가 쓴 답안 : str.equals("yes")		(O)
		 * 
		 */
			
		/*
		 * [4-2] 1 ~ 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오. 
		 */
		int sum = 0;
		for(int i = 1; i <= 20; i++) {			// 1~20까지의 정수
			if(i % 2 != 0 && i % 3 != 0) {		// 만약 i가 2로 나눠지지 않거나, i가 3으로 나눠지지 않는다면  
				sum += i;						// -> 만약에 2,3 둘 중 하나로라도 나눠떨어진다면 성립 X -> && 연산자 사용
			}
			System.out.println(sum);
		}
		System.out.println("총합 : " + sum);		
		// 내 답안 : 73
		
		
		/*
		 * [4-3] 1 + (1+2) + (1+2+3) + (1+2+3+4) + .... + (1+2+3+...+10) 의 결과를 계산하시오.
		 */
		sum = 0;
		int total = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;			// sum = sum + i	여기까지가 1+2+3+4+ ...+10 
			total += sum;
		}
		System.out.println("정답 : " + total);
		// 내 답안 : 220
		
		/*
		 * [4-4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이 되는지 구하시오. 	**틀림
		 * 처음에는 중첩 for문인 줄 알았는데 아님,,
		 */
		
		
		// 내 틀린 답안... 101 나옴
		total = 1;
		int sum1 = 0;	// 덧셈
		int sum2 = 0;	// 뺄셈
		int count = 1;	// 몇 번째에서
		
		while(true) {	// total이 100보다 작거나 같다면 실행해라, 100보다 크면 실행X
			if(count % 2 == 0) {	// 만약 짝수번째라면
				sum1++;				// sum1
				sum2++;
				total += sum1;		// sum = sum + sum1
				count++;
			}else if(count % 2 != 0){
				sum1++;	
				sum2++;
				total -= sum2;		// sum = sum - sum2;
				count++;
			}
			if(total >= 100) {
				break;
			}
		}
		System.out.println("총합(total) : " + total);
		System.out.println("몇 번째 : " + count);
		
		
		
		
		// 유라언니 풀이
		int neg = 0;   	 	// 음수
        int pos = 0;    	// 양수
        int total2 = 0;     // 총 합계
        count = 0;    		// 몇 까지 더하는가?

        for(int i = 1;;i++) {
            if(total2 >= 100) {
                break;
            } else {
                if(i % 2 == 0) {
                    neg = -i;
                    total2 += neg;
                    count += 1; 
                } else {
                    pos = +i;
                    total2 += pos;
                    count += 1;
                }
            }
        }
        
        System.out.println(count);
        System.out.println(total2);
		
		// 정답↓   (이렇게 했는데도 199가 안 나오고 101가 나옴)
		
		sum = 0;		// 총합을 저장할 변수
		int s = 1;		// 값의 부호를 바꿔주는 데 사용할 변수
		int num = 0;
		
		for(int i = 1; true; i++, s =- s) {		// 매 반복마다 s의 값은 1, -1, 1, -1 ... // 증감식에 두 개를 쓸 수 있는 줄 몰랐음..
			num = s * i; 	// i와 부호(s)를 곱해서 더할 값을 구한다  ->  i를 곱하면 부호가 바뀌니까
			sum += num;
			
			if(num >= 100) {// 총합이 100보다 같거나 크면 반복문을 빠져 나간다.
				break;
			}
		}
		System.out.println(num);
		System.out.println(sum);
	
		
		
		/*
		 * [4-5] 다음의 for문을 while문으로 변경하시오.
		 */
		for(int i1 = 0; i1 <= 10; i1++) {
			for(int j = 0; j <= i1; j++) {
				System.out.print("*");
			}
			System.out.println();		// 개행
		}
		System.out.println("-----------------------");
		
		int i1 = 0;				// while문에서 변수를 외부에 선언
		int j1 = 0;
		
		while(i1 <= 10) {		// i가 10보다 작거나 같을 때까지 반복한다.
			i1++;
			while(j1 < i1) {		// i=1이면 j=1, i = 2면 j=1, j=2
				System.out.print("*");
				j1++;
//				if(j1 > 10) {		// 얘는 굳이 안 필요함
//					break;
//				}
			}
			j1 = 0;				// 얘를 초기화 해줘야 됨
			System.out.println();  // 개행
			if(i1 > 10) {	// 만약 i가 10보다크면 
				break;
			}
			
		}
		
		/*
		 * [4-6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.
		 */
		count = 0;
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= 6; j++) {	
				if(i+j == 6) {	// 만약 i+j가 6이라면
					count++;
					System.out.println(i + "+" + j + "=" + i+j );
				}
			}
		}
		System.out.println("경우의 수 : " + count + "가지");
		
		
		
		/*
		 * [4-7] Math.random()을 이용해서 1~6 사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하라. **문제집 참고
		 */
		
		int value = (int)(Math.random() * 6) + 1;			// 1부터 시작해야 하니까 +1 
		System.out.println(value);
		
		/*
		 * [4-8] 방정식 2x + 4y = 10의 모든 해를 구하시오. 단, x와 y는 정수이고 각각의 
		 * 범위는 0 <= x <= 10, 0 <= y <= 10 이다.
		 * 
		 * 결과 : x = 1, y = 2
		 * 		 x = 3, y = 1
		 * 		 x = 5, y = 0
		 */
		
		for(int x = 0; x <= 10; x++) {
			for(int y = 0; y <= 10; y++) {
				if(2*x + 4*y == 10) {
					System.out.println("x = " + x +", "+ "y = " + y);
				}
			}
		}
		
		
		/*
		 * [4-9] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 	** 틀림
		 * 만일 문자열이 "12345"라면, "1+2+3+4+5"의 결과인 15가 출력되어야 한다.
		 * Hint : String 클래스의 charAt(int i) 사용 
		 */
		
		// 어려웠던 점 : charAt으로 뽑아낸 뒤 int에 넣으면 자동형변환 때문에 아스키코드 숫자가 출력됨(따라서 합이 225), char형 변수에 넣으면 이상한 문자 출력됨
		// 내가 쓴 답 : sum += str.charAt(i);
		String str = "12345";
		sum = 0;
		for(int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';		// '0' : 48, '3' : 51 따라서 '3'-'0' = 3이 된다. 이렇게 char형 '3'을 숫자 3으로 바꾸려면 -'0'을 해주면 됨
		}
		System.out.println(sum);
		
		/*
		 * [4-10] int타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.    **틀림
		 * 만일 변수 num값이 12345라면, '1+2+3+4+5'의 결과인 15를 출력하라
		 * 주의 : 문자열로 변환하지 말고 숫자로만 처리해야 한다.
		 */
		
		num = 12345;
		sum = 0;
		
		while(num > 0) {
			sum += num %10;		// 10으로 나눈 나머지 -> 맨 뒷자리 숫자가 된다.
			num /= 10;			// num에는 10으로 나눈 몫을 저장해야 됨
		}
		System.out.println("sum = " + sum);
		
	}

}
