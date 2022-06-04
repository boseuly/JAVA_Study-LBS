package ch9;

public class Exercise9_2 {

	public static void main(String[] args) {
//		[9-2] 다음과 같은 실행결과를 얻도록 클래스의 를 멤버변수인 Point3D equals() x, y, z
//		의 값을 비교하도록 오버라이딩하고 은 실행결과를 참고해서 적절히 오버라이 , toString()
//		딩하시오.
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?"+(p1==p2));
		System.out.println("p1.equals(p2)?"+(p1.equals(p2)));
		
	}

}
class Point3D {
	int x,y,z;
	
	Point3D(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	Point3D() {
		this(0,0,0);
	}
	public boolean equals(Object obj) {
	/*
	(1) x, y, z . 인스턴스변수 를 비교하도록 오버라이딩하시오
	*/
		if(obj instanceof Point3D) {
			if(this.x != ((Point3D) obj).x) {
				return false;
			}
			if(this.y != ((Point3D) obj).y) {
				return false;
			}
			if(this.z != ((Point3D) obj).z) {
				return false;
			}
		}
		return true;
//		답안
//		if(obj instanceof Point3D) {
//			Point3D p = (Point3D)obj;
//			return this.x == p.x && this.y == p.y && this.z == p.z;
//		}
		
	}
	public String toString() {
	/*
	(2) x, y, z . 인스턴스변수 의 내용을 출력하도록 오버라이딩하시오
	*/
		return "[" + this.x + this.y + this.z + "]";
	}
}
