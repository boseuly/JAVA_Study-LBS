package exam03;

import java.util.Arrays;

public class Stu04 {
	/*
	 * (1) max 메서드를 작성하시오.
	 */
	static int max(int[] arr) {
		int tmp = 0; // 임시보관장소
		if(arr == null|| arr.length == 0) {
			return -999999;
		}else {
			for(int i = 0 ; i < arr.length; i++) {
				for(int j = i; j < arr.length;j++) {
					if(arr[i] < arr[j]) {	// 만약 arr[i]보다 arr[j]가 더 크다면 값을 바꿔줘라
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = arr[i];
					}
				}
			}
		}
		
		return arr[0]; 
	}
	
	public static void main(String[] args) {
		/*
		 * 메서드명  max
		 * 기능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
		 * 		만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
		 * 반환타입 : int
		 * 매개변수 : int[] arr - 최대값을 구할 배열
		 */
		{
			int[] data = {3,2,9,4,7};
			System.out.println(Arrays.toString(data));
			System.out.println("최대값 : " + max(data));
			System.out.println("최대값 : " + max(null));
			System.out.println("최대값 : " + max(new int[]{}));
			
		}
	}

}
