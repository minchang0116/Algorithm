package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {

	static int arr[];
	static int month[];
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			arr = new int[4];
			month = new int[12];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				 month[i] = Integer.parseInt(st.nextToken());
			}
		
			temp = new int[12]; // 각 달의 최소값
			result = 0;
			// 1년치
			result = arr[3];
			// 1일, 1달
			int value;
			for(int i=0; i<12; i++) {	
				value = month[i] * arr[0];
				if(value > arr[1]) { // 1일 이용권보다 달이용권이 싸다면
					temp[i] = arr[1];
				}
				else {
					temp[i] = value;
				}
			}
			dfs(0, 0);
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static void dfs(int cnt, int pay) {
		if(cnt >= 12) {
			result = Math.min(result, pay);
			return;
		}
		dfs(cnt+1, pay+temp[cnt]);
		dfs(cnt+3, pay+arr[2]);
	}
	
	static int temp[];

}
