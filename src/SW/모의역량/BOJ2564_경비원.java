package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2564_경비원 {
	static int map[][];
	static boolean visited[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken())+1;
		int N = Integer.parseInt(st.nextToken())+1;
		map = new int[N][M];
		visited = new boolean[N][M];
		int storeCnt = Integer.parseInt(br.readLine());
		for (int i = 1; i <= storeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int tempDir = Integer.parseInt(st.nextToken());
			if (tempDir == 1) {	// 북
				map[0][Integer.parseInt(st.nextToken())] = i;
			} else if (tempDir == 2) {	//남
				map[N-1][Integer.parseInt(st.nextToken())] = i;
			} else if (tempDir == 3) {	//서
				map[Integer.parseInt(st.nextToken())][0] = i;
			} else if (tempDir == 4) {	//동
				map[Integer.parseInt(st.nextToken())][M-1] = i;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int position = Integer.parseInt(st.nextToken());
		int x=0;
		int y=0;
		if(dir == 1) { // 북
			x = 0;
			y= position;
		}else if(dir == 2) { //남
			x = N-1;
			y= position;
		}else if(dir == 3) {
			x= position;
			y = 0;
		}else if(dir == 4) {
			x= position;
			y = M-1;
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x, y});
		visited[x][y] =true;
		int depth =0;
		int result=0;
		int resultCnt=0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			depth++;
			for(int qsize = 0; qsize<qSize; qsize++) {
				int xy[] = q.poll();
				int cx = xy[0];
				int cy = xy[1];
				for(int d=0; d<4; d++) {
					int nx = cx+dx[d];
					int ny = cy+dy[d];
					if(nx <0 || nx>=N || ny <0 || ny>=M || visited[nx][ny] == true) continue;
					if((nx>0 && nx <N-1) && (ny>0 && ny<M-1)) continue;
					
					if(map[nx][ny] != 0) {
						result+=depth;
						resultCnt++;
						if(resultCnt == storeCnt) {
							System.out.println(result);
							return;
						}
					}
					visited[nx][ny] =true;
					q.offer(new int [] {nx, ny});
				}
				
			}
		}

	}

}
