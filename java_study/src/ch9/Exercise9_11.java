package ch9;

import java.util.Scanner;

public class Exercise9_11 {
    /*
        [9-11] 커맨드라인으로 2~9사이의 두 개의 숫자를 받아서 두 숫자사이의 구구단을 출력 
        하는 프로그램을 작성하시오.
        예를 들어 3과 5를 입력하면 3단부터 5단까지 출력한다.
     */
    static void gugudan(String input){

        // 두개의 숫자를 분리하기 위해 substring 사용
        String s = input.substring(0,1); // 0번째 인덱스 잘라서 start에 넣기
        String e = input.substring(1);  // 1번째 인덱스 잘라서 end 에 넣기
        int start = Integer.parseInt(s); // 숫자형으로 변환
        int end = Integer.parseInt(e);   // 숫자형으로 변환

        // 만약 해당 문자열이 0보다 작거나 같고, 9보다 크다면 내보내기
        if(start <= 0 || start > 9 || end <= 0 || end > 9){ 
            System.out.println("2~9 사이의 정수를 입력하세요.");
            return; // 내보내기
        }

        // 구구단 출력
        for(int i = start ; i <= end ; i++){    // start부터 시작을 해서 end까지 
            for(int j = 1 ; j < 10; j++){
                System.out.println(i + "*" + j + "=" + i * j);
            }
            System.out.println();   // 개행
        }
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("시작과 끝단, 두 개의 정수를 입력하세요.(2~9 사이의 정수, 공백x)");
        String input = sc.nextLine();   // 사용자에게 입력 받기
        
        gugudan(input);
        
    
        
    }
}
