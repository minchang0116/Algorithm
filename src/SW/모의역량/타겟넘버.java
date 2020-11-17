package SW.모의역량;

public class 타겟넘버 {
	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {1,1,1,1,1}, 3));
	}
    public static int solution(int[] numbers, int target) {
     
    	dfs(numbers, 0, 0,0, target);
    	int answer = result;
        return answer;
    }
    
    static int result;
	private static void dfs(int numbers[], int sum,int idx ,int cnt, int target) {
		if(cnt == numbers.length) {
			if(sum == target)
				result++;
			return;
		}
		dfs(numbers, sum+numbers[idx], idx+1 , cnt+1, target);
		dfs(numbers, sum-numbers[idx], idx+1 , cnt+1, target);
	}
}
