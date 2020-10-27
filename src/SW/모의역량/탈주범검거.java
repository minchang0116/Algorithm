package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {

	static int N, M, R, C, L;
	static int map[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		type = new List[8]; // 각 케이스마다 방향 설정
		for(int i=1; i<=7; i++) {
			type[i] = new ArrayList<Integer>();
			switch(i) {
			case 1:
				type[i].add(0); //하 상 우 좌
				type[i].add(1);
				type[i].add(2);
				type[i].add(3);
				break;
			case 2:
				type[i].add(0); //하 상
				type[i].add(1);
				break;
			case 3:
				type[i].add(2); //우 좌
				type[i].add(3);
				break;
			case 4:
				type[i].add(1); //상 우
				type[i].add(2);
				break;
			case 5:
				type[i].add(0); //하 우
				type[i].add(2);
				break;
			case 6:
				type[i].add(0); //하 좌
				type[i].add(3);
				break;
			case 7:
				type[i].add(1); //상 좌
				type[i].add(3);
				break;
			}
		}
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 1;
			bfs();
			System.out.println("#"+t+" "+result);
		}
	}
	
	static int result;
	static int dx[] = {1,-1,0,0 }; // 하 상
	static int dy[] = {0,0,1,-1 };// 우 좌
	static List<Integer> type[];
	private static void bfs() {
		Queue<int []> q = new LinkedList<int[]>();
	
		visited[R][C] = true;
		q.offer(new int[]{R,C});
		int time=1;
		
		while(!q.isEmpty()) {
			if(time == L) {
				return;
			}
			time++;
			int qSize = q.size(); // 시간 단위로 움직이기 위해서
			for(int qs = 0; qs<qSize; qs++) {
				int xy[] = q.poll();
				int typeValue = map[xy[0]][xy[1]];
				int dSize = type[typeValue].size();
				outer: for(int d=0; d<dSize; d++) {
					int nx = xy[0] + dx[type[typeValue].get(d)];
					int ny = xy[1] + dy[type[typeValue].get(d)];
					if(nx <0 || nx >= N || ny <0 || ny>=M || visited[nx][ny] == true || map[nx][ny] == 0) continue;
					// 위로 갔으면 위 파이프는 반드시 아래가 있어야됨
					// 상일때 1,2,5,6
					// 하일때 1,2,4,7
					// 좌일때 1,3,4,5
					// 우일때 1,3,6,7
					if(type[typeValue].get(d) == 0) { // 하로 갔을때 
						switch(map[nx][ny]) {
						case 1: case 2: case 4: case 7:
							break;
						default:
							continue outer;
						}
					}
					else if(type[typeValue].get(d) == 1) { // 상일때
						switch(map[nx][ny]) {
						case 1: case 2: case 5: case 6:
							break;
						default:
							continue outer;
						}
					}
					
					else if(type[typeValue].get(d) == 2) { // 우일때
						switch(map[nx][ny]) {
						case 1: case 3: case 6: case 7:
							break;
						default:
							continue outer;
						}
					}
					else if(type[typeValue].get(d) == 3) { // 좌일때
						switch(map[nx][ny]) {
						case 1: case 3: case 4: case 5:
							break;
						default:
							continue outer;
						}
					}
					result++;
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
			
		}
	}

}
