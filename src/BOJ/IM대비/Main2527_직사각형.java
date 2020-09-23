package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2527_직사각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int  x1 = Integer.parseInt(st.nextToken());
			int  y1 = Integer.parseInt(st.nextToken());
			int  x2 = Integer.parseInt(st.nextToken());
			int  y2 = Integer.parseInt(st.nextToken());
			
			int  tx1 = Integer.parseInt(st.nextToken());
			int  ty1 = Integer.parseInt(st.nextToken());
			int  tx2 = Integer.parseInt(st.nextToken());
			int  ty2 = Integer.parseInt(st.nextToken());
			
		
			// 공통 부분 없는 것
			if(tx2 < x1 || x2 < tx1 || y1 > ty2 || y2 < ty1 ) {
				System.out.println("d");
			}
			// 점
			else if(((x1 == tx2)&&(y1 == ty2)) || ((x1 == tx2)&&(y2 == ty1)) || ((x2 == tx1)&&(y1 == ty2)) || ((x2 == tx1)&&(y2 == ty1))) {
				System.out.println("c");
			}
			// 선분
			else if((x2 == tx1 && y2 != ty1) || (x1 == tx2 && y2 != ty1) || (x2 != tx1 && y1 == ty2) || (x1 != tx2 && y1 == ty2)) {
				System.out.println("b");
				
			}
			else {
				System.out.println("a");
			}
		}
		
	}
}
