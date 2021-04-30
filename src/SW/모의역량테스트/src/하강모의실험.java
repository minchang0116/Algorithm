package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하강모의실험 {
	static int N;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve();
			int answer1 = 0;
			int answer2 = 0;
			for (int i = N - 1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						answer1++;
					}
				}
			}
			for (int j = N - 1; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 1) {
						answer2++;
					}
				}
			}
			System.out.println("#"+test_case+" "+answer1+" "+answer2);
		}
	}

	private static void solve() {
		outer: for (int j = 0; j < N; j++) {
			if (map[0][j] == 1) {
				double power= 1;
				int powerCnt = 0;
				int length = 1;
				for (int i = 1; i < N; i++) {
					power = length * Math.pow(1.9, powerCnt);
					if (map[i][j] == 0) {
						// 위에 꼬리를 길이 만큼 옮겨줌
						map[i][j] = 1;
						map[i - length][j] = 0;
					} else {
						if(i == N-1) continue outer;
						int weight = 1;
						int r = i;
						while (true) {
							r += 1;
							if (r >= N || map[r][j] == 0)
								break;
							weight++;
						}
						if (power > weight) {
							length += weight;
							i += weight - 1;
						}
						else {
							continue outer;
						}
					}
					powerCnt++;
				}
			}
		}

		outer: for (int i = 0; i < N; i++) {
			if (map[i][0] == 1) {
				double power= 1;
				int powerCnt = 0;
				int length = 1;
				for (int j = 1; j < N; j++) {
					power = length * Math.pow(1.9, powerCnt);
					if (map[i][j] == 0) {
						// 위에 꼬리를 길이 만큼 옮겨줌
						map[i][j] = 1;
						map[i][j - length] = 0;
					} else {
						if(j == N-1) continue outer;
						int weight = 1;
						int c = j;
						while (true) {
							c += 1;
							if (c >= N || map[i][c] == 0)
								break;
							weight++;
						}
						if (power > weight) {
							length += weight;
							j += weight - 1;
						}
						else {
							continue outer;
						}
					}
					powerCnt++;
				}
			}
		}
	}
}
