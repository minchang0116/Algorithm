package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int arr[] = new int[6];
		
		int maxWidth = 0; //가로최대
		int maxHeight = 0; //세로최대

		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			if(dir == 1 || dir == 2) { //동서
				arr[i] = Integer.parseInt(st.nextToken());
				if(maxWidth < arr[i]) {
					maxWidth = arr[i]; //가로최대구함
				}
			}
			else { //남북
				arr[i] = Integer.parseInt(st.nextToken());
				if(maxHeight < arr[i]) {
					maxHeight = arr[i]; //세로최대구함
				}
			}
		}
		
		int width=0; // 뺄 넓이
		int height=0; // 뺄 넓이
		for(int i=0; i<6; i++) {
			if(arr[i] == maxWidth) { //가로 최대에서 2번째 떨어진 곳 넓이 계산
				if(arr[(i+1)%6] == maxHeight) { //가로최대옆이 세로최대면 3번째떨어진곳
					width = arr[(i+3)%6];
					height = arr[(i+4)%6];
					break;
				}
				else {
					width = arr[(i+2)%6];
					height = arr[(i+3)%6];
					break;
				}
			}
		}
		int result = (maxWidth*maxHeight - width*height) * K;
		System.out.println(result);
	
	}
}
