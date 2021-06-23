package PROG.lv1;

import java.util.StringTokenizer;

public class 다트게임 {
	public static void main(String[] args) {
		다트게임 service = new 다트게임();
		System.out.println(service.solution("1S*2T*3S"));
	}
	
    public int solution(String dartResult) {
    	StringBuilder sb = new StringBuilder();
    	int sum = 0;
    	int prevSum = 0;
    	
    	for(int i=0; i<dartResult.length(); i++) {
    		if(dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
    			sb.append(dartResult.charAt(i));
    		}
    		else {
    			int curSum =0;
    			if(dartResult.charAt(i) == 'S') {
    				curSum = Integer.parseInt(sb.toString());
    			}
    			else if(dartResult.charAt(i) == 'D') {
    				curSum = (int) Math.pow(Integer.parseInt(sb.toString()), 2);
    			}
    			else if(dartResult.charAt(i) == 'T') {
    				curSum = (int) Math.pow(Integer.parseInt(sb.toString()), 3);
    			}
    			
    			if(i != dartResult.length() -1) {
    				if(dartResult.charAt(i+1) == '*' ) {
    					prevSum*=2;
    					curSum *= 2;
    					i++;
    				}
    				else if(dartResult.charAt(i+1) == '#') {
    					curSum *= -1;
    					i++;
    				}
    			}
    			sum += prevSum;
				prevSum = curSum;
    			sb.setLength(0);
    		}
    	}
    	sum += prevSum;
        return sum;
    }
}
