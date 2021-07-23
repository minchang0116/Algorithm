package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();

		kmp(S, P);
	}

	private static void kmp(String origin, String pattern) {
		int pi[] = getPi(pattern);
		int idx=0;
		int originLength = origin.length();
		for(int i=0; i<originLength; i++) {
			while(idx>0 && origin.charAt(i) != pattern.charAt(idx)) {
				idx = pi[idx-1];
			}
			if(origin.charAt(i)==pattern.charAt(idx)) {
				if(idx== pattern.length()-1) {
					System.out.println(1);
					return;
				}
				else {
					idx++;
				}
			}
		}
		System.out.println(0);
	}

	private static int[] getPi(String pattern) {
		int patternLength = pattern.length();
		int pi[] = new int[patternLength];
		int idx=0;
		for(int i=1; i<patternLength; i++) {
			while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = pi[idx-1];
			}
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				pi[i] = ++idx;
			}
		}
		return pi;
	}
}
