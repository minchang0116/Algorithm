package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼국지 {
	static int N;
	static int team[][], soldier[][], supportSoldier[][];
	static boolean remainTeam[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			team= new int[N][N];
			soldier= new int[N][N];
			supportSoldier= new int[N][N];
			remainTeam= new boolean[4];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					team[i][j] = Integer.parseInt(st.nextToken());
					remainTeam[team[i][j]] = true;
				}
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					soldier[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					supportSoldier[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve();
			
			int answer =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer += soldier[i][j];
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}

	private static void solve() {
		int copySoldier[][] = new int[N][N];
		int copyTeam[][] = new int[N][N];
		int turn = 0;

		while (true) {
			while(true) {
				turn =(turn+ 1) %4;
				if(remainTeam[turn] == true && turn !=0) {
					break;
				}
			}
			for (int i = 0; i < N; i++) {
				copySoldier[i] = soldier[i].clone();
				copyTeam[i] = team[i].clone();
			}
			// 공격
			attack(copySoldier, copyTeam, turn);

			for (int i = 0; i < N; i++) {
				copySoldier[i] = soldier[i].clone();
			}
			// 지원
			support(copySoldier, turn);
			// 전군 보충
			allSupport();

			remainTeam = new boolean[4];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					remainTeam[team[i][j]] = true;
				}
			}
			int cnt =0;
			for(int i=1; i<=3; i++) {
				if(remainTeam[i] == true) {
					cnt++;
				}
			}
			if(cnt <= 1) {
				break;
			}
		}

	}

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	private static void attack(int[][] copySoldier, int[][] copyTeam, int turn) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyTeam[i][j] == turn || copyTeam[i][j] == 0) { // 자기팀이거나 산악지역이면 컨티뉴
					continue;
				}
				int sum = 0;
				// 4방향 탐색하여
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
						continue;
					}
					if (copyTeam[nx][ny] == turn) {
						sum += copySoldier[nx][ny];
					}
				}

				if (soldier[i][j] * 5 < sum) {
					int value = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
							continue;
						}
						if (copyTeam[nx][ny] == turn) {
							value += copySoldier[nx][ny] / 4;
							soldier[nx][ny] -= copySoldier[nx][ny] / 4;
						}
					}
					soldier[i][j] = value - copySoldier[i][j];
					team[i][j] = turn;
				}
			}
		}
	}

	private static void support(int[][] copySoldier, int turn) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (team[i][j] != turn)
					continue;

				boolean enermy = false;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || team[nx][ny] == 0) {
						continue;
					}
					// 주변에 적이 있으면
					if (team[nx][ny] != turn) {
						enermy = true;
					}
				}
				
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || team[nx][ny] != turn) {
						continue;
					}
					// 적이 있고 5배가 넘으면
					if (enermy == true) {
						if (team[nx][ny] == turn && copySoldier[nx][ny] * 5 < copySoldier[i][j]) {
							soldier[nx][ny] += copySoldier[i][j] / 5;
							soldier[i][j] -= copySoldier[i][j] / 5;
						}
					}
					else {
						soldier[nx][ny] += copySoldier[i][j] /5;
						soldier[i][j] -= copySoldier[i][j]/5;
					}
				}
			}
		}

	}

	private static void allSupport() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				soldier[i][j] += supportSoldier[i][j];
			}
		}
	}
}
