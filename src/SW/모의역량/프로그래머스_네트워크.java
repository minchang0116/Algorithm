package SW.모의역량;

// ♡
public class 프로그래머스_네트워크 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {{1,1,0,0,1},{1,1,0,0,1},{0,0,1,0,1},{0,0,1,0,1},{0,0,1,0,1}}));
	}
	
	static int parents[];
    public static int solution(int n, int[][] computers) {
    	parents = new int[n];
    	for(int i=0; i<n; i++) {
    		parents[i] = i;
    	}
    	for(int i=0; i<computers.length; i++) {
    		for(int j=0; j<computers[i].length && i!=j; j++) {
    			if(computers[i][j]== 1) {
    				union(i, j);
    			}
    		}
    	}
    	
        int answer = 0;
        for(int i=0; i<n; i++) {
        	if(parents[i] == i) {
        		answer++;
        	}
        }
        return answer;
    }

    static int find(int a) {
    	if(parents[a] == a) 
    		return a;
    	return parents[a] = find(parents[a]);
    }
    
    static void union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	if(rootA == rootB) return;
    	parents[rootB] = rootA;
    }
}
