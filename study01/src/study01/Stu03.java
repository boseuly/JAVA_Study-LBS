package study01;

import java.util.Scanner;

public class Stu03 {

	public static void main(String[] args) {
		Stu03 s = new Stu03();
//		s.question01();
//		s.question02();
//		s.question03();
//		s.question04();
//		s.question05();
//		s.question08();
//		s.question09();
//		s.question10();
//		s.question11();
	}
	
	public void question01() {
		/*
		 * [4-11] 피보나치 수열은 앞의 두 수를 더해서 다음 수를 만들어 나가는 수열이다. 1과 1부터
		 * 시작하는 피보나치수열의 10번째 수는 무엇인지 계산하는 프로그램을 완성하시오.
		 * 
		 * 피보나치 수열의 시작의 첫 두 숫자를 1,1로 한다.
		 */
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;		// 세번째 값
		System.out.print(num1 + ", " + num2);
		
		
		for(int i = 0; i < 8; i++) {
			 num3 = num1 + num2;
			 num1 = num2;			// num1의 값은 num2의 값이 되고
			 num2 = num3;			// num2의 값은 다시 num3의 값이 된다.
			 
			 System.out.print(", " + num3);
		}
	}
	
	public void question02() {
		/*
		 * [4-12] 구구단의 일부분을 다음과 같이 출력하시오.   (줄바꿈이 너무 어려움..)  **틀림
		 */
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 3; j++) {
				int x = (j+1) + (i-1)/3*3;
				int y = i%3 == 0? 3: i%3;
				
				if(x>9)
					break;
				
				System.out.print(x+"*"+y+"="+x*y + "\t");
			}
			System.out.println();
			if(i%3 == 0) System.out.println();	// 개행
		}
		
		
//		// 규연언니
//		 for(int i = 2; i <= 9; i++) {
//	            for(int j = 1; j <= 3; j++) {
//	                System.out.printf("%d * %d = %d", i, j, (i * j));
//	                System.out.printf("\n");
//	            }
//	            System.out.printf("\n");
//	        }
		
	}
	
	public void question03() {
		/*
		 * [4-13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다. (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 */
		
		String value = "1234";
		char ch = ' ';
		boolean isNumber = true;
		
		
		// 반복문과 cahrAt(i)를 이용해서 문자열의 문자를 하나씩 읽어서 검사한다.
		for(int i = 0; i < value.length(); i++) {
			/*
			 * (1)
			 */
			ch = value.charAt(i);			// char형 ch 변수에 추출한 문자를 넣는다 -> 하나라도
			if(!(ch >= '0' && ch <= '9')) {	// 만약 추출된 문자가 48~57 범위를 벗어났다면	// ch 타입에 맞춰서 비교해주기
				isNumber = false;
				break;
			}
		}
		if(isNumber) {				// 그렇게 추출된 문자가 숫자인지 확인하기 위해서는 아스키코드를 사용해야 한다.
			System.out.println(value + "는 숫자입니다.");
		}else {
			System.out.println(value+"는 숫자가 아닙니다.");
		}
		
	}
	
	public void question04() {
		/*
		 * [4-14] 다음은 숫자 맞추기 게임을 작성한 것이다. 1과 100사이의 값을 반복적으로 입력해서 컴퓨터가 생각한 값을 맞추면 게임이 끝난다.
		 * 사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다. 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고
		 * 몇 번만에 숫자를 맞췄는지 알려준다. (1), (2)에 답을 작성하시오.
		 * 1~100 사이의 임의의 값을 얻어서 answer에 저장한다. 
		 */
		int answer = (int) (Math.random()*100 + 1);	// (1)번
		int input = 0;	// 사용자 입력을 저장할 공간
		int count = 0;	// 시도횟수를 세기 위한 변수
		
		Scanner sc = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 : ");
			input = sc.nextInt();		// 입력 받은 값을 변수 input에 저장한다.
		/*
		 * (2)번
		 */
			if(input == answer) {		// 사용자가 입력한 값과 랜덤값을 비교해서 
				System.out.println(count + "번만에 맞췄습니다.");		// 만약 맞았다면 몇 번만에 맞았다고 알려주기
				break;
			}else if(input > answer) {
				System.out.println("더 작은 수를 입력하세요.");
			}else if(input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			}
			
		
		
		}while(true);					// 무한반복
	}
	
	public void question05() {
		/*
		 * [4-15] 다음은 회문수를 구하는 프로그램이다. 회문수란, 숫자를 거꾸로 읽어도 앞으로 읽는 것과 같은 수를 말한다. 		** 틀림
		 * 예를 들면 '12321'이나 '13531'같은 수를 말한다. (1)에 알맞은 수를 넣어서 프로그램을 완성하시오.
		 */
		int number = 12321;	
		int tmp = number;	
		
		int result = 0;		// 변수 number를 거꾸로 변환해서 담을 변수
		
		while(tmp != 0) {	// tmp가 0이 아니라면 반복문을 실행하라
			//(1)
			result = (result * 10) + (tmp % 10);		// tmp 나머지를 그냥 result에 넣어주면 문자열처럼 합쳐지는 게 아니라 숫자가 합해지기 때문에
														// 자리수를 맞춰주기 위해서는 result값이 *10을 해줘야 한다.
			tmp /= 10;
		}
		if(number == result) {
			System.out.println(number + "는 회문수 입니다.");
		}else {
			System.out.println(number + "는 회문수가 아닙니다.");
		}
		
		
		// 규연언니 풀이
		
		String number1 = "12321";
        boolean result1 = false;

        for(int i = 0; i < number1.length(); i++) {
            if(number1.charAt(i) == number1.charAt(number1.length() - (i+1))) {
                result1 = true;
            } else {
                result1 = false;
                break;
            }

            if(i == (number1.length() - (i+1))){			// 중간 글자
                break;
            }
        }
        if(result1) {
            System.out.println(number1 + "는 회문수입니다.");
        } else {
            System.out.println(number1 + "는 회문수가 아닙니다.");
        }
	}
	
	public void question06() {
		/*
		 * [5-1] 다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오.
		 * 
		 * a. int[] arr[];							// 2차원 배열 선언
		 * b. int[] arr = {1,2,3};					// 1차원 배열 초기화
		 * c. int[] arr = new int[5];				// 1차원 배열 선언
		 * d. int[] arr = new int[5]{1,2,3,4,5};	// X 잘못된 이유 : 값을 초기화할 때는 int[] arr = new int[]{1,2,3,4,5} 가 맞음
		 * e. int arr[5];							// X 공간을 생성할 때는 new 생성자를 사용해야 한다. int arr[] = new int[5] 
		 * f. int[] arr[] = new int[3][];			// 가변배열, 뒤에 공간은 나중에 생성할 수 있다.
		 * 
		 * 정답 : d, e
		 */
	}
	
	public void question07() {
		/*
		 * [5-2] 다음과 같은 배열이 있을 때, arr[3].length의 값은 얼마인가? (순간적으로 헷갈려서 4라고 함..)
		 */
		
		int[][] arr = {
				{5,5,5,5,5},
				{10,10,10},
				{20,20,20,20},
				{30,30}
		};
		// 정답 : 2
	}
	
	public void question08() {
		/*
		 * [5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
		 */
		
		int[] arr = {10,20,30,40,50};
		int sum = 0;
		
		// (1)
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];						// sum = sum + arr[i]
		}
		
		System.out.println("sum = " + sum);
	}
	
	public void question09() {
		/*
		 * [5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.
		 */
		
		int[][] arr = {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};
		int total = 0;
		float average = 0;
		int num = 0;
		
		
		// (1)
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				num++;
			}
		}
		average = (total / (float)num);		// 더한 수만큼 나눠줘야 하니까 num을 따로 만들어서 나눠줌. 
											// 이때 정수로 값을 나누면 소수점은 버려지기 때문에 float형으로 변환 후 나눠준다. 
		System.out.println("total = " + total);
		System.out.println("average = " + average);
		
		// 규연언니 풀이
		
		/*
		 int[][] arr = {
            {5, 5, 5, 5, 5},
            {10, 10, 10, 10, 10},
            {20, 20, 20, 20, 20},
            {30, 30, 30, 30, 30},
        };

        int total = 0;
        float average = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
            }
        }

        int l = 0; 
        for(int i = 0; i <arr.length; i++) {
            l += arr[i].length;
        }
        average = (float)total / l;


        System.out.println("total = " + total);
        System.out.println("average = " + average);
		 */
		
		// 유라언니 풀이
		/*
		 int total = 0;
        float average = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
            }
            count += arr[i].length;
        }
        average = (float)total / (float)count;

        System.out.println("total = " + total);
        System.out.println("average = " + average);
		 */
	}
	
	public void question10() {
		/*
		 * [5-5] 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다. 
		 * (1), (2)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 * 
		 * Math.random()을 사용했기 때문에 실행결과와 다를 수 있다.
		 */
		
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
		for(int i = 0; i < ballArr.length;i++) {
			int j = (int)(Math.random() * ballArr.length); // 1~9 사이의 랜덤값	// 랜덤값을 i번째와 값이 겹치는지 확인하고 넣으면 됨
			int tmp = 0;				// j번째 값과 i번째 값을 바꾼다. -> i번째값은 tmp에 넣고 j에 넣어준다.
			
			// (1)
				tmp = ballArr[i];			// tmp에 ballArr[i]번째 값을 미리 넣어둔다.
				ballArr[i] = ballArr[j];	// ballArr[i]번째 인덱스에 [j]번째 값을 대입한다.
				ballArr[j] = tmp;			// ballArr[j]에는 tmp를 대입한다.
		}
		
		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		// (2)
		// 나는 얕은 복사
		for(int i = 0; i < 3; i++) {
			ball3[i] = ballArr[i];
		}
		// 정답
		System.arraycopy(ballArr, 0, ball3, 0, 3);
		
		
		for(int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i]);
		}
		
		// 규연언니 풀이
		/*
		 Random rand = new Random();
        int ball = rand.nextInt(900)+100;

        System.out.println(ball);
		 */
	}
	
	public void question11() {
		/*
		 * [5-6] 다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다. 
		 * 변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라.
		 * 단, 가능한 적은 수의 동전으로 거슬러 주어야 한다.(1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 * 
		 * hint 나눗셈 연산자와 나머지 연산자를 사용하여라
		 * 
		 * 큰 금액의 동전을 우선적으로 거슬러 줘야 한다.
		 */
		
		int[] coinUnit = {500,100,50,10};
		
		int money = 2680;
		int count = 0;
		
		System.out.println("money = " + money);
		
		for(int i = 0; i < coinUnit.length; i++) {
			count = money / coinUnit[i];
			System.out.println(coinUnit[i] +"원 : " + count);
			money %= coinUnit[i];			// money를 coinUnit[i]나눈 나머지를 다시 저장한다. 
			
		}
		
		//유라언니 풀이
		/*
		int[] coinUnit = {500, 100, 50, 10};

        int money = 2680;
        System.out.println("money = " + money);

        for(int i = 0; i < coinUnit.length; i++) {
            if(money % coinUnit[i] < coinUnit[i]) {
                int num = money / coinUnit[i];
                money %= coinUnit[i];			// 남은 돈
                System.out.println(coinUnit[i] + "원 : " + num);
               }
             }
		 */
		
		// 규연언니 풀이
		/*
		int[] coinUnit = {500, 100, 50, 10};

        int money = 2680;
        int res = 0;
        System.out.println("money = " + money);

        for(int i = 0; i < coinUnit.length; i++) {
            res = money / coinUnit[i]; 				// 해당 동전이 얼마나 필요한지 
            System.out.printf("%d원 = %d\n", coinUnit[i], res);
            money = money % coinUnit[i]; 
        }
		 */
		
	}
	
}
