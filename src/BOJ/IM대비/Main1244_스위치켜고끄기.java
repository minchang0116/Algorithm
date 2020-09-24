package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int studentCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<studentCnt; i++) {
			// 남은 1
			// 여는 2
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			switch(gender) {
			case 1:	// 남자
				Integer.parseInt(st.nextToken());
				break;
			case 2:	// 여자
				Integer.parseInt(st.nextToken());
				break;
			}
		}
	}
}
