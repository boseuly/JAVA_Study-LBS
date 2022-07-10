package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student5 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // 총점
	int schoolRank; // 전교등수
	int classRank; // 반등수

	
	Student5(String name, int ban, int no, int kor, int eng, int math) {
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
	
		if(o instanceof Student5) {
			Student5 s1 = (Student5)o;
			return (this.total - s1.total) * (-1);	// 양수면 -1를 곱해서 음수로, 음수면 -1 곱해서 양수로 -> 내림차순
			
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
		+","+schoolRank // 새로추가
		;
	}
} // class Student

class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
	/*
	(1) 알맞은 코드를 넣어 완성하시오.
	*/
		if(o1 instanceof Student5 && o2 instanceof Student5) {
			Student5 s1 = (Student5)o1;
			Student5 s2 = (Student5)o2;
			if(s1.ban == s2.ban) {	// 만약 반이 같다면
				// 총점을 비교해서 누가 더 높은지 확인
				return (s1.total - s2.total) * -1;
			}else {
				// 만약 반이 다르다면 총점 비교할 필요 없음 -> 여기 어떻게 처리해야 할지 헷갈렸음
				return (s1.ban - s2.ban) * -1;
			}
		}else {
			return -1;
		}
		
	}
}
class Exercise11_9 {
	public static void calculateClassRank(List list) {
		// 먼저 반별 총점기준 내림차순으로 정렬한다
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		/*
		 * (2)	// 틀림
		 */
		for(int i = 0, n=0; i < length; i++, n++) {
			Student5 s = (Student5) list.get(i);
			if(s.ban != prevBan) {	// 반이 달라지면 
				prevRank = 0;		// 초기화 해준다.
				prevTotal = 0;
				n = 0; 
			}else {					// 만약 반이 같다면
				if(s.total == prevTotal) {
					s.classRank = prevRank;
				}else {
					s.classRank = n+1;
				}
				prevBan = s.ban;
				prevTotal = s.total;
				prevRank = s.classRank;
			}
		}
	} // public static void calculateClassRank(List list) {
	public static void calculateSchoolRank(List list) {
		/*내용 생략 */ 
	}
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student5("이자바",2,1,70,90,70)); 
		list.add(new Student5("안자바",2,2,60,100,80)); 
		list.add(new Student5("홍길동",1,3,100,100,100)); 
		list.add(new Student5("남궁성",1,1,90,70,80)); 
		list.add(new Student5("김자바",1,2,80,80,90)); 
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}
}

