package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<N; i++) {
			hs.add(br.readLine());
		}
		for(int i=0; i<M; i++) {
			String temp = br.readLine();
			if(hs.contains(temp)) {
				arr.add(temp);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for(int i=0; i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
}
