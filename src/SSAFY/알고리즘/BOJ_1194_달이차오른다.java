package SSAFY.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다 {
	
	static int N,M;
	static char map[][];
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][0b111111+1];
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		Point start = new Point();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '0') {
					start.x=i;
					start.y=j;
				}
			}
		}
		
		start.keys = 0;
		start.depth =1;
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int d=0; d<4; d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				int nk = cur.keys;
				if(nx <0 || nx >=N || ny<0 || ny>= M || map[nx][ny]=='#' || visited[nx][ny][nk] == true ) continue;
				if(map[nx][ny] == '1') {
					System.out.println(cur.depth);
					return;
				}
				if(map[nx][ny] <= 'Z' && map[nx][ny] >='A') { // 문일때 키가 있어야함
					if((cur.keys & 1 << map[nx][ny] -'A') == 0) {
						continue;
					}
				}
				if(map[nx][ny] <= 'z' && map[nx][ny] >= 'a') {
					nk = cur.keys | 1 << (map[nx][ny] -'a');
				}
				
				visited[nx][ny][nk] = true;
				q.offer(new Point(nx,ny,cur.depth+1, nk));
				
			}
		}
		
		System.out.println(-1);
		
		
	}
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	private static class Point{
		int x;
		int y;
		int depth;
		int keys;
		
		public Point() {
		}

		public Point(int x, int y, int depth, int keys) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.keys = keys;
		}
	}
}
