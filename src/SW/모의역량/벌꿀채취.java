package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 벌꿀채취 {
	static int map[][];
	static int N,M,C;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			C= Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			arr = new int[M];
			numbers = new int[M];
			Integer temp[] = new Integer[N];
			//행 i, j
			// 행의 최대 수익 구하고 
			// 가장 큰값 2개 더해도됨
			for(int i=0; i<N; i++) {
				int colI = -1;
				result=0;
				while(true) {
					colI++;
					if(colI+M > N ) break;
					for(int k=0; k<M; k++) {
						arr[k] = map[i][colI+k];
					}
					combi(0, 0, 0);
					temp[i] = result;	// 행 다구함
				}
			}
			Arrays.sort(temp, Collections.reverseOrder()); // 내림차순 정렬
			
			System.out.println("#"+t+" "+ (temp[0]+temp[1]));
			
			
		}
	}
	
	static int numbers[];
	static int arr[];
	static int result;
	
	static void combi(int cnt, int idx, int sum){
		if( sum > C ) {
			return;
		}
		
		int tempSum = 0;
		for(int i=0; i<cnt; i++) {
			tempSum = tempSum + arr[numbers[i]]* arr[numbers[i]];
		}
		result = Math.max(result, tempSum);
		
		
		if(cnt == M) {
			return;
		}
		
		for(int i=idx; i<M; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1, sum+arr[numbers[cnt]]);
		}
	}
}
