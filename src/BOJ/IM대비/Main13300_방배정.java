package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[][] = new int[2][7];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		
		int result =0;
		for(int i=0; i<2; i++) {
			for(int j=1; j<7; j++) {
				result += arr[i][j]/K;
				if(arr[i][j] % K != 0) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
