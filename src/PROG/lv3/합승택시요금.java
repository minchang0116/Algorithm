package PROG.lv3;

public class 합승택시요금 {
	public static void main(String[] args) {
		합승택시요금 service = new 합승택시요금();
		System.out.println(service.solution(6, 4, 6, 2, new int[][] {{4, 1, 10},{3, 5, 24},{5, 6, 2}, {3, 1, 41}, {5, 1, 24},{ 4, 6, 50}, {2, 4, 66},{2, 3, 22},{1, 6, 25}}));
	}
	
    public int solution(int n, int s, int a, int b, int[][] fares) {
    	int map[][] = new int[n+1][n+1];
    	for(int i=0; i<fares.length; i++) {
    		// 택시요금
    		map[fares[i][0]][fares[i][1]] = fares[i][2];
    		map[fares[i][1]][fares[i][0]] = fares[i][2];
    	}
    	
    	for(int i=1; i<n+1; i++) {
    		for(int j=1; j<n+1; j++) {
    			if(map[i][j] == 0 && (i!=j)) {
    				map[i][j] = 1000000;
    			}
    		}
    	}
    	for(int k=1; k<n+1; k++) {
    		for(int i=1; i<n+1; i++) {
    			for(int j=1; j<n+1; j++) {
    				if(map[i][j] > map[i][k] + map[k][j] ) {
    					map[i][j] = map[i][k]+ map[k][j];
    				}
    			}
    		}
    	}
    	
    	int answer = Integer.MAX_VALUE;
    	for(int i=1; i<n+1; i++) {
    		int sum = map[s][i];
    		sum+= map[i][a];
    		sum+= map[i][b];
    		answer = Math.min(answer, sum);
    	}
        return answer;
    }
}
