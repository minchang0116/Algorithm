package PROG.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
	public static void main(String[] args) {
		단어변환 service = new 단어변환();
		System.out.println(service.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<String>();
        boolean check[] = new boolean[words.length];
        int answer = 1;
        outer: for(int i=0; i<words.length; i++) {
        	boolean flag = false;
        	for(int j=0; j<begin.length(); j++) {
        		if(begin.charAt(j) != words[i].charAt(j)) {
        			if(flag == true) continue outer;
        			flag = true;
        		}
        	}
        	if(flag==true) { // 1개가 바껴있다면 
				if(words[i].equals(target)) { // 정답이랑 같다면??
					return answer;
				}
				check[i] = true;
				q.offer(words[i]);
			}
        }
        
        while(!q.isEmpty()) {
        	int qSize = q.size();
        	answer++;
        	for(int qs=0; qs<qSize; qs++) {
        		String cur = q.poll();
        		outer: for(int i=0; i<words.length; i++) {
        			if(check[i] == true) continue;
        			boolean flag = false;
        			for(int j=0; j<cur.length(); j++) {
        				if(cur.charAt(j) != words[i].charAt(j)) {
        					if(flag == true) continue outer;
        					flag = true;
        				}
        			}
        			if(flag==true) { // 1개가 바껴있다면 
        				if(words[i].equals(target)) { // 정답이랑 같다면??
        					return answer;
        				}
        				check[i] = true;
        				q.offer(words[i]);
        			}
        		}
        	}
        }
        
        return 0;
    }
}
