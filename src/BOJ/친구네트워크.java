package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 친구네트워크 {
	static Map<String, String> parents;
	static Map<String, Integer> friends;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int F = Integer.parseInt(br.readLine());
			parents = new HashMap<>();
			friends = new HashMap<>();
			for(int i=0; i<F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				union(a, b);
				System.out.println(friends.get(parents.get(a)));
			}
			
		}
	}
	private static void union(String a, String b) {
		String rootA = find(a);
		String rootB = find(b);
		if(!rootA.equals(rootB)) {
			parents.put(rootB, rootA);
			friends.put(rootA, friends.get(rootA)+friends.get(rootB));
		}
	}
	private static String find(String a) {
		if(!parents.containsKey(a)) { // 초기값이 없으면 부모는 자기 자신
			friends.put(a, 1);
			parents.put(a, a);
			return a;
		}
		
		if(parents.get(a).equals(a)) return a;
		parents.put(a, find(parents.get(a)));
		return parents.get(a);
	}
}
