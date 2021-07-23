package BOJ.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int value = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = value+1;
		
		while(left+1 < right) {
			int mid = (left+right)/2;
			long sum = calculate(arr, mid);
			if(sum > value) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		System.out.println(left);
	}

	private static long calculate(int[] arr,int mid) {
		long sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(mid >arr[i]) 
				sum += arr[i];
			else 
				sum += mid;
		}
		return sum;
	}
}
