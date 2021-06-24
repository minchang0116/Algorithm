package PROG.lv1;

import java.util.ArrayList;

public class 같은숫자싫어 {
	public static void main(String[] args) {
		같은숫자싫어 service = new 같은숫자싫어();
		service.solution(new int[] {1,1,3,3,0,1,1});
	}
    public int[] solution(int []arr) {
    	ArrayList<Integer> answer = new ArrayList<Integer>();
    	answer.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
        	if(arr[i-1] == arr[i]) continue;
        	answer.add(arr[i]);
        }
        
        int result[] = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
        	result[i] = answer.get(i);
        }
        return result;
    }
	
}
