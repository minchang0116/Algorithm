package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범 {
	
	static int map[][];
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// 맵 크기가  N일때 K는 7까지 봐야 전부 다 볼수 있고, K가 1부터 시작할때 맵을 전부 완탐해야됨, K값이 커질때 완탐해서 이득이 더 작거나 같으면 탐색할 필요없는듯?
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			for(int k=1; k<=N+1; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
							bfs(i,j,k);
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int result;
	static void bfs(int x, int y, int K) {
		int price = 0;
		for(int i=1; i<=K; i++) {
			price = (i-1)*(i-1) + (i*i);
		}
		boolean visited[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<int[]>();
		int sum = -price;
		int homeCnt=0;
		if(map[x][y] == 1) {
			homeCnt++;
			sum += M;
		}
		visited[x][y] =true;
		q.offer(new int[] {x,y});
		int cnt = 0;
		while(!q.isEmpty()) {
			if(cnt == K-1) {
				break;
			}
			cnt++;
			int qSize = q.size();
			for(int qs = 0; qs<qSize; qs++) {
				int xy[] = q.poll();
				for(int d=0; d<4; d++) {
					int nx= xy[0] + dx[d];
					int ny= xy[1] + dy[d];
					
					if(nx <0 || nx >= N || ny<0 || ny>=N || visited[nx][ny] == true) {
						continue;
					}
					if(map[nx][ny] == 1) {
						homeCnt++;
						sum += M;
					}
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		if(sum >= 0) {
			result = Math.max(homeCnt, result);
		}
		
	}
}
