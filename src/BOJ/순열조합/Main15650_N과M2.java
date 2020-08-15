package BOJ.순열조합;

import java.util.Scanner;

public class Main15650_N과M2 {

	static int N, M;
	static int numbers[];
	static boolean selected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		selected = new boolean[N + 1];
		dfs(0,1);

	}

	static void dfs(int cnt,int idx) {
		if (cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = idx; i <= N; i++) {
			if (selected[i] == false) {
				selected[i] =true;
				numbers[cnt] = i;
				dfs(cnt + 1, i+1);
				selected[i] =false;
			}
		}
	}

}
