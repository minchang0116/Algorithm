package PROG.lv3;

import java.util.Arrays;
import java.util.Collections;

public class 야근지수 {
	public static void main(String[] args) {
		야근지수 service = new 야근지수();
		System.out.println(service.solution(3, new int[] { 1, 1 }));
	}

	public long solution(int n, int[] works) {
		long answer = 0;
		Integer[] sortWorks = new Integer[works.length];
		for (int i = 0; i < works.length; i++) {
			sortWorks[i] = works[i];
		}
		
		outer: while(true) {
			Arrays.sort(sortWorks, Collections.reverseOrder());
			int max = sortWorks[0];
			for (int i = 0; i < sortWorks.length; i++) {
				if(max == 0)
					break outer;
				
				if(max == sortWorks[i]) {
					sortWorks[i]--;
					n--;
					if(n == 0) {
						break outer;
					}
				}
				else {
					break;
				}
			}
		}
		for(int i=0; i<sortWorks.length; i++) {
			answer = sortWorks[i] * sortWorks[i] + answer;
		}
		
		return answer;
	}
}
