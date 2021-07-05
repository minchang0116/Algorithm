package lineTest;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		Solution service = new Solution();
		System.out.println(service.solution(new String[] {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, new String[] {"PYTHON", "C++", "SQL"}, new int[] {7, 5, 5}));
	}
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        hs.put("CONTENTS", 0);
        hs.put("GAME", 1);
        hs.put("HARDWARE", 2);
        hs.put("PORTAL", 3);
        hs.put("SI", 4);
        
        for(int i=0; i< languages.length; i++) {
        	hs.put(languages[i], preference[i]);
        }
        
        
        Jobs jobs[] = new Jobs[5];
    	jobs[0] = new Jobs("CONTENTS", 0);
    	jobs[1] = new Jobs("GAME", 0);
    	jobs[2] = new Jobs("HARDWARE", 0);
    	jobs[3] = new Jobs("PORTAL", 0);
    	jobs[4] = new Jobs("SI", 0);
    	
        for(int i=0; i<table.length; i++) {
        	String temp[] = table[i].split(" ");
        	for(int j=1; j<temp.length; j++) {
        		if(hs.containsKey(temp[j])) {
        			jobs[hs.get(temp[0])].score += (hs.get(temp[j]) * (6-j));
        		}
        	}
        }
        
        int max = 0;
        for(int i=0; i<jobs.length; i++) {
        	if(max<jobs[i].score) {
        		max = jobs[i].score;
        		answer=jobs[i].job;
        	}
        }
        return answer;
    }
    static class Jobs {
    	String job;
    	int score;
		public Jobs(String job, int score) {
			this.job = job;
			this.score = score;
		}
    }
}
