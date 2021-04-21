package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보호필름3 {
	static int answer;
	static int D, W, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int film[][] = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;

			int originalFilm[][] = new int[D][];
			for (int i = 0; i < D; i++) {
				originalFilm[i] = film[i].clone();
			}

			dfs(0, 1, 0, film, originalFilm);
			dfs(0, 1, 1, film, originalFilm);
			dfs(0, 0, 2, film, originalFilm);
			System.out.println("#" + test_case + " " + answer);

		}
	}

	private static void dfs(int i, int cnt, int AB, int[][] film, int[][] originalFilm) {
		// answer보다 큰 cnt는 계산할 필요 없음
		if (answer <= cnt || i >= D) {
			return;
		}

		// 주입하고
		for (int j = 0; j < W; j++) {
			if (AB == 2) {
				film[i] = originalFilm[i].clone();
				break;
			}
			film[i][j] = AB;
		}
		// 체크하고
		if (filmCheck(film)) {
			answer = Math.min(answer, cnt);
		}

		dfs(i + 1, cnt + 1, 0, film, originalFilm);
		dfs(i + 1, cnt + 1, 1, film, originalFilm);
		// 2는 아무것도 안함
		dfs(i + 1, cnt + 0, 2, film, originalFilm);
	}

	private static boolean filmCheck(int[][] film) {
        for (int i = 0; i < W; i++) { // 가로
            int cnt = 1;
            int maxCnt = 1;
            for (int j = 0; j < D - 1; j++) { // 두께
                if (film[j][i] == film[j + 1][i]) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                } else {
                    cnt = 1;
                }
            }
            if (maxCnt < K) { // 합격 기준에 못미치면
                return false;
            }
        }
        return true;
    }
}