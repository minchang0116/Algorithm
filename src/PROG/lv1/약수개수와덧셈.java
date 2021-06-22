package PROG.lv1;

public class 약수개수와덧셈 {
	public static void main(String[] args) {
		약수개수와덧셈 service = new 약수개수와덧셈();
		service.solution(13, 17);
	}

	public int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			int cnt = calculate(i);
			if (cnt % 2 == 0)
				answer += i;
			else
				answer -= i;
		}

		return answer;
	}

	private static int calculate(int num) {
		int cnt = 0;
		for(int i=1; i<=num; i++) {
			if(num%i == 0)
				cnt++;
		}
		return cnt;
	}
}
