package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student3 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // 총점
	int schoolRank; // 전교등수
	Student3(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	public int compareTo(Object o) {
	/*
	(1) 알맞은 코드를 넣어 완성하시오.기본정렬을 (name)이름이 아닌 총점(total)을 기준으로 한 내림차순으로 변경하기
	*/
		if(o instanceof Student3) {
			Student3 s1 = (Student3)o;
			return (this.total - s1.total) * (-1);	// 양수면 -1를 곱해서 음수로, 음수면 -1 곱해서 양수로 -> 내림차순
			// 답안 : s1.total - this.total  -> 순서를 바꿔줌
		}else {
			return -1;
		}
		
		
	}
	public String toString() {
		return name
		+","+ban
		+","+no
		+","+kor
		+","+eng
		+","+math
		+","+getTotal()
		+","+getAverage()
		+","+schoolRank; // 새로추가
	}
} // class Student
class Exercise11_8 {
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		/*
		(2)아래의 로직에 맞게 코드를 작성하시오.
			1.  반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
				1.1 (total)총점이 (prevTotal)이전총점과 같으면,
				 	이전등수(prevRank)를 등수(schoolRank)로 한다.
				1.2 총점이 서로 다르면,
				 	등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
					이전에 동점자 였다면 그 다음 등수는 동점자의 수를 고려해야 한다.
				(실행결과 참고) 
			1.3  현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
		*/
		// 1번
		for(int i = 0; i < length ; i++) {	
			Student3 s = (Student3) list.get(i);
			
		// 2번	// 총점을 기준으로 했으니까 내림차순으로 정렬이 되어있을 것
			if(s.total == prevTotal) {	// 만약 총점이 이전 총점과 같다면
				s.schoolRank = prevRank;	// 등수도 같음
											// 이전 총점과 이전 전교 등수를 그대로 둔다.(같으므로)
			}else {		// 가장 첫 번째 학생이 1등임 
				s.schoolRank = i + 1;
			}
			prevTotal = s.total;		// 이전 점수 저장
			prevRank = s.schoolRank;	// 현재 학생의 점수를 이전 점수에 저장함 
		}
	}

	public static void main(String[] args) {
		/*
		  	[11-8] 문제 11-7의 Student클래스에 (total)총점 과 전교등수(schoolRank) 를 저장하기    
			위한 인스턴스변수를 추가하였다. Student클래스의 기본정렬을 (name)이름이 아닌 총점  
			(total)을 기준으로 한 내림차순으로 변경한 다음, 총점을 기준으로 각 학생의 전교등수를 
			계산하고 전교등수를 기준으로 오름차순 정렬하여 출력하시오.
		 */
		ArrayList list = new ArrayList();
		list.add(new Student3("이자바",2,1,70,90,70)); 
		list.add(new Student3("안자바",2,2,60,100,80)); 
		list.add(new Student3("홍길동",1,3,100,100,100)); 
		list.add(new Student3("남궁성",1,1,90,70,80)); 
		list.add(new Student3("김자바",1,2,80,80,90));
		calculateSchoolRank(list);
		Iterator it = list.iterator();
		while(it.hasNext())
		System.out.println(it.next());
	}

}
