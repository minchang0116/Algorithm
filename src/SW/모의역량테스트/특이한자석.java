package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특이한자석 {
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int K=Integer.parseInt(br.readLine());
			arr = new int[4+1][8];
			StringTokenizer st;
			for(int i=1; i<=4; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1은 시계 -1은 반시계
			// 0번째가 맨위 2가 오른쪽 6이 왼쪽
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int pick = Integer.parseInt(st.nextToken());
				int rot = Integer.parseInt(st.nextToken());
				check = new boolean[5];
				check[pick] =true;
				rotation(pick, rot);
				move(pick, rot);
			}
			
			
			int result=0;
			int point =1;
			for(int i=1; i<=4; i++) {
				if(arr[i][0] == 1) {
					result += point;
				}
				point += point;
			}
			System.out.println("#"+t+" "+ result);
			
		}
	}
	static int dx[] = {-1,1}; //왼쪽 오른쪽
	static boolean check[];
	private static void rotation(int pick,int rot) {
		
		for(int d=0; d<2; d++) {
			int nx = pick + dx[d];
			if(nx == 0 || nx == 5 || check[nx] == true) continue;
			if(d == 0) { // 왼쪽 꺼랑 비교할때
				if(arr[nx][2] != arr[pick][6]) {
					//왼쪽꺼 회전하고 check하고 왼쪽꺼에서 재귀
					//재귀 드가고 그다음 회전
					check[nx] = true;
					rotation(nx, rot*-1);
					move(nx, rot*-1);
				}
			}
			else if(d==1) { //오른쪽꺼랑 비교할때
				if(arr[nx][6] != arr[pick][2]) {
					//오흔쪽꺼 회전하고 check하고 오른쪽꺼에서 재귀
					check[nx] = true;
					rotation(nx, rot*-1);
					move(nx, rot*-1);
				}
			}
			
		}
	}

	static public void move(int nx, int rot) {
		if(rot == 1) {
			int temp = arr[nx][7];
			for(int i=7; i>=1; i--) {
				arr[nx][i] = arr[nx][i-1];
			}
			arr[nx][0] = temp;
		}
		else if(rot == -1) {
			int temp = arr[nx][0];
			for(int i=0; i<7; i++) {
				arr[nx][i] = arr[nx][i+1];
			}
			arr[nx][7] = temp;
		}
	}
}
