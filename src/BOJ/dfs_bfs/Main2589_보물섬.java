package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589_보물섬 {
	static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static char map[][];
    static boolean visited[][];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {	
				map[i][j] = s.charAt(j);
			}
		}
		
		Queue<int []> q = new LinkedList<int[]>();
		int max=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L') {
					visited = new boolean[N][M];
					visited[i][j]= true;
					q.offer(new int[] {i,j});
					int dist = -1;
					while(!q.isEmpty()) {
						int qSize = q.size();
						dist++;
						for(int qsize =0; qsize<qSize; qsize++) {
							int xy[] = q.poll();
							for(int k=0; k<4; k++) {
								int nx = xy[0] + dx[k];
								int ny = xy[1] + dy[k];
								if(nx <0 || nx >=N || ny<0 || ny>=M || map[nx][ny] != 'L' ||visited[nx][ny] == true) continue;
								visited[nx][ny] =true;
								q.offer(new int[] {nx,ny});
							}
						}
					}
					if(max <dist) {
						max = dist;
					}
				}
			}
		}
		
		System.out.println(max);
		
	}
}
