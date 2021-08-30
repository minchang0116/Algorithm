package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 핀볼게임3 {
	static int N;
	static int map[][];
	static ArrayList<Point> hall[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			hall = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				hall[i] = new ArrayList<Point>();
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6 && map[i][j] <= 10) {
						hall[map[i][j] - 6].add(new Point(i, j));
					}
				}
			}

			int sum = 0;
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							sum = solve(i, j, d);
							if (result < sum) {
								result = sum;
							}
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result);

		}
	}

	private static int solve(int sx, int sy, int dir) {
		int dx[] = new int[] { -1, 1, 0, 0 };
		int dy[] = new int[] { 0, 0, -1, 1 };
		int nx = sx;
		int ny = sy;
		int cdir = dir;
		int sum = 0;

		int block[][] = new int[][] { 
			{ 0, 0, 0, 0, 0 }, 
			{ 1, 3, 0, 2 }, 
			{ 3, 0, 1, 2 }, 
			{ 2, 0, 3, 1 }, 
			{ 1, 2, 3, 0 },
			{ 1, 0, 3, 2 } 
		};

		while (true) {
			nx = nx + dx[cdir];
			ny = ny + dy[cdir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				sum++;
				if (cdir <= 1) {
					cdir = (cdir + 1) % 2;
				} else {
					cdir = cdir + 1;
					if (cdir == 4) {
						cdir = 2;
					}
				}
				continue;
			} else if (map[nx][ny] >= 1 && map[nx][ny] <= 5) {
				sum++;
				cdir = block[map[nx][ny]][cdir];
				continue;
			} else if (map[nx][ny] >= 6 && map[nx][ny] <= 10) {
				for (int i = 0; i < 2; i++) {
					Point temp = hall[map[nx][ny] - 6].get(i);
					if (temp.x == nx && temp.y == ny) {
						continue;
					} else {
						nx = temp.x;
						ny = temp.y;
						break;
					}
				}
				continue;
			}

			if ((nx == sx && ny == sy) || (map[nx][ny] == -1)) {
				return sum;
			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
