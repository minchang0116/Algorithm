package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int temp = i-Integer.parseInt(st.nextToken());
			for(int j=i; j>temp; j--) {
				arr[j] = arr[j-1];
			}
			arr[temp] = i+1;
		}

		for(int i=0; i<N; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
