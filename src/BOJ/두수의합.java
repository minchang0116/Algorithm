package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		
        int start = 0;
        int end = n-1;
        int answer = 0;
        int sum;
        Arrays.sort(arr);
        while(start < end){
            sum = arr[start]+arr[end];
            if(sum == x) answer++;
            if(sum > x){
                end--;
            }
            else {
                start++;
            }
        }
        System.out.println(answer);
	}
}
