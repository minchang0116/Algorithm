package PROG.lv2;

import java.util.Arrays;

public class 가장큰수 {
	public static void main(String[] args) {
		가장큰수 service = new 가장큰수();
		System.out.println(service.solution(new int []{0,0,0,0}));
	}
    public String solution(int[] numbers) {
    	String arr[] = new String[numbers.length];
    	int index=0;
    	for(int number:numbers) {
    		arr[index++] = Integer.toString(number);
    	}
    	
    	Arrays.sort(arr, (o1, o2) ->{
    		return (o2+o1).compareTo(o1+o2);
    	});
    		
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<arr.length; i++) {
    		sb.append(arr[i]);
    	}
        String answer = sb.toString();
        if(sb.charAt(0) == '0') {
        	answer = "0";
        }
        return answer;
    }
}
