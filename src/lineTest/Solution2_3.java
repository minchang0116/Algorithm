package lineTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2_3 {
	public static void main(String[] args) {
		Solution2_3 service = new Solution2_3();
		System.out
				.println(Arrays.toString(service.solution("line", new String[] { "-s STRING", "-n NUMBER", "-e NULL" },
						new String[] { "line -n 100 -s hi -e", "lien -s Bye" })));
	}

	public boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];

		HashMap<String, String> hs = new HashMap<String, String>();
		HashSet<String> hsSet = new HashSet<String>();
		for (int i = 0; i < flag_rules.length; i++) {
			StringTokenizer st = new StringTokenizer(flag_rules[i], " ");
			String temp1 = st.nextToken();
			String temp2 = st.nextToken();
			if (temp2 == "ALIAS") {
				String temp3 = st.nextToken();
				hs.put(temp1, temp3);
			}
			hs.put(temp1, temp2);
		}

		if (commands.length < 1 && commands.length > 100) {
			System.out.println("commands의 길이가 잘못됐습니다.");
			return answer;
		}
		outer: for (int k = 0; k < commands.length; k++) {
			answer[k] = true;

			String temp[] = commands[k].split(" ");
			if (temp.length < 1 && temp.length > 100) {
				answer[k] = false;
				System.out.println("command의 길이가 잘못됐습니다.");
				continue outer;
			}
			// 프로그램 이름 길이 검사 ( 1~10 )
			if (temp[0].length() > 10 && temp[0].length() < 1) {
				answer[k] = false;
				System.out.println("프로그램의 이름이 잘못됐습니다. (1~10)");
				continue outer;
			} else {
				if (!temp[0].equals(program)) {
					answer[k] = false;
					System.out.println("프로그램의 이름이 일치하지않습니다.");
					continue outer;
				}
			}

			for (int i = 1; i < temp.length; i++) {
				if (temp[i].charAt(0) != '-') {
					answer[k] = false;
					System.out.println(temp[i].charAt(0) + ", flag_name의 값이 잘못됐습니다. (- dash로 시작 )");
					continue outer;
				}
				if (hs.containsKey(temp[i])) {
					String flagType = hs.get(temp[i]);
					if (flagType.charAt(0) == '-') {
						flagType = hs.get(flagType);
					}

					if (hsSet.contains(flagType)) {
						answer[k] = false;
						System.out.println("flag가 중복됩니다.");
						continue outer;
					}
					hsSet.add(flagType);

					if (flagType.equals("NULL")) {
					} else if (flagType.equals("NUMBER")) {
						i += 1;
						for (int j = 0; j < temp[i].length(); j++) {
							if (temp[i].charAt(j) < '0' || temp[i].charAt(j) > '9') {
								answer[k] = false;
								System.out.println("0~9 숫자로만 이루어져야합니다.");
								continue outer;
							}
						}
					} else if (flagType.equals("NUMBERS")) {
						while (true) {
							i += 1;
							for (int j = 0; j < temp[i].length(); j++) {
								if (temp[i].charAt(j) < '0' || temp[i].charAt(j) > '9') {
									answer[k] = false;
									System.out.println("0~9 숫자로만 이루어져야합니다.");
									continue outer;
								}
							}
							if (temp[i + 1].charAt(0) == '-') {
								break;
							}
						}
					} else if (flagType.equals("STRING")) {
						i += 1;
						for (int j = 0; j < temp[i].length(); j++) {
							if (Character.toLowerCase(temp[i].charAt(j)) < 'a'
									|| Character.toLowerCase(temp[i].charAt(j)) > 'z') {
								answer[k] = false;
								System.out.println("알파벳 대소문잘로만 이루어져있어야합니다.");
								continue outer;
							}
						}
					} else if (flagType.equals("STRINGS")) {
						while (true) {
							i += 1;
							for (int j = 0; j < temp[i].length(); j++) {
								if (Character.toLowerCase(temp[i].charAt(j)) < 'a'
										|| Character.toLowerCase(temp[i].charAt(j)) > 'z') {
									answer[k] = false;
									System.out.println("알파벳 대소문잘로만 이루어져있어야합니다.");
									continue outer;
								}
							}
							if (temp[i + 1].charAt(0) == '-') {
								break;
							}
						}
					}
				} else {
					answer[k] = false;
					System.out.println("매칭되는 flag_rules가 없습니다.");
					continue outer;
				}
			}

		}

		return answer;
	}
}
