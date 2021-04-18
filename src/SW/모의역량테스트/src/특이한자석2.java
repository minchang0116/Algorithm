package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특이한자석2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = Integer.parseInt(br.readLine()); // 자석 회전 횟수
			int magnetCnt = 4;
			int magnet[][] = new int[magnetCnt][8];
			
			StringTokenizer st;
			for(int i=0; i<magnetCnt; i++) {
				st =new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken()); // 12시방향부터 0이면 N 1이면 S
				}
			}
			
			//자석번호는 1번부터 시작
			for(int i=0; i<K; i++) {
				boolean magnetCheck[] = new boolean[magnetCnt];
				st = new StringTokenizer(br.readLine());
				dfs(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), magnet, magnetCheck, magnetCnt);
			}
			
			int answer =0;
			for(int i=0; i<magnetCnt; i++) {
				if(magnet[i][0] == 1) {
					answer += (int) Math.pow(2, i);
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}

	// dir => 1이면 시계방향 0이면 반시계
	private static void dfs(int magnetIdx, int dir, int[][] magnet, boolean[] magnetCheck, int magnetCnt) {
		// 2번째와 6번째 위치가 옆 자석들가 맞붙는 인덱스
		magnetCheck[magnetIdx] = true;
		// 왼쪽 자석이 있으면
		if (magnetIdx - 1 >= 0 && magnetCheck[magnetIdx - 1] == false) {
			if (magnet[magnetIdx][6] != magnet[magnetIdx - 1][2]) {
				dfs(magnetIdx - 1, dir * -1, magnet, magnetCheck, magnetCnt);
			}
		}

		if (magnetIdx + 1 < magnetCnt && magnetCheck[magnetIdx + 1] == false) {
			if (magnet[magnetIdx][2] != magnet[magnetIdx + 1][6]) {
				dfs(magnetIdx + 1, dir * -1, magnet, magnetCheck, magnetCnt);
			}
		}

		if (dir == 1) {
			int temp = magnet[magnetIdx][7];
			for (int i = 6; i >= 0; i--) {
				magnet[magnetIdx][i + 1] = magnet[magnetIdx][i];
			}
			magnet[magnetIdx][0] = temp;
		} else {
			int temp = magnet[magnetIdx][0];
			for (int i = 1; i < 8; i++) {
				magnet[magnetIdx][i - 1] = magnet[magnetIdx][i];
			}
			magnet[magnetIdx][7] = temp;
		}

	}
}
