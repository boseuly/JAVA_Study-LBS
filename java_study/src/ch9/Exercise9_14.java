package ch9;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise9_14 {
    /*
     * [9-14] 다음은 화면으로부터 전화번호의 일부를 입력받아 일치하는 전화번호를 주어진
        문자열 배열에서 찾아서 출력하는 프로그램이다 알맞은 코드를 넣어 프로그램을 완성하시오.
        [Hint] Pattern, Matcher클래스를 사용할 것
     */
    public static void main(String[] args) {
        String[] phoneNumArr = {
            "012-3456-7890",
            "099-2456-7980",
            "088-2346-9870",
            "013-3456-7890"
        };
        ArrayList list = new ArrayList();
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.print(">>");
            String input = s.nextLine().trim(); // 공백 제거
            if(input.equals("")) {
                continue;
            } else if(input.equalsIgnoreCase("Q")) {
                System.exit(0);
            }
            /*
            (1) 알맞은 코드를 넣어 완성하시오.
            */
            // pattern : 정규 표현식이 컴파일된 클래스. 정규 표현식에 대상 문자열을 검증하거나, 활용하기 위해 사용되는 클래스이다. 
            

            if(list.size()>0) {
                System.out.println(list);
                list.clear();
            } else {
                System.out.println("일치하는 번호가 없습니다."); 
            }
        }

    } // main    
}
