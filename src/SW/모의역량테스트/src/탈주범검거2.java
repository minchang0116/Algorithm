package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거2 {
	static int N,M,R,C,L;
	static int map[][];
	static boolean check[][];
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			check = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer =0;
			solve();
			System.out.println("#"+test_case+" "+ answer);
		}
	}
	static int dx[] = {-1,1,0,0}; //  상 하 좌 우
	static int dy[] = {0,0,-1,1};
	private static void solve() {
		Queue<int []> q = new LinkedList<int[]>();
		q.offer(new int[]{R,C});
		check[R][C] =true;
		int time = 0;
		answer++;
		while(!q.isEmpty()){
			time++;
			if(time == L) {
				break;
			}
			int qSize = q.size();
			for(int qs=0; qs<qSize; qs++) {
				int xy[] = q.poll();
				for(int d=0; d<4; d++) {
					int nx = xy[0]+dx[d];
					int ny = xy[1]+dy[d];
					if(nx< 0 || nx >= N || ny<0 || ny>=M) continue;
					
					if(map[xy[0]][xy[1]] == 2) { // 상하
						if(d== 2 || d==3) continue;
					}
					else if(map[xy[0]][xy[1]] == 3) { // 좌우
						if(d== 0 || d==1) continue;
					}
					else if(map[xy[0]][xy[1]] == 4) { 
						if(d==1|| d==2) continue;
					}
					else if(map[xy[0]][xy[1]] == 5) { 
						if(d== 0 || d==2) continue;
					}
					else if(map[xy[0]][xy[1]] == 6) { 
						if(d== 0 || d== 3) continue;
					}
					else if(map[xy[0]][xy[1]] == 7) { 
						if(d== 1 || d==3) continue;
					}
					
					if(map[nx][ny] == 0) {
						continue;
					}
					else if (map[nx][ny] == 2) { // 상하
						if(d== 2 || d==3) continue;
					}
					else if(map[nx][ny] == 3) { // 좌우
						if(d== 0 || d==1) continue;
					}
					else if(map[nx][ny]  == 4) { 
						if(d==0|| d==3) continue;
					}
					else if(map[nx][ny]  == 5) { 
						if(d== 1 || d==3) continue;
					}
					else if(map[nx][ny]  == 6) { 
						if(d== 1 || d== 2) continue;
					}
					else if(map[nx][ny]  == 7) { 
						if(d== 0 || d==2) continue;
					}
					
					if(check[nx][ny] == false) {
						check[nx][ny] = true;
						answer++;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			
		}
	}
}
