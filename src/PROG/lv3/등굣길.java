class Solution {
    public int solution(int m, int n, int[][] puddles) {
    	int map[][] = new int[n+1][m+1];
    	for(int i=0; i<puddles.length; i++) {
    		map[puddles[i][1]][puddles[i][0]] = -1;
    	}

    	map[1][1] = 1;
    	
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=m; j++) {
    			if(map[i][j] == -1) {
    				map[i][j] = 0;
                    continue;
    			}
    			if(map[i][j] == 0) {
    				map[i][j] = (map[i-1][j]+map[i][j-1])%1000000007;
    			}
    		}
    	}
        return map[n][m];
    }
}