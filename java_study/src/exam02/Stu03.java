package exam02;

public class Stu03 {

	/*
	 * [6-6] 두 점의 거리를 계산하는 getDistance()를 완성하시오.
	 * hint : 제곱근 계산은 Math.sqrt(double a)를 사용하면 된다.
	 */
	
	// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.	static메소드(클래스 메소드)
	static double getDistance(int x, int y, int x1, int y1) {	
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		
		double l = Math.sqrt(Math.pow(x-x1 ,2) + Math.pow(y-y1, 2));	// 제곱해주는 함수 Math.pow를 따로 사용하기
		return l;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1,1,2,2));
	}
	
	

}
