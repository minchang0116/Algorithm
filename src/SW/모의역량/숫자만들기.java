package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[4]; // 연산자 갯수
			numbers = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			temp = new int[N-1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			permu(0);
			System.out.println("#"+t+" "+(max - min));
		}
	}
	
	static int N;
	static int arr[], numbers[];
	static int temp[];
	static int max, min;
	private static void permu(int cnt) {
		if(cnt == N-1) {
			int sum = numbers[0];
			for(int i=0; i<N-1; i++) {
				switch(temp[i]) {
				case 0:
					sum = sum + numbers[i+1];
					break;
				case 1:
					sum = sum - numbers[i+1];
					break;
				case 2:
					sum = sum * numbers[i+1];
					break;
				case 3:
					sum = sum / numbers[i+1];
					break;
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for(int i=0; i<4; i++) {
			if(arr[i]>0) {
				arr[i] -= 1;
				temp[cnt] = i;
				permu(cnt+1);
				arr[i] +=1;
			}
		}
		
	}
}
