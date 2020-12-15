package PROG.lv2;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		HIndex service = new HIndex();
		System.out.println(service.solution(new int[] {3,0,6,1,5}));
	}
    public int solution(int[] citations) {
    	int answer = 0;
    	Arrays.sort(citations);
    	for(int i=citations.length-1; i>=0; i--) {
    		if(citations.length-i >= citations[i] && i <= citations[i]) {
    			answer=citations[i];
    			break;
    		}
    	}
        return answer;
    }
}
