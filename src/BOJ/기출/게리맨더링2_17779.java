package BOJ.기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 게리맨더링2_17779 {


	static int N;
	static int map[][];
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];
		answer = Integer.MAX_VALUE;
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(check(i,j,1,1)) {
					dfs(i, j, 1, 1);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean check(int x, int y, int d1, int d2) {
		if(y-d1 >= 1 && x+d1+d2 <= N && y+d2 <= N) {
			return true;
		}
		return false;
	}

	private static void dfs(int x, int y, int d1, int d2) {
		int election[][] = new int[N+1][N+1];
		//경계선 나누고 
		devide(election, x, y, d1, d2);
		
		// 계산
		calculate(election,x,y, d1, d2);
		
		if(check(x, y, d1+1, d2)) {
			dfs(x, y, d1+1, d2);
		}
		
		if(check(x,y,d1, d2+1)) {
			dfs(x, y, d1, d2+1);
		}
	}
	
	private static void devide(int[][] election, int x, int y, int d1, int d2) {
		//  경계선 그리기
		for(int i=0; i<=d1; i++) {
			election[x+i][y-i] = 5;
		}
		for(int i=0; i<=d2; i++) {
			election[x+i][y+i] = 5;
		}
		for(int i=0; i<=d2; i++) {
			election[x+d1+i][y-d1+i] = 5;
		}
		for(int i=0; i<=d1; i++) {
			election[x+d2+i][y+d2-i] = 5;
		}
		
		if(d2==1) {
			for(int i=1; i<=d1; i++) {
				fill(x+i, y-i+1, election); // 경계선 안 5로 채우기
			}
		}
		else if(d1 == 1) {
			for(int i=1; i<=d2; i++) {
				fill(x+i, y+i-1, election); // 경계선 안 5로 채우기
			}
		}
		else {
			fill(x+1,y,election);
		}
	}

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	private static void fill(int x, int y, int[][] election) {
		election[x][y] = 5;
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(election[nx][ny] !=5) {
				fill(nx,ny, election);
			}
		}
	}

	private static void calculate(int[][] election, int x, int y, int d1, int d2) {
		int arr[] = new int[6];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(election[i][j] == 5) {
					arr[5] += map[i][j];
				}
				else if(i<x+d1 && j<=y) {
					arr[1] += map[i][j];
				}
				else if(i<=x+d2 && y<j) {
					arr[2] += map[i][j];
				}
				else if(x+d1 <= i && j<y-d1+d2) {
					arr[3] += map[i][j];
				}
				else if(x+d2 < i && y-d1+d2<= j) {
					arr[4] += map[i][j];
				}
			}
		}
		
		int max =0;
		int min =Integer.MAX_VALUE;
		for(int i=1; i<6; i++) {
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
		}
		answer = Math.min(answer, max-min);
	}

}
