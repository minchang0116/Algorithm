package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 괄호제거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Integer> st = new Stack<Integer>();
		int parenthesisIdx[][] = new int[10][2];
		int parenthesisCnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				st.add(i);
			}
			else if(s.charAt(i) == ')') {
				parenthesisIdx[parenthesisCnt][0] = st.pop();
				parenthesisIdx[parenthesisCnt++][1] = i;
			}
		}
		answer = new String[(int) (Math.pow(2, parenthesisCnt)-1)];
		answerCnt=-1;
		int check[] = new int[parenthesisCnt];
		dfs(0, check,parenthesisIdx, parenthesisCnt, s);
		Arrays.sort(answer);
		
		for(int i=0; i<answer.length; i++) {
			if(i != 0 && answer[i].equals(answer[i-1])) {
				continue;
			}
			System.out.println(answer[i]);
		}
	}
	
	static String answer[];
	static int answerCnt;
	private static void dfs(int i, int[] check, int[][] parenthesisIdx, int parenthesisCnt, String s) {
		if(i==parenthesisCnt) {
			if(answerCnt==-1) {
				answerCnt++;
				return;
			}
			StringBuilder sb = new StringBuilder();
			outer: for(int k=0; k<s.length(); k++) {
				for(int l=0; l<check.length; l++) {
					if(check[l] == 0) {
						if(parenthesisIdx[l][0] == k || parenthesisIdx[l][1] == k )
							continue outer;
					}
				}
				sb.append(s.charAt(k));
			}
			answer[answerCnt++] = sb.toString();
			return;
		}
		check[i] = 1;
		dfs(i+1, check, parenthesisIdx, parenthesisCnt, s);
		check[i] = 0;
		dfs(i+1, check, parenthesisIdx, parenthesisCnt, s);
		
	}
}
