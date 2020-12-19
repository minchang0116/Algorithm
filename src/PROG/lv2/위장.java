package PROG.lv2;

import java.util.HashMap;

public class 위장 {
	public static void main(String[] args) {
		위장 service = new 위장();
		System.out.println(service.solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "dsfsdf"}, {"green_turban", "sdf"}, {"green_turbanwe", "sdfsd"}}));
	}
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++) {
        	if(hs.containsKey(clothes[i][1])) {
        		hs.put(clothes[i][1], hs.get(clothes[i][1])+1);
        	}
        	else {
        		hs.put(clothes[i][1], 1);
        	}
        }
        
        for(String key:	hs.keySet()){
        	answer *= (hs.get(key)+1);
        };
        
        return answer-1;
    }
    
}
