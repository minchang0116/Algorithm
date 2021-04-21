package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 미생물격리2 {
	static int N, M, K;
	static ArrayList<Bug> bug;
	static int dx[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			bug = new ArrayList<Bug>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				bug.add(new Bug(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1));
			}

			for (int time = 1; time <= M; time++) {
				for (int i = bug.size() - 1; i >= 0; i--) {
					Bug curBug = bug.get(i);
					curBug.x += dx[curBug.dir];
					curBug.y += dy[curBug.dir];
					if(curBug.x <= 0 || curBug.x >= N-1 || curBug.y <=0 || curBug.y>=N-1) {
						curBug.cnt /= 2;
						if(curBug.dir < 2) {
							curBug.dir = (curBug.dir+1) %2;
						}
						else {
							curBug.dir = (curBug.dir+1) %2 + 2;
						}
						if(curBug.cnt == 0) {
							bug.remove(i);
						}
					}
				}
				Collections.sort(bug);
				for (int i = 0; i <= bug.size(); i++) {
					for(int j=bug.size()-1; j>=i+1; j--) {
						if(bug.get(i).x == bug.get(j).x && bug.get(i).y == bug.get(j).y) {
							bug.get(i).cnt += bug.get(j).cnt;
							bug.remove(j);
						}
					}
				}
			}
			int answer =0;
			for(int i=0; i<bug.size(); i++) {
				answer += bug.get(i).cnt;
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static class Bug implements Comparable<Bug> {
		int x;
		int y;
		int cnt;
		int dir;

		public Bug(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
				
		@Override
		public int compareTo(Bug o) { // 내림차순으로
			return Integer.compare(o.cnt, this.cnt);
		}
	}
}
