package PROG.lv2;

import java.util.Stack;

public class 괄호회전하기 {
	public static void main(String[] args) {
		System.out.println(new 괄호회전하기().solution("}]()[{"));
	}
	
    public int solution(String s) {
    	int answer = 0;
    	StringBuilder sb = new StringBuilder(s);
    	for(int i=0; i<s.length(); i++) {
    		sb.append(sb.charAt(0));
    		sb.deleteCharAt(0);
    		if(check(sb)) {
    			answer++;
    		}
    	}
        
        return answer;
    }

	private boolean check(StringBuilder sb) {
		if(sb.length() == 1) {
			return false;
		}
		
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == '(' ||
					sb.charAt(i) == '[' || 
					sb.charAt(i) == '{' ){
				st.push(sb.charAt(i));
			}
			else {
				if(!st.isEmpty()) {
					if(sb.charAt(i) == ')') {
						if(st.peek() == '(') {
							st.pop();
						}
						else {
							return false;
						}
					}
					else if(sb.charAt(i) == '}') {
						if(st.peek() == '{') {
							st.pop();
						}
						else {
							return false;
						}
					}
					else if(sb.charAt(i) == ']') {
						if(st.peek() == '[') {
							st.pop();
						}
						else {
							return false;
						}
					}
				}
				else {
					return false;
				}
			}
		}
		
		if(!st.isEmpty()) {
			return false;
		}
		return true;
	}

}
