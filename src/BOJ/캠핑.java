package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠핑 {
	static int L, P, V;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		while(true) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			if(L == 0 && P == 0 && V == 0) {
				break;
			}
			
			answer += V/P*L;
			
			int remain = V%P;
			if(remain >= L) {
				answer += L;
			}
			else {
				answer += remain;
			}
			System.out.println("Case " + idx +": " + answer);
			idx++;
		}
	}

}
