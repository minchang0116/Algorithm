package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		outer: while(true) {
			String temp = br.readLine();
			Stack<Character> st = new Stack<Character>();
			//종료
			if(temp.charAt(0) == '.') {
				break;
			}
			for(int i=0; i<temp.length(); i++) {
				if(temp.charAt(i) == '(' || temp.charAt(i) == '['){
					st.push(temp.charAt(i));
				}
				else if(temp.charAt(i) == ')') {
					if(st.isEmpty() || st.peek() != '(') {
						System.out.println("no");
						continue outer;
					}
					else {
						st.pop();
					}
				}
				else if(temp.charAt(i) == ']') {
					if(st.isEmpty() || st.peek() != '[') {
						System.out.println("no");
						continue outer;
					}
					else {
						st.pop();
					}
				}
			}
			if(st.isEmpty()) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
