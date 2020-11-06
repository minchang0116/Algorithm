package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {
	static private class Point{
		int x;
		int y;
		int cctvType;
		public Point(int x, int y, int cctvType) {
			this.x = x;
			this.y = y;
			this.cctvType = cctvType;
		}
		
	}
	
	static int N, M;
	static List<Integer> type[];
	static List<Point> cctv;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cctv = new ArrayList<Point>();
		int map[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp >0 && temp <6) {
					cctv.add(new Point(i,j, temp));
				}
				map[i][j] = temp;
				
			}
		}
		
		type = new ArrayList[6];
		for(int i=0; i<6; i++) {
			type[i] = new ArrayList<Integer>();
		}
		type[1].add(1); // 오
		type[2].add(1); // 오, 왼
		type[2].add(3);  
		type[3].add(0); // 위 오
		type[3].add(1);
		type[4].add(3); // 왼 위 오
		type[4].add(0);
		type[4].add(1);
		type[5].add(3); // 왼 위 오 아
		type[5].add(0);
		type[5].add(1);
		type[5].add(2);
		
		result = Integer.MAX_VALUE;
		int copy[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			copy[i] = map[i].clone();
		}
		dfs(0, copy);
		check(map);
		System.out.println(result);
		/*
		 * 1번 오
		 * 2번 왼 오
		 * 3번 위 오 
		 * 4번 왼 위 오
		 * 5번 왼 위 오 아
		 * 
		 * cctv는 벽 통과 금지
		 * 
		 * */
	}
	
	static int result;
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	private static void dfs(int idx, int map[][]) {
		if(cctv.isEmpty()) {
			return;
		}
		if(idx == cctv.size()) {
			check(map);
			return;
		}
		int copy[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			copy[i] = map[i].clone();
		}
		
		Point temp = cctv.get(idx);
		int nx=0;
		int ny=0;
		int cctvType = temp.cctvType;
		for(int dir=0; dir<4; dir++) {
			for(int d=0; d<type[cctvType].size(); d++) {
				nx = temp.x;
				ny = temp.y;
				while(true) {
					nx = nx + dx[(type[cctvType].get(d)+dir) %4];
					ny = ny + dy[(type[cctvType].get(d)+dir) %4];
					if(nx <0 || nx >= N || ny <0 || ny>=M || copy[nx][ny] == 6) break; // 벽이거나 cctv면 나와
					if(copy[nx][ny] == 0) {
						copy[nx][ny] = 7; // 감시구역은 7
					}
				}
			}
			dfs(idx+1, copy);
			for(int i=0; i<N; i++) {
				copy[i] = map[i].clone();
			}
			
		}
		
	}
	private static void check(int map[][]) {
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					sum++;
				}
			}
		}
		result = Math.min(result, sum);
	}
}
