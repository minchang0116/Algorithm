package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 집합_11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hs = new HashSet<Integer>();
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=M; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("add")) {
				int value = Integer.parseInt(st.nextToken());
				if(!hs.contains(value)) {
					hs.add(value);
				}
			}
			else if(command.equals("remove")) {
				int value = Integer.parseInt(st.nextToken());
				if(hs.contains(value)) {
					hs.remove(value);
				}
			}
			else if(command.equals("check")) {
				int value = Integer.parseInt(st.nextToken());
				if(hs.contains(value)) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else if(command.equals("toggle")) {
				int value = Integer.parseInt(st.nextToken());
				if(hs.contains(value)) {
					hs.remove(value);
				}
				else {
					hs.add(value);
				}
			}
			else if(command.equals("all")) {
				for(int i=1; i<=20; i++) {
					hs.add(i);
				}
			}
			else if(command.equals("empty")) {
				hs.clear();
			}
		}
		System.out.println(sb.toString());
	}
}
