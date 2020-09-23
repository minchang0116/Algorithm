package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2564_경비원2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int storeCnt = Integer.parseInt(br.readLine());
		Store store[] = new Store[storeCnt+1];
		for(int i=0; i<storeCnt + 1; i++) { // 동근이 좌표는 마지막 인덱스에 추가
			st = new StringTokenizer(br.readLine());
			
			int tempDir = Integer.parseInt(st.nextToken());
			int r=0;
			int c=0;
			switch(tempDir) { 
			case 1: // 위치가 북일때 좌표값
				r = 0;
				c = Integer.parseInt(st.nextToken());
				break;
			case 2: // 남쪽일때
				r = height;
				c = Integer.parseInt(st.nextToken());
				break;
			case 3: // 서쪽
				r = Integer.parseInt(st.nextToken());
				c = 0;
				break;
			case 4: // 동쪽
				r = Integer.parseInt(st.nextToken());
				c = width;
				break;
			}
			store[i] = new Store(r,c);
		}
		
		int result = 0;
		for(int i=0; i<storeCnt; i++) {
			// 남북으로 마주보고있을때
			if((store[storeCnt].r == 0 && store[i].r == height) // 동근이 행 0일때 상점 행은 height
					|| (store[storeCnt].r == height && store[i].r == 0)) {
				result += Math.min(store[storeCnt].c + store[i].c, (width-store[storeCnt].c)+(width - store[i].c)) + height;
			}
			// 동서로 마주보고 있을때
			else if((store[storeCnt].c == 0 && store[storeCnt].c == width) // 동근이 열이 0일때 상점 행은 width
					|| (store[i].c == width && store[i].c == 0)) {
				result += Math.min(store[storeCnt].r + store[i].r, (height-store[storeCnt].r)+(height - store[i].r)) + width;
			}
			// 나머진 맨하탄 거리
			else {
				result += Math.abs(store[storeCnt].r - store[i].r) + Math.abs(store[storeCnt].c - store[i].c);
			}
		}
		System.out.println(result);
		
	}
	static class Store{
		int r;
		int c;
		public Store(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
}
