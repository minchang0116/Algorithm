package BOJ.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		outer: for(int i=0; i<T; i++) {
			String temp = br.readLine();
			Stack<Character> st = new Stack<Character>();
			for(int j=0; j<temp.length(); j++) {
				if(temp.charAt(j) == '(') {
					st.push(temp.charAt(j));
				}
				else if(temp.charAt(j) == ')') {
					if(st.isEmpty()) {
						System.out.println("NO");
						continue outer;
					}
					st.pop();
				}
			}
			if(!st.isEmpty()) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
	}
}
