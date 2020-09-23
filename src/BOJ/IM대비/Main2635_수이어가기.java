package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2635_수이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		
		int result=0;
		int arr[] = new int[10000];
		int arr2[] = new int[10000];
		for(int i=n; i>0; i--) {
			int cnt=0;
			arr[cnt++] = n;
			arr[cnt++] = i;
			while(true) {
				if(arr[cnt-2] - arr[cnt-1]  < 0) {
					break;
				}
				arr[cnt] = arr[cnt-2] - arr[cnt-1];
				cnt++;
			}
			if(cnt > result) {
				result = cnt;
				for(int j=0; j<cnt; j++) {
					arr2[j] = arr[j];
				}
			}
		}
		
		System.out.println(result);
		for(int i=0; i<result; i++) {
			System.out.print(arr2[i]+" ");
		}
	}
}
