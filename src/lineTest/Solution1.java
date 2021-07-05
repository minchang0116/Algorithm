package lineTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 service = new Solution1();
		System.out.println(Arrays.toString(service.solution("AaTa+!12-3")));
	}

	public int[] solution(String inp_str) {
		int[] answer = {};
		answer = passwordCheck(inp_str);
		return answer;
	}

	private int[] passwordCheck(String inp_str) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean check[] = new boolean[4];
		// 1번쨰 체크
		if (!(8 <= inp_str.length() && inp_str.length() <= 15))
			arr.add(1);

		boolean flag = false;
		// 2번째 체크
		for (int i = 0; i < inp_str.length(); i++) {
			if ('A' <= inp_str.charAt(i) && inp_str.charAt(i) <= ('Z')) {
				check[0] = true;
			} else if ('a' <= inp_str.charAt(i) && inp_str.charAt(i) <= ('z')) {
				check[1] = true;
			} else if ('0' <= inp_str.charAt(i) && inp_str.charAt(i) <= ('9')) {
				check[2] = true;
			} else if (inp_str.charAt(i) == '~' || inp_str.charAt(i) == '!' || inp_str.charAt(i) == '@'
					|| inp_str.charAt(i) == '#' || inp_str.charAt(i) == '$' || inp_str.charAt(i) == '%'
					|| inp_str.charAt(i) == '^' || inp_str.charAt(i) == '&' || inp_str.charAt(i) == '*') {
				check[3] = true;
			} else {
				if (flag == false) {
					arr.add(2);
					flag = true;
				}
			}
		}
		// 3번째 체크
		int checkCnt = 0;
		for (int i = 0; i < check.length; i++) {
			if (check[i] == true) {
				checkCnt += 1;
			}
		}
		if (checkCnt >= 3) {
		} else {
			arr.add(3);
		}

		// 4번째 체크
		for (int i = 0; i < inp_str.length() - 1; i++) {
			if (inp_str.charAt(i) == inp_str.charAt(i + 1)) {
				int cnt = 0;
				for (int j = i + 1; j < inp_str.length(); j++) {
					if (inp_str.charAt(i) == inp_str.charAt(j))
						cnt++;
				}
				if (cnt == 3) {
					arr.add(4);
					break;
				}
			}
		}

		int ch[] = new int[255];
		int max = 0;
		// 5번째 체크
		for (int i = 0; i < inp_str.length(); i++) {
			ch[inp_str.charAt(i)] += 1;
			if (max < ch[inp_str.charAt(i)])
				max = ch[inp_str.charAt(i)];
		}
		if (max >= 5) {
			arr.add(5);
		}
		if (arr.size() == 0) {
			arr.add(0);
		}
		int answer[] = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}

}
