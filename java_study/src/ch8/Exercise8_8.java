package ch8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_8 {

	public static void main(String[] args) {	// (틀림) continue 안 씀
		/*
		 * 다음은 1~100 사이의 숫자를 맞추는 게임을 실행하던 도중에 숫자가 아닌 영문자를
		 * 넣어서 발생한 예외이다. 예외처리를 해서 숫자가 아닌 값을 입력했을 때는 다시 입력을
		 * 받도록 보완하라.
		 * 
		 * 1 100 :50 과 사이의 값을 입력하세요
		 * 더 작은 수를 입력하세요.
		 * 1 100 :asdf 과 사이의 값을 입력하세요
		 * Exception in thread "main" java.util.InputMismatchException
		 * at java.util.Scanner.throwFor(Scanner.java:819)
		 * at java.util.Scanner.next(Scanner.java:1431)
		 * at java.util.Scanner.nextInt(Scanner.java:2040)
		 * at java.util.Scanner.nextInt(Scanner.java:2000)
		 * at Exercise8_8.main(Exercise8_8.java:16)
		 * 
		 */
		// 1~100 사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int)(Math.random() * 100) + 1;
		int input = 0; // 사용자입력을 저장할 공간
		int count = 0; // 시도횟수를 세기 위한 변수
		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 :");  
			input = new Scanner(System.in).nextInt();
			try {
				input = new Scanner(System.in).nextInt();
				
			}catch(InputMismatchException i){
				System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
				 continue; 
			}
			
			if(answer > input) {
					System.out.println("더 큰 수를 입력하세요."); 
				} else if(answer < input) {
					System.out.println("더 작은 수를 입력하세요."); 
				} else {
					System.out.println("맞췄습니다."); 
					System.out.println("시도횟수는 "+count+" 번입니다."); 
					break; // do-while문을 벗어난다
				}
		} while(true); // 무한반복문
	}

}
