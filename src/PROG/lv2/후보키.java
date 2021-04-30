package PROG.lv2;

import java.util.HashSet;

public class 후보키 {
	public static void main(String[] args) {
		후보키 service = new 후보키();
		System.out.println(service.solution(new String[][] { { "a", "1", "4" },
				{ "2", "1", "5" }, { "a", "2", "4" }}));
	}

	public int solution(String[][] relation) {
		answer =0;
		HashSet<String> hs = new HashSet<>();
		hs2 = new HashSet<>();
		int numbers[] = new int [relation[0].length];
		combi(0,0, numbers, relation, hs);
		
		return answer;
	}

	static int answer;
	HashSet<String> hs2;
	private void combi(int cnt, int idx, int[] numbers, String[][] relation, HashSet<String> hs) {
		outer: if(cnt >= 1) {
			// 유일성 체크
			for(int i=0; i<relation.length; i++) { // 행의 갯수
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<cnt; j++) {
					// 고른것을 기준으로 또 조합해서 체크해야됨
					sb.append(numbers[j]).append(relation[i][numbers[j]]);
				}
				if(hs.contains(sb.toString())) {
					break outer;
				}
				hs.add(sb.toString());
			}
			// 최소성 체크
			int numbers2[] = new int[cnt];
			flag= false;
			combi2(0,0, numbers2, numbers);
			if(flag == true) {
				break outer;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<cnt; i++) {
				sb.append(numbers[i]);
			}
			hs2.add(sb.toString());
			answer++;
		}
		
		for(int i=idx; i<numbers.length; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1, numbers,relation, hs);
		}
	}
	static boolean flag;
	private void combi2(int cnt, int idx, int[] numbers2, int[] numbers) {
		if(cnt == numbers2.length || flag==true)
		{
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<cnt; j++) {
			sb.append(numbers[numbers2[j]]);
		}
		if(hs2.contains(sb.toString())) {
			flag=true;
		}
		
		for(int i=idx; i<numbers2.length; i++) {
			numbers2[cnt] = i;
			combi2(cnt+1,i+1, numbers2, numbers);
		}
	}
	
	
}
