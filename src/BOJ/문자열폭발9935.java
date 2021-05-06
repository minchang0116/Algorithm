package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열폭발9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String boom = br.readLine();
		char[] result = new char[s.length()];
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			result[idx] = s.charAt(i);
			if(isBoom(idx, boom, result))
				idx -= boom.length();
			idx++;
		}
		String answer = String.valueOf(result, 0, idx);
		if(idx == 0) {
			System.out.println("FRULA");
		}else {
			System.out.println(answer);
		}
	}

	private static boolean isBoom(int idx, String boom, char[] result) {
		if (idx < boom.length()-1)
			return false;
		for(int i=0; i<boom.length(); i++) {
			if(boom.charAt(i) != result[idx-(boom.length()-1)+i]) {
				return false;
			}
		}
		return true;
	}
}
