package 프로그.그리디;

import java.util.Arrays;

public class 섬연결하기 {
	public static void main(String[] args) {
		섬연결하기 service = new 섬연결하기();
		System.out.println(service.solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
	}
	
	static int parents[];
    public int solution(int n, int[][] costs) {
    	Edge[] edges = new Edge[costs.length];
    	
    	parents = new int[n];
    	for(int i=0; i<n; i++) {
    		parents[i] = i;
    	}
    	
    	for(int i=0; i<costs.length; i++) {
    		int a = costs[i][0];
    		int b = costs[i][1];
    		int c = costs[i][2];
    		
    		edges[i] = new Edge(a,b,c);
    	}
    	
    	Arrays.sort(edges);
    	int cnt =0;
    	int answer = 0;
    	for(int i=0; i<edges.length; i++) {
    		if(cnt == n-1) {
    			break;
    		}
    		Edge edge = edges[i];
    		if(union(edge.a, edge.b)) {
    			// 부모가 다르면
    			cnt++;
    			answer += edge.cost;
    		}
    	}
    	
        return answer;
    }

    private boolean union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	if(rootA == rootB) {
    		//부모가 같으면 이미 연결되있다는 뜻
    		return false;
    	}
    	parents[rootB] = rootA;
    	return true;
	}
    
    private int find(int a) {
    	if(parents[a] == a) return a;
    	return parents[a] = find(parents[a]);
    }

	private class Edge implements Comparable<Edge>{
    	int a;
    	int b;
    	int cost;
    	
    	@Override
    	public int compareTo(Edge o) {
    		return Integer.compare(this.cost, o.cost);
    	}

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
    }
}
