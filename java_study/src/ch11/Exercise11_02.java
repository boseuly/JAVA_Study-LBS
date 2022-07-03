package ch11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Exercise11_02 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		HashSet set = new HashSet(list); // 중복을 허용하지 않는다.
		TreeSet tset = new TreeSet(set);	// 중복 허용 x
		Stack stack = new Stack();	
		stack.addAll(tset);				
		while(!stack.empty())
		System.out.println(stack.pop()); // 7,6,3,2
	}

}
