package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10158_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		int xDir = 1; // x축 방향
		int yDir = 1; // y축 방향
		if(x== width) { // x좌표가 오른쪽끝에 붙어있으면 왼쪽윗 대각선방향으로 진행
			xDir = -1;
		}
		if(y== height) { // y좌표가 맨위에 붙어있으면 아랫왼쪽 대각선방향으로 진행
			yDir = -1;
			xDir = -1;
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		// x축 계산
		int temp = t/width; // 몫이 홀수면 좌우반전해주고 x축방향을 반대로
		int temp2 = t%width; // 현재 x축방향으로 나머지 더해주면됨 
		if(temp %2 == 1) { //홀수면 좌우반전
			x = width-x; // 좌우반전
			xDir *= -1; // x축방향도 반대
		}
		
		x = x + temp2*xDir; // 나머지 더해주기
		
		if(x>width) { // width가 6일때 x가 6보다크면, 예를들어 8이면 8-6(width)은 2인데 width에다 2를 빼주면 4
			x = width - (x-width);
		}
		else if(x < 0) {
			x = Math.abs(x); // 0보다 작으면, 예를 들어 -2이면 2이다
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		// y축 계산
		temp = t/height;
		temp2 = t%height;
		if(temp %2 == 1) { //홀수면 상하반전
			y = height-y; // 상하반전
			yDir *= -1; // y축방향도 반대
		}
		
		y = y + temp2*yDir; // 나머지 더해주기
		
		if(y>height) { 
			y = height - (y-height);
		}
		else if(y < 0) {
			y = Math.abs(y); 
		}
		
		System.out.println(x + " " + y);
	}
}
