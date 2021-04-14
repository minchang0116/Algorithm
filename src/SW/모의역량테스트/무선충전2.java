import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무선충전2 {
	
	static int dx[]= {0,0,1,0,-1};
	static int dy[]= {0,-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int answer =0;
			
			int moveA[] = new int[M+1];
			int moveB[] = new int[M+1];
			BC bc[] = new BC[A];
			
			st = new StringTokenizer(br.readLine());
			moveA[0] = 0;
			moveB[0] = 0;
			for(int i=1; i<=M; i++) {
				moveA[i] = (Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				moveB[i] = (Integer.parseInt(st.nextToken()));
			}
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
	
			
			int ax =1;
			int ay =1;
			int bx = 10;
			int by = 10;
			
			
			
			for(int i=0; i<=M; i++) {
				ax += dx[moveA[i]];
				ay += dy[moveA[i]];
				
				bx += dx[moveB[i]];
				by += dy[moveB[i]];
				boolean visitedA[] = new boolean[A];
				boolean visitedB[] = new boolean[A];
				for(int j=0; j<A; j++) {
					if(Math.abs(ax-bc[j].x) + Math.abs(ay-bc[j].y) <= bc[j].C) {
						visitedA[j] = true;
					}
					
					if(Math.abs(bx-bc[j].x) + Math.abs(by-bc[j].y) <= bc[j].C) {
						visitedB[j] = true;
					}
				}
				
				int maxSum = 0;
				for(int j=0; j<A; j++) {
					int sum =0;
					if(visitedA[j]==true) {
						sum+=bc[j].P;
					}
					for(int k=0; k<A; k++) {
						if(visitedB[k] == true && k != j) {
							maxSum = Math.max(maxSum, sum+bc[k].P);
						}
						
						if(visitedB[k] == true && visitedA[j]== false) {
							maxSum = Math.max(maxSum, sum+bc[k].P);
						}
					}
					maxSum = Math.max(maxSum, sum);
				}
				answer += maxSum;
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	



	static class BC{
		int x;
		int y;
		int C;
		int P;
		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
		
	}
}
