package ch3;

public class Stu05 {
	/*
	 * (1) abs 메서드를 작성하시오.
	 */
	
	static int abs(int value) {
		if(value > 0) {	// 만약 value가 0보다 크다면
			return value;
		}else if(value == 0) {
			return 0;
		}else {
			return -value;
		}
	}
	
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value+"의 절대값:" + abs(value));
		
		value = -10;
		System.out.println(value+"의 절대값:" +abs(value));
	}
	
	
}
