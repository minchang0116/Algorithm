package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와비바라기 {
	static int N, M;
	static int map[][];
	static boolean cloud[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		cloud = new boolean[N + 1][N + 1]; // 구름의 상태 정보
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		initCloud();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 1.
			moveCloud(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// 2.
			drawRain();
			// 3. 물복사
			copyWater();
			// 4. 구름 갱신
			refreshCloud();
		}

		System.out.println(sumWater());
	}

	private static int sumWater() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	private static void refreshCloud() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cloud[i][j] == true) {
					cloud[i][j] = false;
				} else if (map[i][j] >= 2) {
					cloud[i][j] = true;
					map[i][j] -=2;
				}
			}
		}
	}

	private static void copyWater() {
		int dx[] = { -1, -1, 1, 1 }; // 대각선 영역만 검사
		int dy[] = { -1, 1, 1, -1 };

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cloud[i][j] == true) {
					int sum = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 1 || nx > N || ny < 0 || ny > N)
							continue;
						if (map[nx][ny] > 0) // 물이 없었는데 더해져서 생기는 경우를 체크할 필요가 없다
							sum++;
					}
					map[i][j] += sum;
				}
			}
		}
	}

	private static void drawRain() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cloud[i][j] == true) {
					map[i][j]++;
				}
			}
		}
	}

	private static void moveCloud(int d, int s) {
		// 왼쪽부터 시계방향
		int dx[] = { 0,0, -1, -1, -1, 0, 1, 1, 1 };
		int dy[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

		boolean tempCloud[][] = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cloud[i][j] == true) {
					int nx = (i+dx[d]*s)%N;
					int ny = (j+dy[d]*s)%N;
					
					if(nx == 0) nx = N;
					else if(nx < 0 ) nx= N+nx;
					
					if(ny == 0) ny = N;
					else if(ny < 0) ny = N+ny;
					tempCloud[nx][ny] = true;
				}
			}
		}
		cloud = tempCloud;
	}

	private static void initCloud() {
		cloud[N][1] = true;
		cloud[N][2] = true;
		cloud[N - 1][1] = true;
		cloud[N - 1][2] = true;
	}
}
