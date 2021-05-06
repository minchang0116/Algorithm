package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 센서 {
	static int N,K;
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int dif[] = new int[N-1];
		
		for(int i=0; i<N-1; i++) {
			dif[i] = arr[i+1] - arr[i];
		}
		Arrays.sort(dif);

		int sum =0;
		for(int i=(N-2)-(K-1);  i>=0; i--) {
			sum += dif[i];
		}
		System.out.println(sum);
	}
}
