package BOJ.입출력;

import java.util.Scanner;

public class Test15650 {

	static int N, M;
	static int arr[]  = new int[9];
	static boolean check[]= new boolean[9];
	public static void dfs(int cnt, int idx) {
		
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i= idx; i<=N; i++) {
			if(check[i] == false) {
				arr[cnt] = i;
				check[i] = true;
				dfs(cnt+1, i+1);
				check[i] =false;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		dfs(0, 1);
		sc.close();
	}

}
