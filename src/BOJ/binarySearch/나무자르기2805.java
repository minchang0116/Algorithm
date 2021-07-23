package BOJ.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int treeHeight[] = new int[N];
		st = new StringTokenizer(br.readLine());
		int right = 0;
		for(int i=0; i<N; i++) {
			treeHeight[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, treeHeight[i]);
		}
		
		int left = 0;
		while(left+1 < right) {
			int mid = (left+ right) / 2;
			
			long sum = countTree(N, treeHeight, mid);
			if(sum >= M) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		System.out.println(left);
	}
	
	static long countTree(int N, int[] treeHeight, int curHeight) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			if(treeHeight[i] > curHeight) {
				sum += (treeHeight[i] - curHeight);
			}
		}
		return sum;
	}
}
