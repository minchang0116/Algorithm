package PROG.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위검색 {
	public static void main(String[] args) {
		순위검색 service = new 순위검색();
		service.solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
	}
	static HashMap<String, List<Integer>> map = new HashMap<>();
	
    public int[] solution(String[] info, String[] query) {
    	int[] answer = new int[query.length];
        for(int i=0; i<info.length; i++) {
        	dfs("", info[i].split(" "), 0);
        }
        
        for(String key :map.keySet()) {
        	Collections.sort(map.get(key));
        }
        
        for(int i=0; i<query.length; i++) {
        	String temp[] = query[i].replace(" and ", "").split(" ");
        	int score = Integer.parseInt(temp[1]);
        	answer[i] = binarySearch(temp[0], score);
        	
        }
        return answer;
    }
    
    private int binarySearch(String string, int score) {
    	if(map.containsKey(string)) {
    		List<Integer> list = map.get(string);
    		int left = 0;
    		int right = list.size()-1;
    		if(list.get(right) < score) {
    			return 0;
    		}
    		
    		while(left<right) {
    			int mid = (left+right)/2;
    			if(list.get(mid) < score) {
    				left = mid+1;
    			}
    			else{
    				right = mid;
    			}
    		}
    		return list.size() - left;
    	}
    	return 0;
	}

	private void dfs(String s, String[] info, int depth) {
    	if(depth == 4) {
    		if(map.containsKey(s) == false) {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(Integer.parseInt(info[4]));
    			map.put(s, list);
    		}
    		else {
    			map.get(s).add(Integer.parseInt(info[4]));
    		}
    		return;
    	}
    	
    	dfs(s+"-", info, depth+1);
    	dfs(s+info[depth], info, depth+1);
    }
}
