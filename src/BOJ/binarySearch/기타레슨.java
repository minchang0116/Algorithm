package BOJ.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int left = 0;
		int right = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
		}
		
		while(left+1<right) {
			int mid = (left+right)/2;
			if(isPossible(mid, arr, M)) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		System.out.println(right);
	}

	private static boolean isPossible(int mid, int[] arr, int m) {
		int curRemain = mid;
		int cnt = 1;
		for(int i=0; i<arr.length; i++) {
			if(curRemain - arr[i] >= 0) {
				curRemain -= arr[i];
			}
			else {
				cnt++;
				curRemain = mid;
				if(curRemain - arr[i] < 0) {
					return false;
				}
				else {
					curRemain -= arr[i];
				}
			}
			
			if(cnt > m) {
				return false;
			}
		}
		return true;
	}
}
