package ch02;

class MyPoint{
	int x;
	int y;
	
	MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	/*
	 * (1) 인스턴스 메소드 getDistance를 작성하시오.
	 */
	double getDistance(int x1, int y1){
		double l = Math.sqrt(Math.pow(this.x-x1 ,2) + Math.pow(this.y-y1, 2));
		return l;
	}
}



public class Stu04 {

	public static void main(String[] args) {
		MyPoint p = new MyPoint(1,1);
		
		// p와 (2,2)의 거리를 구한다.
		System.out.println(p.getDistance(2, 2));
	}

}



