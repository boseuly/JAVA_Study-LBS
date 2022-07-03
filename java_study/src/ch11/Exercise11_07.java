package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	// 생성자로 초기화 
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name
				+","+ban
				+","+no
				+","+kor
				+","+eng
				+","+math
				+","+getTotal()
				+","+getAverage();
	}
} // class Student

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
	/*
	(1) 알맞은 코드를 넣어 완성하시오.
	*/
		// 만약 Student 클래스라면
		if(o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student)o1;
			Student s2 = (Student)o2;
			Integer ban1 = s1.ban;
			Integer ban2 = s2.ban;
			
			if(ban1.compareTo(ban2) == 0) { // 만약 반이 같다면 번호로 또 비교한다.
				Integer no1 = s1.no;
				Integer no2 = s2.no;
				return no1.compareTo(no2); // compareTo 메소드에서 no1과 no2를 서로 빼주기 때문에 
			}else {						   // 답안과 별반 다를 게 없는 것 같음
				return ban1.compareTo(ban2);	// 만약 반이 다르다면 	반을 비교해서 정렬해라
			}
		}else { // 만약 Student 클래스가 아니라면
			return -1;
		}
	}
	
	
	
	/* 답안
	 * public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student)o1;
			Student s2 = (Student)o2;
			int result = s1.ban - s2.ban;
			if(result==0) { // , . 반이 같으면 번호를 비교한다
			return s1.no - s2.no;
			}
			return result;
		}
		return -1;
		}
	 */
	
	
}

public class Exercise11_07 {

	public static void main(String[] args) {

		/*
		 * [11-7] 다음에 제시된 BanNoAscending클래스를 완성하여, ArrayList Student에 담긴 인스턴스들이 
		 * 반(ban)과 번호(no)로 오름차순 정렬되게 하시오. (반이 같은 경우 번호를 비교해서 정렬한다.)
		 */
		ArrayList list = new ArrayList();
		list.add(new Student("이자바",2,1,70,90,70));
		list.add(new Student("안자바",2,2,60,100,80)); 
		list.add(new Student("홍길동",1,3,100,100,100)); 
		list.add(new Student("남궁성",1,1,90,70,80)); 
		list.add(new Student("김자바",1,2,80,80,90)); 
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		while(it.hasNext())
		System.out.println(it.next());

	}

}
