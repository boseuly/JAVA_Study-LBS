package ch11;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise11_1 {

	public static void main(String[] args) {

		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // 교집합
		ArrayList cha = new ArrayList(); // 차집합
		ArrayList hap = new ArrayList(); // 합집합
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		/*
		  [11-1] 다음은 정수집합 1,2,3,4와 3,4,5,6 의 교집합, 차집합, 합집합을 구하는 코드이 다.
		  코드를 완성하여 실행결과와 같은 결과를 출력하시오 . 
		[Hint] ArrayList addAll(), removeAll(), retainAll() 을 사용하라.
		
		addAll() : 주어진 컬렉션의 모든 객체를 저장한다.
		removeAll () : 지정한 컬렉션에 저장된 것과 동일한 객체들을 ArrayLsit에서 제거한다.
		retainAll() : ArrayList에 저장된 객체 중에서 주어진 컬렉션과 공통된 것들만을 남기고 나머지는 삭제한다. 
		 */
		
		/*
		(1)  알맞은 코드를 넣어 완성하시오
		*/
		// list1,2 의 값이 변하면 안 되기 때문에 따로 복사를 해놓는다.
		ArrayList copy1 = new ArrayList();
		copy1 = (ArrayList) list1.clone(); //copy2.addAll(list2);
		ArrayList copy2 = new ArrayList();
		copy2 = (ArrayList) list2.clone(); // copy2.addAll(list2);
		
		 
		 
		 // 교집합
		 list1.retainAll(list2);
		 kyo = list1;
		 list1 = (ArrayList) copy1.clone();
		 
		 //차집합
		 list1.removeAll(list2);
		 cha = list1;
		 list1 = (ArrayList) copy1.clone();
	
		 // 합집합 -> 중복되는 건 빼줘야 한다.
		 list1.addAll(list2);
		 hap = list1;
		 for(int i = hap.size()-1; i >= 0; i--) {
			 if(kyo.contains(hap.get(i))) {
				 hap.remove(i);
			 }
		 }
//		중복되는 거 빼주는 다른 방법 :  hap.removeAll(kyo); // 중복되는 것을 제거해준다. 중복되는 건 즉, 교집합
		 hap.addAll(kyo);			// 교집합을 다시 넣어준다.
		 list1 = (ArrayList) copy1.clone();
		 // 합집합 정렬
		Collections.sort(hap);
	
		System.out.println("list1="+list1);
		System.out.println("list2="+list2);
		System.out.println("kyo="+kyo);
		System.out.println("cha="+cha);
		System.out.println("hap="+hap);
	}

}
