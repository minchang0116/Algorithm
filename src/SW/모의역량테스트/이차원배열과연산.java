package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 이차원배열과연산 {
	static int r,c,k,rSize,cSize;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[101][101];
		for(int i=1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rSize= 3;
		cSize= 3;
		int answer =0;
		while(true) {
			if(map[r][c] == k || answer == 101) {
				break;
			}
			
			if(rSize>=cSize) { //행정렬
				rSort();
			}
			else { // 열정렬
				cSort();
			}
			
			answer++;
		}
		if(answer == 101) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}
	}
	private static void cSort() {
		int tempRSize=0;
		for(int i=1; i<=cSize; i++) {
			int check[] = new int[101];
			for(int j=1; j<=rSize; j++) {
				if(map[j][i] == 0) continue;
				check[map[j][i]]++;
			}
			List<Point> list = new ArrayList<Point>();
			for(int k=1; k<101; k++) {
				if(check[k] != 0) {
					list.add(new Point(k, check[k]));
				}
			}
			// 한 행이 끝나고 정렬
			Collections.sort(list);
			
			int x=1;
			int tempRRSize=0;
			for(int k=0; k<list.size(); k++) {
				map[x++][i] = list.get(k).num;
				map[x++][i] = list.get(k).cnt;
				tempRRSize+=2;
			}
			
			// 이거 안써서 틀렸음
			for(int k=x; k<=rSize; k++) {
				map[k][i] = 0;
			}
			tempRSize = Math.max(tempRRSize, tempRSize);
		}
		rSize= tempRSize;
	}
	private static void rSort() {
		int tempCSize=0;
		for(int i=1; i<=rSize; i++) {
			int check[] = new int[101];
			for(int j=1; j<=cSize; j++) {
				if(map[i][j] == 0) continue;
				check[map[i][j]]++;
			}
			List<Point> list = new ArrayList<Point>();
			for(int k=1; k<101; k++) {
				if(check[k] != 0) {
					list.add(new Point(k, check[k]));
				}
			}
			// 한 행이 끝나고 정렬
			Collections.sort(list);
			
			int y=1;
			int tempCCSize=0;
			for(int k=0; k<list.size(); k++) {
				map[i][y++] = list.get(k).num;
				map[i][y++] = list.get(k).cnt;
				tempCCSize+=2;
			}
			
			// 이거 안써서 틀렸었음
			for(int k=y; k<=cSize; k++) {
				map[i][k] = 0;
			}
			// 그 다음은 map 갱신
			tempCSize = Math.max(tempCCSize, tempCSize);
		}
		cSize= tempCSize;
		
	}
	
	static class Point implements Comparable<Point>{
		int num;
		int cnt;
		public Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			if(this.cnt == o.cnt) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.cnt, o.cnt);
		}
		
	}
}
