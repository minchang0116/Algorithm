package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_BFS {

	static int N, M, adj[][];
	static int gtCnt, ltCnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			adj = new int[N+1][N+1];
			StringTokenizer st = null;
			
			int i,j;
			for(int m=0; m<M; m++) {
				st= new StringTokenizer(in.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}
			
			
			int answer = 0;
			for(int k=1; k<=N; k++) {
				gtCnt = ltCnt = 0;
				gtBFS(k);
				ltBFS(k);
				if(gtCnt + ltCnt == N-1) answer++;
			}
			System.out.println("#"+t+" "+answer);
			
			
		}
	}
	//자신보다 큰 학생 따라 탐색
	private static void gtBFS(int start) { // 탐색의 출발 학생번호
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for(int i=1; i<=N; i++) {
				if(adj[k][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					gtCnt++;
				}
			}
		}
	}

	
	//자신보다 작은 학생 따라 탐색
	private static void ltBFS(int start) { // 탐색의 출발 학생번호
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for(int i=1; i<=N; i++) {
				if(adj[i][k] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					ltCnt++;
				}
			}
		}
	}
	
	

}
