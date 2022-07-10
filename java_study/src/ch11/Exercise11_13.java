package ch11;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Exercise11_13 {

	public static void main(String[] args) throws Exception {
		/*
		 [11-13] 다음 코드는 문제 [11-12]를 발전시킨 것으로 각 Player들의 점수를 계산하고 점수가 
		제일 높은 사람을 출력하는 코드이다. TreeMap의 정렬기준을 점수가 제일 높은 사람
		부터 내림차순이 되도록 아래의 코드를 완성하시오. 단, 동점자 처리는 하지 않는다.
		 */
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		Player[] pArr = {
			new Player("타짜", deck.pick(), deck.pick()),
			new Player("고수", deck.pick(), deck.pick()),
			new Player("물주", deck.pick(), deck.pick()),
			new Player("중수", deck.pick(), deck.pick()),
			new Player("하수", deck.pick(), deck.pick()) 
		};
		TreeMap rank = new TreeMap(new Comparator(){	// 트리맵을 사용할 때는 반드시 정렬기준을 
		public int compare(Object o1, Object o2) {
			/*
			(1) 알맞은 코드를 넣어 완성하시오.
			*/
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry)o1;
				Map.Entry e2 = (Map.Entry)o2;
				
				// 값을 가지고 와서 비교해야 하니까
				Integer v1 = ((Integer) e1.getValue()).intValue();
				Integer v2 = ((Integer) e2.getValue()).intValue();
				
				return (v1 - v2) * -1;
			}
			
			return -1;
			}
		});
		for(int i=0; i < pArr.length;i++) {
			Player p = pArr[i];
			rank.put(p, deck.getPoint(p));
			System.out.println(p+" "+deck.getPoint(p));
		}
		System.out.println();
		System.out.println("1 "+rank.firstKey()+" .");
	}

}
