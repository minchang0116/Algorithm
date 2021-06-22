package PROG.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 두개뽑아서더하기 {
	public static void main(String[] args) {
		두개뽑아서더하기 service = new 두개뽑아서더하기();
		service.solution(new int[] {2,1,3,4,1});
	}
	
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<numbers.length; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		int sum = numbers[i]+numbers[j];
        		if(!hs.contains(sum)) {
	        		hs.add(sum);
        		}
        	}
        }
        ArrayList<Integer> answer = new ArrayList<Integer>(hs); 
        Collections.sort(answer);
        int result[] = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
        	result[i] = answer.get(i);
        }
        return result;
    }
}
