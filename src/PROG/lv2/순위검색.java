package PROG.lv2;

import java.util.Arrays;
import java.util.HashSet;

public class 순위검색 {
	public static void main(String[] args) {
		순위검색 service = new 순위검색();
	}
	
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        HashSet<String> hs = new HashSet<String>();
        for(int i=0; i<info.length; i++) {
        	String temp[] = info[i].split(" ");
        	
        	switch(temp[0]) {
        	case "cpp":
        		
        		break;
        	case "java":
        		break;
        	case "python":
        		break;
        	}
        }
        
        return answer;
    }
}
