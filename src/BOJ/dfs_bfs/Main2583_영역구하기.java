package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2583_영역구하기 {
	static int map[][];
	static int M, N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken()) + 1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()) + 1;

			for (int i = M - y1; i > M - y2; i--) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = 1;
				}
			}

		}

		int cnt=0;
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					map[i][j] =1;
					list.add(dfs(i,j,1));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(Integer i : list) {
			System.out.print(i + " ");
		}

	}
	
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int dfs(int r,int c,int area) {
		for(int i=0; i<4; i++) {
			int nr= r+dx[i];
			int nc= c+dy[i];
			if(nr <0 || nr>=M || nc<0 || nc>=N || map[nr][nc] == 1) {
				continue;
			}
			map[nr][nc] = 1;
			area = dfs(nr,nc,area+1);
		}
		return area;
	}
}
