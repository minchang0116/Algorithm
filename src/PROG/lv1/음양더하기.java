package PROG.lv1;

public class 음양더하기 {
	public static void main(String[] args) {
		음양더하기 service = new 음양더하기();
		service.solution(new int[] { 4, 7, 12 }, new boolean[] { true, false, true });
	}

	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			if(signs[i]) 
				answer += absolutes[i];
			else 
				answer -= absolutes[i];
		}
		return answer;
	}
}
