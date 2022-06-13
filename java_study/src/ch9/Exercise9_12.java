package ch9;

public class Exercise9_12 { // 틀림
    /*
        [9-12] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
        [주의] Math.random()을 사용하는 경우 실행결과와 다를 수 있음.
        메서드명 : getRand
        기 능 : 주어진 범위 (from~to) 에 속한 임의의 정수값을 반환한다.
                (양쪽 경계값 모두 범위에 포함) 
                from의 값이 to의 값보다 클 경우도 처리되어야 한다.
        반환타입 : int
        매개변수 : int from - 범위의 시작값
                   int to - 범위의 끝값
        [Hint] Math.random()과 절대값을 반환하는 Math.abs(int a), 그리고 둘 중에 작은 값을 반환하는
               Math.min(int a, int b)를 사용하라. min 이 왜....?
     */
    
        /*
        (1) getRand 메서드를 작성하시오.
        */
        public static int getRand(int from, int to){
            // int random = 0;
            // if(from > to){ // 시작수가 끝나는 수보다 클 경우
            //     random =  (int)(Math.random() * to ) + from; // double 형이기 때문에 int 형으로 변환해야 한다.
            // }else if (from < to){   // 시작수가 끝나는 수보다 작을 경우
            //     random = (int)(Math.random() * to) - from; 
            // }
            // return random;
            // (int)Math.random() + (최대값 - 최솟값 + 1) + 최소값
            return (int)(Math.random() * (Math.abs(to-from)+1))+ Math.min(from,to);
            
        }
        public static void main(String[] args)
        {
        for(int i=0; i< 20; i++)
        System.out.print(getRand(1,-3)+",");
        }
        
}
