package PROG.lv2;

import java.util.HashMap;

public class 스킬트리 {
	public static void main(String[] args) {
		스킬트리 service = new 스킬트리();
		System.out.println(service.solution("CBD", new String[] {"BACDE", "CBADF", "AECB","BDA"}));
	}
    public int solution(String skill, String[] skill_trees) {
    	HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
    	for(int i=0; i<skill.length(); i++) {
    		hs.put(skill.charAt(i), i);
    	}
        int answer = 0;
        outer: for(int i=0; i<skill_trees.length; i++) {
        	int idx = 0;
        	for(int j=0; j<skill_trees[i].length(); j++) {
        		if(hs.containsKey(skill_trees[i].charAt(j))) {
        			if(idx != hs.get(skill_trees[i].charAt(j))) {
        				continue outer;
        			}
        			idx++;
        		}
        	}
        	answer++;
        }
        
        return answer;
    }
}
