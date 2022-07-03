package ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CollectionPrac {
	
	public static void main(String[] args) {
		List list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(6));
		list1.add(new Integer(9));
		
		List list2 = new ArrayList(list1.subList(1,3)); // 3번인덱스는 포함 되지 않는다.
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		
		// 중복되는 요소를 찾아서 삭제하는 과정이다. 이때는 뒤에서부터 찾아서 삭제를 해줘야 한다.
		// 앞에서부터 찾아서 삭제를 하면 한칸씩 앞으로 자리 이동을 하기 때문에 올바른 결과를 얻을 수 없다.
		// 따라서 뒤에서부터 해야 자리이동을 하더라도 다음 인덱스에 영향을 주지 않기에 올바른 결과를 얻을 수 있다.
		for(int i = list2.size()-1 ; i >= 0; i--) {
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		
		
//		Vector v = new Vector(5);
		String s = new String();
		String s1 = new String();
		s1 = "안녕";
		System.out.println(s.hashCode());
		s += "안녕";
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		s += "하세요.";
		s1 += "하세요.";
		System.out.println(s.hashCode());	// 문자열을 추가한 경우 
		System.out.println(s1.hashCode());	
		// 문자열 해쉬코드 -> 값이 같으면 해쉬코드도 같게 나온다. 
		
		
		
		
	}
}
