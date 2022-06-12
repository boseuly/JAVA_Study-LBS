package ch9;

/* 
[9-8] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
메서드명 : round
기 능 : 주어진 값을 반올림하여 소수점 이하 n자리의 값을 반환한다.
예를 들어 n의 값이 3이면 소수점 4번째 자리에서 반올림하여 소수점 3이하 자리의 수를 반환한다.
반환타입 : double
매개변수 : double d - 변환할 값 
           int n - 반올림한 결과의 소수점 자리
[Hint] Math.round() Math.pow() 를 이용해라.
*/

public class Exercise9_8 {
    /*
      (1) round 메서드를 작성하시오.
    */
    static double round(double d, int n){ 
        double result = d * Math.pow(10,n);  // d에 10의 n거듭제곱을 곱한다.
        result = Math.round(result);           // 소수점 첫째자리에서 result를 반올림 한 수를 다시 result에 넣기
        result = result / Math.pow(10,n);   // result에 다시 10의 n 거듭제곱을 나눈다.
        return result;
    }
public static void main(String[] args) {
    System.out.println(round(3.1415,1));
    System.out.println(round(3.1415,2));
    System.out.println(round(3.1415,3));
    System.out.println(round(3.1415,4));
    System.out.println(round(3.1415,5));
    
    }
}