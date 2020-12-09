package PROG.lv3;


public class 유정_등굣길 {

	static int MIN;
	static int M, N;
	static int count = 0;
	static int[][] map;
	public static int solution(int m, int n, int[][] puddles) {
		map = new int[n+1][m+1];
		MIN = m+n-1;
		M = m;
		N = n;
//		Puddles = puddles;
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1]][puddles[i][0]] = 1;
		}
		int jIdx=m;
		for(int i=n; i>=1; i--) {
			boolean flag=false;
			for(int j=jIdx; j>=1; j--) {
				if(flag == false && map[i][j] == 1 ) {
					flag= true;
					jIdx = j+1;
				}
				if(flag==true) {
					map[i][j] = 1;
				}
			}
			if(flag==false) {
				break;
			}
		}
		
		int iIdx =n;
		for(int j=m; j>=1; j--) {
			boolean flag=false;
			for(int i=iIdx; i>=1; i--) {
				if(flag == false && map[i][j] == 1 ) {
					flag= true;
					iIdx = i+1;
				}
				if(flag==true) {
					map[i][j] = 1;
				}
			}
			if(flag==false) {
				break;
			}
		}
		
		
		dfs(1, 1, 1);
		
        return count;
    }
	
	static int[][] dir = { {0, 1}, {1, 0} };
	
	public static void dfs(int x, int y, int len) {
		if(x == N && y == M) {
			count = (count+1) % 1000000007;
			return;
		}
		
		int nx, ny;
		for (int d = 0; d < 2; d++) {
			nx = x + dir[d][0];
			ny = y + dir[d][1];
			
			if(nx>=1 && ny>=1 && nx <= N && ny <= M && map[nx][ny] != 1) {
				dfs(nx, ny, len+1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(solution(4,3,new int[][] {{2,2}}));
		
		
	} // main


}
