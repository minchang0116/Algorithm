package PROG.lv1;

import java.util.Arrays;

public class 비밀지도 {
	public static void main(String[] args) {
		비밀지도 service = new 비밀지도();
		System.out.println(Arrays.toString(service.solution(6, new int[] { 46, 33, 33, 22, 31, 50 },
				new int[] { 27, 56, 19, 14, 14, 10})));
	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n-answer[i].length(); j++) {
				sb.append(' ');
			}
			for (int j = 0; j < answer[i].length(); j++) {
				if (answer[i].charAt(j) == '0')
					sb.append(' ');
				else {
					sb.append('#');
				}
			}
			answer[i] = sb.toString();
		}
		return answer;
	}
}
