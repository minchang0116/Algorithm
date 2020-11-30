package PROG.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그_등굣길 {
	public static void main(String[] args) {
		System.out.println(solution(4,3, new int[][] {{2,2}}));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int map[][] = new int[m+1][n+1];
		for(int i=0; i<puddles.length; i++) {
			map[puddles[i][0]][puddles[i][1]] = -1; // 물은 -1
		}
		int answer = 0;
		
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(1,1));
		map[m][n] = 1;
		int minDistance = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Point temp = q.poll();
			int tempDistance = m- temp.x + n - temp.y;
			if(tempDistance <= minDistance) {
				minDistance = tempDistance;
			}
			else {
				continue;
			}
			
			for(int d=0; d<2; d++) {
				int nx = temp.x + dx[d];
				int ny = temp.y + dy[d];
				if(nx == m && ny == n) {
					answer = (answer+1)%1000000007;
					continue;
				}
				
				if(nx < 1 || nx >=m+1 || ny<1 || ny>= n+1 || map[nx][ny] == -1 ) continue; // 벽나가거나 물이거나 다음갈 위치가 0이 아니고
				q.offer(new Point(nx,ny));
			}
		}
		
        return answer;
    }
	
	static int dx[] = {1,0};
	static int dy[] = {0,1};
	private static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
