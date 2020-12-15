package PROG.lv2;

import java.util.StringTokenizer;

public class 최댓값과최솟값 {

	public static void main(String[] args) {
		최댓값과최솟값 service = new 최댓값과최솟값();
		System.out.println(service.solution("1 2 3 4"));
	}
    public String solution(String s) {
    	StringTokenizer st = new StringTokenizer(s, " ");
    	
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	while(st.hasMoreElements()) {
    		int temp = Integer.parseInt(st.nextToken());
    		max = Math.max(temp, max);
    		min = Math.min(temp, min);
    	}
    	String answer =  Integer.toString(min) + " " + Integer.toString(max) ;
        return answer;
    }
}
