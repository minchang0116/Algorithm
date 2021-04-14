package PROG.lv2;

public class 문자열압축 {
	public static void main(String[] args) {
		문자열압축 service = new 문자열압축();
		System.out.println(service.solution("ababcdcdababcdcd"));
	}
    public int solution(String s) {
        int answer = 0;
        for(int i=1; i<s.length(); i++) {
        	StringBuilder sb = new StringBuilder();
        	int cnt = 1;
        	for(int j=0; j<s.length()/2; j=j+i) {
        		if(s.substring(j, j+i).equals(s.substring(j+i, j+(i+i)))) {
        			cnt++;
        			
        		}
        		else {
        			sb.append(cnt).append(s.substring(j, j+i));
        			cnt=1;
        		}
        	}
        	System.out.println(sb.toString());
        }
        
        return answer;
    }
}
