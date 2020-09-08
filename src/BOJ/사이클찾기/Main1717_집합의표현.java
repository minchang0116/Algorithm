package BOJ.사이클찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717_집합의표현 {

	static int parents[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch(input) {
			case 0:	
				union(a,b);
				break;
			case 1:
				if(find(a) == find(b)) System.out.println("YES");	// 같은 집합이면 YES
				else System.out.println("NO");	// 아니면 NO
				break;
			}
			
		}
	}

	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false; 
		parents[bRoot] = aRoot; 
		return true;
	}

}
