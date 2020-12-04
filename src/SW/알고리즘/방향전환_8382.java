package SW.알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 방향전환_8382 {
	static int x1, x2, y1, y2;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 가로이동, 세로이동 
			StringTokenizer st  = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken())+100; // 열
			y1 = Integer.parseInt(st.nextToken())+100; // 행
			
			x2 = Integer.parseInt(st.nextToken())+100;
			y2 = Integer.parseInt(st.nextToken())+100;
			
			int answer = 0;
			
			boolean visited[][][] = new boolean[2][201][201];
			Queue<Point> q = new LinkedList<Point>();
			q.offer(new Point(x1, y1, 0, false, 0));
			q.offer(new Point(x1, y1, 0, true, 1));
			while(!q.isEmpty()) {
				Point temp = q.poll();
				if(temp.x == x2 && temp.y == y2) {
					answer = temp.depth;
					break;
				}
				
				if(!temp.dir) { // 가로
					for(int d=0; d<2; d++) {
						int nx = temp.x+dx[d];
						int ny = temp.y+dy[d];
						if(nx<0 || nx >200 || ny<0 || ny > 200) continue;
						if(visited[temp.type][nx][ny] == true) continue;
						visited[temp.type][nx][ny] = true;
						q.offer(new Point(nx,ny,temp.depth+1,!temp.dir, temp.type));
					}
				}else { //세로
					for(int d=2; d<4; d++) {
						int nx = temp.x+dx[d];
						int ny = temp.y+dy[d];
						if(nx<0 || nx>200 || ny<0 || ny > 200 ) continue;
						if(visited[temp.type][nx][ny] == true) continue;
						visited[temp.type][nx][ny] = true;
						q.offer(new Point(nx,ny,temp.depth+1,!temp.dir, temp.type));
					}
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
	
	private static class Point{
		int x;
		int y;
		int depth;
		boolean dir; // false 가로, true 세로
		int type; 
		public Point(int x, int y, int depth, boolean dir, int type) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.dir = dir;
			this.type = type;
		}
		
		
	}
}
