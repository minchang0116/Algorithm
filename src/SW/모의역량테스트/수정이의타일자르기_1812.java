package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 수정이의타일자르기_1812 {
	
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Integer arr[] = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) { 
				int temp = Integer.parseInt(st.nextToken());
				int temp2 = 1;
				for(int j=0; j<temp; j++) {
					temp2*=2;
				}
				arr[i] = temp2;
			}
			Arrays.sort(arr, Collections.reverseOrder());
			int map[] = new int[M];
			boolean check[] = new boolean[N];
			int exitCnt = 0;
			int count=0;
			while(true) {
				if(exitCnt >= N) {
					break;
				}
				
				for(int i=0; i<M; i++) {
					map[i] = 0;
				}
				count++;
				outer: for(int k=0; k<N; k++) {
					if(check[k] == true) continue;
					for(int i=0; i<M; i++) {
						for(int j=0; j<M; j++) {
							if((map[i]&(1<<j)) == 0 && i+arr[k]-1 < M && j+arr[k]-1 < M) { // 그릴수있으면
								exitCnt++;
								check[k] = true;
								for(int a=i; a<i+arr[k]; a++) {
									map[a] = map[a]|((1<<arr[k]+j)-1);
								}
								continue outer;
							}
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+count);
		}
	}
}
