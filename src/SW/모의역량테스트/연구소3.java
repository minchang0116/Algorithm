package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3 {
	static int map[][];
	static int N, M;
	static Virus virus[];
	static int virusCnt,moveCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virus = new Virus[11];
		moveCnt = 0; // 총 이동해야되는 횟수
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 2) {
					virus[virusCnt++] = new Virus(i, j);
					map[i][j] = -2; // 바이러스
				}
				else if(temp == 1){
					map[i][j] = -1; // 벽
				}
				else {
					map[i][j] = temp; 
					moveCnt++;
				}
			}
		}
		answer=Integer.MAX_VALUE;
		numbers = new int[virusCnt];
		combi(0, 0);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		
	}
	static int answer;
	static int numbers[];
	static void combi(int cnt, int idx) {
		if(cnt == M) {
			solve();
			return;
		}
		
		for(int i=idx; i<virusCnt; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	
	
	private static void solve() {
		int tempMap[][] = new int[N][];
		boolean visited[][] = new boolean[N][N];
		for(int i=0; i<N; i++) {
			tempMap[i] = map[i].clone();
		}
		
		Queue<int []> q = new LinkedList<int[]>();
		for(int i=0; i<M; i++) {
			visited[virus[numbers[i]].x][virus[numbers[i]].y] = true;
			q.offer(new int[] {virus[numbers[i]].x,virus[numbers[i]].y});
		}
		
		int time = 0;
		int move = 0;
		while(!q.isEmpty()) {
			time++;
			if(time > answer) {
				break;
			}
			if(moveCnt <= move) break;
			int qSize = q.size();
			for(int qs=0; qs<qSize; qs++) {
				int xy[] = q.poll();
				for(int d=0; d<4; d++) {
					int nx = xy[0] + dx[d];
					int ny = xy[1] + dy[d];
					if(nx <0 || nx>=N || ny<0 || ny>=N || tempMap[nx][ny] == -1 || visited[nx][ny] == true) continue;
					visited[nx][ny] = true;
					if(tempMap[nx][ny] == 0) 
						move++;
					tempMap[nx][ny] = time;
					q.offer(new int[] {nx,ny});
				}
			}
		
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tempMap[i][j] == 0) {
					return;
				}
			}
		}
		answer = Math.min(answer, time-1);
	}

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0, 1,-1};
	private static class Virus{
		int x;
		int y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
