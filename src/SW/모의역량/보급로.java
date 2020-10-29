package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 보급로 {

	static int N;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for(int t=1; t<=T; t++) {
				N = Integer.parseInt(br.readLine());
				map = new int[N][N];
				
				for(int i=0; i<N; i++) {
					String s = br.readLine();
					for(int j=0; j<N; j++) {
						map[i][j] = s.charAt(j) - '0';
						
					}
				}
				
				visited = new boolean[N][N];
				visited[0][0] = true;
				result =Integer.MAX_VALUE;
				bfs();
				
				System.out.println("#"+t+" "+result);
			}
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int result;
	static boolean visited[][];
	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		visited[0][0] = true;
		pq.offer(new Point(0,0,0));
		while(!pq.isEmpty()) {
			Point temp = pq.poll();
			for(int d=0; d<4; d++) {
				int nx = temp.x+dx[d];
				int ny = temp.y+dy[d];
				if(nx <0 || nx >=N || ny <0 || ny >=N || visited[nx][ny] == true) {
					continue;
				}
				if(nx == N-1 && ny == N-1) {
					result = temp.sum;
					return;
				}
				
				visited[nx][ny] = true;
				pq.offer(new Point(nx,ny,temp.sum+map[nx][ny]));
			}
			
		}
		
	}
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int sum;
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.sum, o.sum);
		}
		public Point(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}
}
