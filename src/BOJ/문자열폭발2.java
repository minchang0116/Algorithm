package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열폭발2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		
		int sLength = S.length();
		char result[] = new char[sLength];

		int idx = 0;
		for(int i=0; i<sLength; i++) {
			result[idx++] = S.charAt(i);
			if(isBoom(result,P,idx)) {
				idx -= P.length();
			}
		}
		if(idx == 0) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(new String(result, 0,idx));
		}
	}

	private static boolean isBoom(char[] result, String P, int idx) {
		if(idx-P.length() <0) {
			return false;
		}
		
		boolean flag = true;
		int pLength = P.length();
		for(int i=0; i<pLength; i++) {
			if(P.charAt(i) != result[idx-P.length()+i]) {
				flag = false;
			}
		}
		// 터트릴 수 있으면 true, 아니면 false
		return flag;
	}
}
