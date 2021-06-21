package PROG.lv1;

public class 소수만들기 {
	public static void main(String[] args) {
		소수만들기 service = new 소수만들기();
		service.solution(new int[] {1,2,3,4});
	}
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			if(isPrime(nums[i] + nums[j] + nums[k]))
        				answer++;
        		}
        	}
        }
        return answer;
    }
    
    public boolean isPrime(int num) {
		for(int l=2; l<=Math.sqrt(num); l++) {
			if(num%l == 0) { // 나누어 떨어지면 소수가 아니다
				return false;
			}
		}
		return true;
    }
}
