package BOJ.입출력;

import java.util.Arrays;
import java.util.Scanner;

public class Test15663 {

	static int N, M;
	static int arr[]  = new int[9];
	
	static boolean check[]= new boolean[9];
	static int input[] = new int[9];
	public static void dfs(int cnt) {
		int before = 0;
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i= 0; i<N; i++) {
			if(check[i] == false && before != input[i]) {
				before = input[i];
				arr[cnt] = input[i];
				check[i] = true;
				dfs(cnt+1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input, 0, N);

		dfs(0);
		sc.close();
	}

}
