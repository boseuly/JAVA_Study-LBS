package ch07;

public class Exercise7_22 {


	
	public static void main(String[] args) {
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
		System.out.println("면적의 합 :"+sumArea(arr));
		
		/*
		[7-22] 아래는 도형을 정의한 Shape클래스이다. 이 클래스를 조상으로 하는 Circle클래스와 
		Rectangle클래스를 작성하시오. 이 때, 생성자도 각 클래스에 맞게 적절히 추가해야 한다.
		
		(1) 클래스명  : Circle 
			조상클래스 : Shape
			멤버변수  : double r -반지름
		
		(2) 클래스명  : Rectangle 
			조상클래스 : Shape
			멤버변수  : double width - 폭
				 	 double height - 높이
			메서드 :
			1. 메서드명: isSquare 
				기 능 : 정사각형인지 아닌지를 알려준다.
				반환타입 : boolean
				매개변수: 없음 
		*/
		
	}

	 /* [7-23] 문제 7-22에서 정의한 클래스들의 면적을 구하는 메서드를 작성하고 테스트 하시오.
	  	(1) sumArea 메서드를 작성하시오.
	  
	  	1. 메서드명 : sumArea 
			기 능 : 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
			반환타입 : double
			매개변수 : Shape[] arr
	 */
		static double sumArea(Shape[] arr) {
			double sum = 0;
			for(int i = 0; i < arr.length; i++) {
				sum += arr[i].calcArea();
			}
			return sum;
		}

	
}
// 여기서부터
class Circle extends Shape {
	double r;
	
	Circle(){}

	Circle(double r){
		this.r = r;
	}
	
	@Override
	double calcArea() {
		return Math.PI*r*r;
	}
}

class Rectangle extends Shape {
	double width;
	double height;
	
	Rectangle(){}
	Rectangle (double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	boolean isSquare(){		// 정사각형인지 구분하는 메소드
		if(this.width == this.height) {
			return true;
		}
		return false;
	}

	@Override
	double calcArea() {
		return width * height;
	}
}
// 여기까지 답안

abstract class Shape {		
	Point p;
	Shape() {
		this(new Point(0,0));
	}
	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드
	
	Point getPosition() {
		return p;
	}
	void setPosition(Point p) {
		this.p = p;
	}
}

//시작위치 알려주는 클래스
class Point {	
	int x;
	int y;
	Point() {
		this(0,0);
	}
	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "["+x+","+y+"]";
	}
}
