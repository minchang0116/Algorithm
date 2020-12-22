package PROG.lv3;

import java.util.ArrayList;
import java.util.HashSet;

public class 불량사용자 {
	public static void main(String[] args) {
		불량사용자 service = new 불량사용자();
		System.out.println(service.solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"*rodo","*rodo", "******"}));
	}

	ArrayList<String> list[];
	HashSet<String> hs;
	HashSet<String> hs2;
    public int solution(String[] user_id, String[] banned_id) {
        hs = new HashSet<String>();
        hs2 = new HashSet<String>();
        list = new ArrayList[banned_id.length];
        for(int i=0; i<banned_id.length; i++) {
        	list[i] = new ArrayList<String>();
        }
        
        for(int i=0; i<banned_id.length; i++) {
        	outer: for(int j=0; j<user_id.length; j++) {
        		if(user_id[j].length() != banned_id[i].length()) continue; // 길이 다르면 스킵
        		for(int k=0; k<banned_id[i].length(); k++) {
        			if(banned_id[i].charAt(k) != '*' && banned_id[i].charAt(k) != user_id[j].charAt(k)) { // *이 아니고 문자가 다르면
        				continue outer;
        			}
        		}
        		if(hs.contains(user_id[j])) {
        			hs2.add(user_id[j]);
        		}
        		hs.add(user_id[j]);
        		list[i].add(user_id[j]);
        	}
        }
        
        for(int i=0; i<list.length; i++) {
        	for(int j=list[i].size()-1; j>=0; j--) {
        		if(hs2.contains(list[i].get(j))){
        			list[i].remove(j);
        		}
        	}
        }
        
        for(int i=0; i<list.length; i++) {
    		answer = answer * (list[i].size() == 0 ? 1 : list[i].size());
        }
        return answer;
    }
    int answer = 1;
}