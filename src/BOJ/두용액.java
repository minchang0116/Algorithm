package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] =new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int start =0;
		int end =N-1;
		int sum;
		int minSum= arr[start]+arr[end];
		int left = arr[0], right = arr[N-1];
		while(start<end) {
			sum = arr[start]+arr[end];
			if(Math.abs(0 - minSum) >Math.abs( 0 - sum)) {
				minSum = sum;
				left = arr[start];
				right = arr[end];
			}
			if(sum > 0) {
				end--;
			}
			else {
				start++;
			}
		}
		System.out.println(left+" "+right);
	}
}
