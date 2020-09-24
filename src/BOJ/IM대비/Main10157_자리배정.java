package BOJ.IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10157_자리배정 {
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		if(N*M < K) {
			System.out.println(0);
			return;
		}
		
		int map[][] = new int[N+1][M+1];
		int i=1;
		int j=1;
		int dir=0;
		int cnt=1;
		while(true) {
			map[i][j] = cnt++;
			if(cnt == (K)+1) {
				System.out.println(i+" "+j);
				System.out.println();
				return;
			}
			i=i+dx[dir];
			j=j+dy[dir];
			if(i<1 || i>=N+1 || j<1 || j>=M+1 || map[i][j] != 0) {
				i-=dx[dir];
				j-=dy[dir];
				dir = (dir+1)%4;
				i+=dx[dir];
				j+=dy[dir];
			}
		}
	}
}
