package PROG.lv1;

import java.util.ArrayList;
import java.util.Collections;

public class 나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		나누어떨어지는숫자배열 service = new 나누어떨어지는숫자배열();
		service.solution(new int[] {5, 9,7,10}, 5);
	}
	
    public int[] solution(int[] arr, int divisor) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i] % divisor == 0) {
    			result.add(arr[i]);
    		}
    	}
    	
    	Collections.sort(result);
    	if(result.isEmpty()) {
    		int answer[] = new int[] {-1};
    		return answer;
    	}
    	else {
    		int answer[] = new int[result.size()];
    		for(int i=0; i<result.size(); i++) {
    			answer[i] = result.get(i);
    		}
    		return answer;
    	}
    }
}
