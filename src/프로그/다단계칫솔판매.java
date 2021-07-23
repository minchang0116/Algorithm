package 프로그;

import java.util.Arrays;

public class 다단계칫솔판매 {
	public static void main(String[] args) {
		다단계칫솔판매 service = new 다단계칫솔판매();
		System.out.println(Arrays.toString(service.solution(
				new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod","young"},
				new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
				new String[] {"young", "john", "tod", "emily", "mary"},
				amount)));
	}
	
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        return answer;
    }
}
