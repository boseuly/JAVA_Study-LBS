package ch01;

import java.util.Random;
import java.util.Scanner;

public class Stu04 {

	public static void main(String[] args) {

		/*
		 * [5-7] 문제 [5-6]에 동전의 개수를 추가한 프로그램이다. 커맨드라인으로부터 거슬러 줄 금액을 
		 * 입력 받아 계산한다. 보유한 동전의 개수로 거스름돈을 지불할 수 없으면 '거스름 돈이 부족합니다.'
		 * 라고 출력하고 종료한다. 지불할 돈이 충분히 있으면, 거스름돈을 지불한 만큼 가진 돈에서 빼고 
		 * 남은 동전의 개수를 화면에 출력한다. (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 */
		
//		if(args.length != 1) {
//			System.out.println("USAGE: java Exerxise5_7 3120");
//			System.exit(0);
//		}
		// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
//		int money = Integer.parseInt(args[0]);
		int money = 3170;
		
		System.out.println("money = " + money);
		
		int[] coinUnit = {500,100,50,10};	// 동전의 단위
		int[] coin = {5,5,5,5};				// 단위별 동전의 개수
			
		
			/*
			 * (1) 아래의 로직에 맞게 코드를 작성하시오.
			 * 1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
			 * 2. 배열 coin에서 coinNum만큼의 동전을 뺀다. (만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
			 * 3. 금액에서 동전의 개수(coinNum)와 동전 단위를 곱한 값을 뺀다. 
			 */
		
		for(int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;
			
			// 금액을 동전 단위로 나누기
			coinNum = money / coinUnit[i];		// 각 동전마다 몇 개가 필요한지 
			
			// coin에서 coinNum만큼 빼기
			if(coin[i] < coinNum) {			// 내가 가진 동전 개수가 내야하는 동전개수보다 적을 때 
				coinNum = coin[i];			// 내가 낼 수 있는 만큼만 내기
				coin[i] = 0;
			}else {								// 내가 가진 동전 개수가 내야하는 동전 개수보다 크거나 같을 때 
				coin[i] = coin[i] - coinNum;	// 내가 가진 동전의 개수 - 내야 하는 동전의 개수 
				// coinNum은 그대로 둔다 -> coinNum은 위에서는 내가 내야할 동전의 개수이지만 여기서는 내가 낸 돈이라고 생각하면 됨
			}
			
			// 금액에서 동전의 개수(coinNum)와 동전 단위를 곱한 값을 뺀다.
			money = money - (coinNum * coinUnit[i]);		// 내가 낸 돈을 뺀 나머지 금액을 가지고 다음 동전의 개수를 계산해야 한다.
			System.out.println(coinUnit[i] +"원 : " + coinNum);
		}
		
		if(money > 0) {		// 위에 로직을 다 실행했는데도 내야 하는 돈이 남아있다면 
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0);	// 프로그램을 종료한다.
		}
		System.out.println("=남은 동전의 개수 = ");
		for(int i = 0; i < coinUnit.length;i++) {
			System.out.println(coinUnit[i] +"원: "+ coin[i]);
		}
		
		System.out.println("-----ex01-----");
		Stu04 s = new Stu04();
//		s.ex02();
		s.ex03();
//		s.ex05();
//		s.ex06();
//		s.ex07();
	}
	
	public void ex01() {
		// main메소드에 적음
	}
	
	public void ex02() {
		/*
		 * [5-8] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어서 그래프를 그리는 프로그램이다.
		 * (1)에 알맞은 코드를 넣어서 완성하시오.
		 */
		
		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] counter = new int[4]; 	
		
		for(int i = 0; i < answer.length; i++) {	// 숫자가 몇 개 나왔는지 확인하는 for문
			//(1)
			if(answer[i] == 1) {		// answer[i]의 값이 각각 1,2,3,4 라면 그에 맞게 
				counter[0]++;			// counter[0]을 숫자 1을 count하는 용도로 사용
			}else if(answer[i] == 2) {	
				counter[1]++;
			}else if(answer[i] == 3) {
				counter[2]++;
			}else if(answer[i] == 4) {
				counter[3]++;
			}
			// 답안 : counter[answer[i]-1]++; (이게 훨씬 수월하고 활용적임)
			
		}
		
		for(int  i = 0; i < counter.length;i++) {		// 출력해주기 위한 for문
			//(2)
			
			String star = "*".repeat(counter[i]);
			System.out.println(counter[i] + " " + star);
			
			System.out.println();
			
			/* 답안
			System.out.print(counter[i]);
			for(int j = 0; j < counter[i];j++){
				System.out.print("*");	// counter[i]의 값 만큼 '*'를 찍는다.
		
			*/
		}
	}
	
	public void ex03() {
		/*
		 * [5-9] 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오.
		 */
		char[][] star = {
				{'*', '*',' ',' ',' '},		// * : 2 , ' ' : 2
				{'*', '*',' ',' ',' '},		// * : 2 , ' ' : 2
				{'*', '*','*','*','*'},		// * : 4 , ' ' : 0
				{'*', '*','*','*','*'}		// * : 4 , ' ' : 0
		};
		
		char[][] result = new char[star[0].length][star.length];
		
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();		// 개행
		}
		System.out.println();			// 개행
		
		for(int i = 0; i < star.length;i++) {			// star.length : 4 ([0]~[3])
			for(int j = 0; j < star[i].length;j++) {	// star[i].length : 5([0]~[4])	
				// (1) 알맞은 코드를 넣어서 완성하시오.
				result[j][(star.length)-i-1] = star[i][j];
				
				/*답안 -> 답안이랑 다를 거 없음
				 int x = j;
				 int y = star.length-1-i;
				 result[x][y] = star[i][j];
				 */
			}
		}
		for(int i = 0 ; i < result.length; i++)	{
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public void ex04() {
		/*
		 * [5-10] 다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.		// 틀림(못 풂..)
		 * (1)에 알맞은 코드를 넣어서 완성하시오.
		 */
		// 'a'~'z'
		char[] abcCode = {'`', '~', '!', '@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{','}',';', ':',',','.','/'};	
		
		// '0'~'9'
		char[] numCode = {'q', 'w', 'e', 'r', 't' , 'y', 'u', 'i','o','p'};
		
		String src = "abc123";
		String result = "";
		
		// 문자열 src의 문자를 charAr()으로 하나씩 읽어서 변환 후 result에 저장
		for(int i = 0; i < src.length();i++) { 
			char ch = src.charAt(i);		// 문자열 -> charAt()으로 char형으로 변환
			// (1) 알맞은 코드를 넣어 완성하시오.
			/*답안
			 if('a' <= ch && ch <='z'){
			 	result += abcCode[ch-'a'];	// ch의 값이 'a' -> 'a'(97)-'a'(97) = 0 따라서 abcCode[0]이 된다.		
			 }else if('0' <= ch && ch <= '9'){
			 	resuslt += numCode[ch-'0'];	
			 }
			 */
		}
		
		
		
		/* 규연언니 풀이(for문 밖으로 뺌)
		 char[] temp1 = new char[abcCode.length];
        int idx1 = 0;
        for(int i = 97; i < 123; i++) {
            temp1[idx1] = (char)i;
            idx1++;
        }

        char[] temp2 = new char[numCode.length];
        int idx2 = 0;
        for(int i = 48; i < 58; i++) {
            temp2[idx2] = (char)i;
            idx2++;
        }

        for(int i = 0; i < src.length();i++) {
            char ch = src.charAt(i);
            for(int j = 0; j < abcCode.length; j++) {
                if(ch == temp1[j]) {
                    result += abcCode[j];
                    break;
                } 
            }
            for(int j = 0; j < numCode.length; j++) {
                if(ch == temp2[j]) {
                    result += numCode[j];
                    break;
                } 
            }  
		 
		 */
		System.out.println("src : " + src);
		System.out.println("result : "+ result);
	}
	
	public void ex05() {
		/*
		 * [5-11] 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서 배열의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고
		 * 출력하는 프로그램이다. (1)에 알맞은 코드를 넣어서 완성하시오.
		 */
		
		int[][] score = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
		};
		int[][] result = new int[score.length + 1][score[0].length + 1];	// result.length : 6, result[i].length : 4
		
		// result[][]배열에 값넣고, result마지막 열까지 채워주기
		for(int i = 0; i < score.length; i++) {			// score.length : 5 (행)
			for(int j = 0; j < score[i].length;j++) {	// score[i].length : 3(열)
				//(1)
				result[i][j] = score[i][j];				// 우선result[][]배열에 값을 넣어준다.
				result[i][result[i].length-1] += result[i][j];	// 마지막 열에는 인덱스([result[i].length -1])에 result[i][j]의 값을 넣어준다.
				// result[i][2]
			}
		}
		// result의 마지막 행(가로) 부분 구해주기
		for(int i = 0; i < score[i].length; i++) {			// score[i].length : 3
			for(int j = 0; j < score.length; j++) {			// score.length : 5
				result[result.length-1][i] += score[j][i];	// result의 마지막 열(세로)의 행에 차례대로 result[5][0] =  score[0][0]~[4][0]까지 더하고
			}												// result[5][1] = [0][1]~[4][1]까지 더하기  ... 이런 식으로 계속 더해주기 
			result[result.length-1][result[i].length-1] += result[result.length-1][i];	// result의 마지막 행, 마지막 열은 result[5][0]+[5][1]+[5][2]의 값이다.
			
		}
		
		/* 유라언니, 규연언니 풀이
		int[][] result = new int[score.length + 1][score[0].length + 1];

        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < score[i].length; j++) {

                result[i][j] = score[i][j];
                result[i][3] += score[i][j];
                result[5][j] += score[i][j];
                result[5][3] += score[i][j];
		 */
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}
		
	}
	public void ex06() {
		/*
		 * [5-12] 예제 5-23을 변경하여, 아래와 같은 결과가 나오도록 하시오.
		 * Q1. chair의 뜻은 ? ddd
		 * 틀렸습니다. 정답은 의자입니다.
		 * 
		 * Q2. computer의 뜻은 ? 컴퓨터
		 * 정답입니다.
		 * 
		 * Q3. integer의 뜻은 ? 정수
		 * 정답입니다.
		 * 
		 * 전체 3문제 중 2문제 맞추셨습니다.
		 */
		String[][] words = {
				{"chair", "의자"},
				{"computer","컴퓨터"},
				{"integer", "정수"}
		};
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		for(int i = 0; i < words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은 ? " , i+1, words[i][0]);
			
			String tmp = sc.nextLine();
			
			if(tmp.equals(words[i][1])) {
				System.out.printf("정답입니다.%n%n");
				count++;
			}else {
				System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", words[i][1]);
			}
		}
		
		System.out.printf("%d 문제 중 %d 문제 맞추셨습니다.", words.length, count);
	}
	
	public void ex07() {
		/*
		 * [5-13] 단어의 글자 위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다. 실행결과와
		 * 같이 동적하도록 예제의 빈 곳을 채우시오.
		 */
		
		String[] words = {"television","computer","mouse","phone"};
		Random rand = new Random();
		char tmp;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray();			// String을 char[]로 변환
			/*
			 * (1) 알맞은 코드 작성
			 * char배열 question에 담긴 문자의 위치를 임의로 바꾼다.
			 */
			for(int j = 0; j < words[i].length(); j++) {		// words[i]번째 값 "television"... 을 char[]에 담은 다음 랜덤을 통해 섞어줘야 한다.
				int random = rand.nextInt(question.length);		// 랜던 인덱스 값을 저장
				
				tmp = question[j];		 				// tmp에 j번째 값을 임시저장
				question[j] = question[random];			// i번째 값에 랜덤번째 값을 대입한다.	question[0](television)의 첫번째 인덱스값은 't'
				question[random] = tmp;					// 랜덤인덱스 값에는 tmp 대입
			}
			System.out.printf("Q%d. %s의 정답을 입력하세요. > ", i+1, new String(question));
			String answer = sc.nextLine();
			
			// trim()으로 answer의 좌우 공백을 제거한 후, equals로 word[i]와 비교
			if(words[i].equals(answer.trim())) {
				System.out.printf("맞았습니다. %n%n");
			}else {
				System.out.printf("틀렸습니다. %n%n");
			}
			
		}
	}
	
	
	
	
	
	
}
