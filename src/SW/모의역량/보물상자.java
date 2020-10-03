package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 보물상자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			HashSet<String> hs = new HashSet<String>();
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N / 4; j++) {
				for (int i = 0; i < 4; i++) {
//					System.out.println(sb.substring(i * N / 4 , i * N / 4 + N / 4 ));
					hs.add(sb.substring(i * N / 4, i * N / 4 + N / 4));
				}
				sb.insert(0, sb.charAt(N - 1));
				sb.deleteCharAt(N);
			}
			List<String> list = new ArrayList<String>(hs);
			Collections.sort(list, Collections.reverseOrder());
			
			System.out.println("#"+"t"+" "+Integer.parseInt(list.get(K-1), 16));


		}
	}
}
