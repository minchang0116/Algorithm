package BOJ.IM대비;

import java.io.IOException;
import java.util.Scanner;

public class Main10157_자리배정2 {
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();   // 가로크기
	      int R = sc.nextInt();   // 세로크기
	      int K = sc.nextInt();   // 대기번호
	      
	      sc.close();

	      int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
	      if(K > R*C) System.out.println("0");
	      else {
	         int[][] grid = new int[R+1][C+1];
	         int d = 0, count = 0;
	         int px, py;
	         int x = 0, y = 1;   // 시작 위치
	         while(true) {
	            px = x + dir[d][0];
	            py = y + dir[d][1];
	            
	            if(px > R || px < 1 || py < 1 || py > C || grid[px][py] != 0) {
	               d++;
	               if(d == 4) d = 0;
	               px = x + dir[d][0];
	               py = y + dir[d][1];
	            }
	            
	            x = px;
	            y = py;
	            
	            grid[x][y] = ++count;
	            if(count == K) {
	               System.out.println(x + " " + y);
	               System.out.println();
	               break;
	            }
	         }
	      }
	}
}
