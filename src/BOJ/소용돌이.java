package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소용돌이 {
	static int r1, r2, c1, c2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		int[][] map = new int[r2 - r1 + 1][c2 - c1 + 1];
		
		// 오 위 왼 아
		int dx[] = { 0, -1, 0, 1 };
		int dy[] = { 1, 0, -1, 0 };
		
		int blockCnt = 0;
		int cnt = 1;
		int dir = 0;
		int dirSize = 1; 
		int dirCnt = 0;
		int changeSize = 0; // 2가 될때마다 dirSize 1증가
		
		int x = 0;
		int y = 0;
		int maxCnt = 0;
		while(true) {
			if(x >= r1 && x <= r2 && y >= c1 && y <= c2) {
				blockCnt++;
				map[x-r1][y-c1] = cnt;
				if(maxCnt < cnt) {
					maxCnt = cnt;
				}
			}
			
			x += dx[dir];
			y += dy[dir];
			
			if(blockCnt == (r2-r1+1) * (c2-c1+1)) {
				break;
			}
			
			cnt++;
			dirCnt ++;
			
			if(dirSize == dirCnt) {
				dir = (dir + 1) % 4;
				dirCnt =0;
				if(++changeSize == 2) {
					changeSize = 0;
					dirSize++;
				}
			} 
		}
		
		int formatSize = Integer.toString(maxCnt).length();
		for(int i=0; i<r2 - r1 + 1; i++) {
			for(int j=0; j<c2-c1+1; j++) {
				System.out.printf("%"+formatSize+"d ", map[i][j]);
			}
			System.out.println();
		}
	}
}
