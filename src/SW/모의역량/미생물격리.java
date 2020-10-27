package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 미생물격리 {
	static int N, M, K;
	static List<Bug> bugs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			bugs = new ArrayList<Bug>();
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				switch(dir) {
					case 1: // 상
						dir = 2;
						break;
					case 2: // 하
						dir = 0;
						break;
					case 3: // 좌
						dir = 3;
						break;
					case 4: // 우
						dir = 1;
						break;
				}
				bugs.add(new Bug(r,c,cnt,dir));
			}
			
			solve();
			int result = 0;
			for(int i=0; i<bugs.size(); i++) {
				result += bugs.get(i).cnt;
			}
			System.out.println("#"+t+" "+ result);
		}
	}
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	private static void solve() {
		int time = 0;
		while(true) {
			time++;
			move();
			
			if(time == M) {
				return;
			}
		}
	}

	private static void move() {
		int size = bugs.size();
		for(int i=size-1; i>=0; i--) {
			Bug bug = bugs.get(i);
			bug.r += dx[bug.dir];
			bug.c += dy[bug.dir];
			
			if(bug.r == 0 || bug.r == N-1 || bug.c == 0 || bug.c == N-1) {
				if(bug.cnt == 1) { // 버그 소멸
					bugs.remove(i);
					continue;
				} 
				bug.dir = (bug.dir + 2) % 4; // 버그 방향 반대로
				bug.cnt = bug.cnt/2;
			}
		}
		check();
	}

	private static void check() { // 군집 체크
		Collections.sort(bugs);
		int size = bugs.size();
		for(int i=size-1; i>=0; i--) {
			Bug temp = bugs.get(i);
			for(int j=0; j<i; j++) {
				Bug temp2 = bugs.get(j);
				if(temp.r == temp2.r && temp.c == temp2.c) {
					temp2.cnt += temp.cnt;
					bugs.remove(i);
					break;
				}
			}
		}
	}

	private static class Bug implements Comparable<Bug>{
		int r;
		int c;
		int cnt;
		int dir;
		public Bug(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
		
		@Override
		public int compareTo(Bug o) {
			return Integer.compare(o.cnt, this.cnt); // cnt 기준 내림차순 정렬
		}
	}
}
