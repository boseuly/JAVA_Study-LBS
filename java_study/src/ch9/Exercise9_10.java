package ch9;

public class Exercise9_10 {
    /*
     [9-10] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
    메서드명 : format
    기 능 : 주어진 문자열을 지정된 크기의 문자열로 변환한다. 나머지 공간은 공백으로 채운다.
    반환타입 : String
    매개변수 : String str - 변환할 문자열
              int length - 변환된 문자열의 길이
              int alignment - 변환된 문자열의 정렬조건
        (0:왼쪽 정렬, 1:가운데 정렬 , 2:오른쪽 정렬 ) 
     */

     /*
        (1) format 메서드를 작성하시오.
        1. length 의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
        2. 1 의 경우가 아니면, length 크기의 char배열을 생성하고 공백으로 채운다.
        3. 정렬조건 (alignment)의 값에 따라 문자열 (str)을 복사할 위치를 결정한다.
            (System.arraycopy() ) 사용
        4. 2 char 에서 생성한 배열을 문자열로 만들어서 반환한다
    */
    public static String format(String str, int length, int alignment){
        if(length < str.length()){  // length가 str의 길이보다 작다면
            // length 만큼만 잘라서 반환! 
            return str.substring(0, length); // substring은 endIndex - 1 이어서 -1 안 해줘도 된다.
        }
        // str을 char형으로 바꾸기(arraycopy() 타입 맞추려고)
        char ch[]  = str.toCharArray();

        // length의 크기의 char배열 생성하고 공백으로 채우기
        char result[] = new char[length];   
        for(int i = 0 ; i < result.length; i++){
            result[i]=' ';
        }
        // 만약 alignment=0이라면 (왼쪽 정렬이라면)
        if(alignment == 0){
            System.arraycopy(ch, 0, result, 0, ch.length); // str의 0번째 인덱스부터 str.length() 만큼을
        }else if(alignment == 1){                                              // result의 0번째 인덱스부터 시작해서 복사해라
            System.arraycopy(ch, 0, result, (length - str.length())/2, ch.length);  // result의 length/2번째 인덱스부터 시작해서 복사해라
        }else if(alignment == 2){
            System.arraycopy(ch, 0, result, length - ch.length, ch.length);
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String str = "가나다";
        System.out.println(format(str,7,0)); // 왼쪽 정렬
        System.out.println(format(str,7,1)); // 가운데 정렬
        System.out.println(format(str,7,2)); // 오른쪽 정렬
        }
        
}
