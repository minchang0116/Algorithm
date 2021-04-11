package PROG.lv2;

import java.util.Arrays;

public class 조이스틱 {
	public static void main(String[] args) {
		조이스틱 service = new 조이스틱();
		System.out.println(service.solution("JEROEN"));
	}
    public int solution(String name) {
    	int answer = 0;
    	int temp[] = new int[name.length()];
    	boolean check[] = new boolean[temp.length];
    	for(int i=0; i<name.length(); i++) {
    		temp[i] = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
    		answer += temp[i];
    	}
    	
    	temp[0] = 0;
    	
    	// 오른쪽 갈지 왼쪽갈지
    	
        return answer;
    }
}
