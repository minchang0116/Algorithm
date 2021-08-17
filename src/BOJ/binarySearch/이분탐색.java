package BOJ.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이분탐색 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int left = 0; int right= 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(arr[i], right);
		}
		int M = Integer.parseInt(br.readLine());
		
		if(sum <= M) //배정할 수 있으면
			System.out.println(right);
		else {
			while( left + 1 < right) {
				int mid = (left+right)/2;
				if(isPossible(mid, arr, M)) {
					left = mid;
				}
				else {
					right = mid;
				}
			}
			System.out.println(left);
		}
	}

	private static boolean isPossible(int mid, int[] arr, int m) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(mid > arr[i]) {
				sum += arr[i];
			}
			else {
				sum += mid;
			}
		}
		
		if(sum > m) {
			// 배정 불가능
			return false;
		}
		else {
			return true;
		}
		
		
	}
}
