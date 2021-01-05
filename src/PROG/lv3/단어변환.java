package PROG.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
	public static void main(String[] args) {
		단어변환 service = new 단어변환();
		System.out.println(service.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> q = new LinkedList<String>();
        
        return answer;
    }
}
