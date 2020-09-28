package BOJ.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1197_크루스컬01 {
	
	static Edge[] edge;
	static int parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edge = new Edge[E];
		parents = new int[V+1];
		for(int i=1; i<V+1; i++) {
			parents[i] = i;
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			edge[i]= new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edge);
		int result = 0;
		for(int i=0; i<E; i++) {
			if(union(edge[i].from, edge[i].to)) {
				result += edge[i].value;
			}
		}
		System.out.println(result);
		
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}

	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int value;
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.value, o.value);
		}
		public Edge(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
	}
	
}
