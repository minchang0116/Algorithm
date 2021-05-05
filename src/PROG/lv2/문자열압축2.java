package PROG.lv2;

public class 문자열압축2 {
	public static void main(String[] args) {
		문자열압축2 service = new 문자열압축2();
		service.solution("aabbaccc");
	}

	public int solution(String s) {
		// 문자열 길이의 절반만큼 압축
		int half = s.length() / 2;
		int answer = s.length();
		StringBuilder sb = new StringBuilder();
		int curIdx = 0;
		// 2개로 잘랐을때부터 시작
		for (int i = 2; i < half; i++) {
			int tempLength = compression(s, i).length();
			Math.min(answer, tempLength);
		}

		return answer;
	}

	private String compression(String s, int size) {
		StringBuilder sb = new StringBuilder();
		
		String prev = s.substring(0, size);
		int cnt = 1;
		int curIdx = 0;
		while(true) {
			
		}
		
		return sb.toString();
	}
}
