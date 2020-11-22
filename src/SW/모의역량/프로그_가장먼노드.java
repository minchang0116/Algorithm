package SW.모의역량;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 프로그_가장먼노드 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
	}
	
    public static int solution(int n, int[][] edge) {
    	ArrayList<Integer> vertex[] = new ArrayList[n+1];
    	for(int i=1; i<n+1; i++) {
    		vertex[i] = new ArrayList<Integer>();
    	}
    	for(int i=0; i<edge.length; i++) {
    		vertex[edge[i][0]].add(edge[i][1]);
    		vertex[edge[i][1]].add(edge[i][0]);
    	}
    	
    	int check[] = new int[n+1];
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(1);
    	check[1] = 1;
    	int depth=1;
    	while(!q.isEmpty()) {
    		depth++;
    		int qSize = q.size();
    		for(int qs=0; qs<qSize; qs++) {
    			int s = q.poll();
    			for(int i=0; i<vertex[s].size(); i++) {
    				if(check[vertex[s].get(i)] == 0) {
    					q.add(vertex[s].get(i));
    					check[vertex[s].get(i)] = depth;
    				}
    			}
    		}
    	}

    	
    	int answer = 0;
    	for(int i=1; i<n+1; i++) {
    		if(check[i] == depth-1) {
    			answer++;
    		}
    	}
        
        
        return answer;
    }
    
}
