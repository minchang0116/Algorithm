package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브_15685 {
	
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 }; // 오 위 왼 아
	static int map[][] = new int[150][150];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			solve(r, c, d, g);
			
		}
		check();
		System.out.println(result);
	}
	static int result=0;
	private static void check() {
		for(int i=0; i<150; i++) {
			for(int j=0; j<150; j++) {
				if(map[i][j] != 0) {
					if(map[i][j+1] != 0) {
						if(map[i+1][j] != 0) {
							if(map[i+1][j+1] != 0) {
								result++;
							}
						}
					}
				}
			}
		}
		
	}
	private static void solve(int r, int c, int d, int g) {
		List<Integer> list = new ArrayList<Integer>();
		int gIdx=1; // 0세대가 1
		map[r][c]= gIdx; 
		list.add(d);
		
		int endX = r+dx[d];
		int endY = c+dy[d];
		map[endX][endY]= gIdx;
		gIdx++;
		while(gIdx <= g+1) { // gIdx는 0세대가 1이니깐 g세대에 +1 
			int listSize = list.size();
			for(int i=listSize-1; i>=0; i--) {
				int dir = list.get(i) + 1; // 반시계로 90도
				if(dir == 4) dir = 0;
				endX += dx[dir];
				endY += dy[dir];
				map[endX][endY] = gIdx;
				list.add(dir);
			}
			gIdx++;
		}
	}
}
