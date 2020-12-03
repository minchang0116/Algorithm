package SW.알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄스터_8275 {
	static int N, X, M;
	static int wori[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N개의 우리, 0마리이상 X마리 이하, M만큼 기록
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			wori = new int[N];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
			}
		}
	}
	
	
	static void combi(int cur, int r, int cnt, int s){
		if(cur == r+1) {
			
			return;
		}
		
		for(int i=0; i<X; i++) {
			if(cnt+i >= s) {
				break;
			}
			wori[cur] = i;
			combi(cur+1, r, cnt+i, s);
		}
	}
}
