package 프로그.그리디;

import java.util.Arrays;

public class 구명보트 {
	public static void main(String[] args) {
		구명보트 service = new 구명보트();
		System.out.println(service.solution(new int[] {70, 50, 80, 50}, 100));
	}
	
    public int solution(int[] people, int limit) {
    	int answer = 0;
    	Arrays.sort(people);
    	boolean check[] = new boolean[people.length];
    	int curJ=people.length-1;
    	outer: for(int i=0; i<people.length; i++) {
    		if(check[i] == true) continue;
    		check[i] = true;
    		answer++;
    		for(int j=curJ; j>=0; j--) {
    			if(check[j] == true) continue;
    			check[j] = true;
    			if(people[i] + people[j] <= limit) {
    				curJ=j-1;
    				continue outer;
    			}
    			answer++;
    		}
    	}
        return answer;
    }
}
