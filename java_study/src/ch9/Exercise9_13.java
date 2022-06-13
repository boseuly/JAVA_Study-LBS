package ch9;

public class Exercise9_13 {
    /*
        [9-13] 다음은 하나의 긴 문자열(source) 중에서 특정 문자열과 일치하는 문자열의 개수 
        를 구하는 예제이다. 빈 곳을 채워 예제를 완성하시오.
     */
    public static void main(String[] args) {
        String src = "aabbccAABBCCaaaaaaaaAAzzaazaaazaza";
        System.out.println(src);
        System.out.println("aa를" + stringCount(src, "aa") +"개 찾았습니다."); 
    }
    static int stringCount(String src, String key) {
        return stringCount(src, key, 0);
    }
    
    static int stringCount(String src, String key, int pos) {   // pos는 어디부터 찾을지 정하는 것 같다.
        int count = 0;
        int index = 0;
        if (key == null || key.length() == 0)
        return 0;
        /*
            (1)알맞은 코드를 넣어 완성하시오.
        */
        // indexOf(int ch, int pos) 사용하기
        
        while(pos < src.length()){    // pos가 문자열의 길이보다 작다면
            index = src.indexOf(key, pos);  // 위치를 index에 저장
            if(index == -1){    // 만약 구하는 문자열이 없어서 -1이 나온다면
                break;
            }
            pos = index + key.length();   // 원래의 인덱스에 찾은 문자열의 인덱스를 더해준다.
            count++;
        }
        return count;
    }
}
