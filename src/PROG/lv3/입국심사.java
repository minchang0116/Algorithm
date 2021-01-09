package PROG.lv3;

import java.util.Arrays;

public class 입국심사 {
	public static void main(String[] args) {
		입국심사 service = new 입국심사();
		System.out.println(service.solution(6, new int[] {7, 10}));
	}
    public long solution(int n, int[] times) {
    	long right = 0;
    	for(int i=0; i<times.length; i++) {
    		if(right < times[i]) right = times[i];
    	}
    	right *= n;
    	long answer = 0;
    	long left =1;
    	int size=times.length;
    	
    	while(true) {
    		long mid = (left+right)/2;
    		long cnt = 0;
    		for(int i=0; i<size; i++) {
    			cnt += mid / times[i];
    		}
    		
    		if(cnt < n) { // cnt가 더 작으면
    			left = mid+1;
    		}
    		else if(cnt >= n) {
    			right = mid;
    		}

    		
    		if(left == right) {
    			answer = right;
    			break;
    		}
    	}
        return answer;
    }
}
