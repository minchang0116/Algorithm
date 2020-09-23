package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int resultMax = 0;
		for(int i=0; i<N; i++) { //연속해서 커질때
			int previous = arr[i];
			int cnt=1;
			for(int j=i+1; j<N; j++) {
				if(previous <= arr[j]) {
					previous = arr[j];
					cnt++;
				}
				else break;
			}
			resultMax = Math.max(resultMax, cnt);
		}

		for(int i=0; i<N; i++) { //연속해서 작아질때
			int previous = arr[i];
			int cnt=1;
			for(int j=i+1; j<N; j++) {
				if(previous >= arr[j]) {
					previous = arr[j];
					cnt++;
				}
				else break;
			}
			resultMax = Math.max(resultMax, cnt);
		}
		System.out.println(resultMax);
	}
}
