package SW.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열나누기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String s = br.readLine();
			int answer = 1;
			int cnt = 1;
			int curFirst = 0;
			while(true) {
				if(curFirst+cnt+cnt >s.length()) {
					break;
				}
				
				if(s.substring(curFirst, curFirst+cnt).equals(s.substring(curFirst+cnt, curFirst+cnt+cnt))){
					cnt++;
				}
				else {
					answer++;
					curFirst += cnt;
					cnt = 1;
				}
			}
			System.out.println(answer);
		}
	}

}
