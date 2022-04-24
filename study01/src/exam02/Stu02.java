package exam02;

public class Stu02 {

	public static void main(String[] args) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름 : " + s.name);
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : " + s.getAverage());
		
		/*
		 * [6-5] 다음과 같은 실행결과를 얻도록 Student 클래스에 생성자와 info()를 추가하시오.
		 */
		Student s1 = new Student("홍길동" , 1,1,100,60,76);
		
		System.out.println(s.info());
	}
	

}

class Student{
	/*
	 * [6-3] 다음과 같은 멤버변수를 갖는 Student클래스를 정의하시오.
	 */
	String name;	// 학생이름
	int ban;		// 반
	int no;			// 번호
	int kor;		// 국어점수
	int eng;		// 영어점수
	int math;		// 수학점수
	
	Student() {}
	
	// [6-5]
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	/*
	 * [6-4] 문제 [6-3]에서 정의한 Student클래스에 다음과 같이 정의된 두 개의 메소드 getTotal()과 getAverage()를 추가하시오.
	 */
	
	int getTotal() {
		int sum = this.kor + this.eng + this.math;
		return sum;
	}
	
	

	float getAverage() {
		float result = Math.round(((float)this.getTotal() / 3) * 10) / (float)10;	// round는 1의 자리에서 반올림 -> 
		return result;
		
	}
	
	StringBuilder info() {
		StringBuilder result = new StringBuilder();
		result.append(name + ", ");
		result.append(ban+ ", ");
		result.append(no+ ", ");
		result.append(kor+ ", ");
		result.append(eng+ ", ");
		result.append(math+ ", ");
		result.append(this.getTotal()+ ", ");
		result.append(this.getAverage());
		return result;
	}
	
}


