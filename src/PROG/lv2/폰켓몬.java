package PROG.lv2;

import java.util.HashSet;

public class 폰켓몬 {

	public static void main(String[] args) {
		폰켓몬 service = new 폰켓몬();
		System.out.println(service.solution(new int[] {3,1,2,3}));
	}
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(hs.contains(nums[i])) continue;
        	hs.add(nums[i]);
        	answer++;
        }
        if(answer > nums.length/2) {
        	answer = nums.length/2;
        }
       
        return answer;
    }
}
