package 프로그.그리디;

import java.util.HashMap;

public class 완주하지못한순서 {
	public static void main(String[] args) {
		완주하지못한순서 service = new 완주하지못한순서();
		System.out.println(service.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
	}
    public String solution(String[] participant, String[] completion) {
    	HashMap<String, Integer> hs = new HashMap<String, Integer>();
    	for(int i=0; i<completion.length; i++) {
    		if(hs.containsKey(completion[i])) {
    			hs.put(completion[i], hs.get(completion[i])+1);
    		}
    		else {
    			hs.put(completion[i], 1);
    		}
    	}
    	
    	String answer = "";
    	for(int i=0; i<participant.length; i++) {
    		if(hs.containsKey(participant[i])) {
    			if(hs.get(participant[i]) <= 0) {
    				answer = participant[i];
    				break;
    			}
    			else {
    				hs.put(participant[i], hs.get(participant[i]) -1);
    			}
    		}
    		else {
    			answer = participant[i];
    			break;
    		}
    	}
        return answer;
    }
}
