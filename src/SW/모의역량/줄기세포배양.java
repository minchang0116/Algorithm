package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static PriorityQueue<Cell> pq;
	static int N, M, K;
    static HashSet<String> hs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<Cell>();
			hs = new HashSet<String>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int hp=Integer.parseInt(st.nextToken());
					if(hp!=0) {
						hs.add(i+","+j);
						pq.add(new Cell(i,j,hp, 0));
					}
				}
			}
			
			for(int i=0; i<K; i++) {
				solve();
			}
			
			int result =pq.size();
			System.out.println("#"+t+" "+ result);
			
		}
	}
	static Queue<Cell> q;
	private static void solve() {
		
		int pqSize = pq.size();
		q = new LinkedList<Cell>();
		for(int i=0; i<pqSize; i++) {
			Cell temp= pq.poll();
			temp.second++;
			if(temp.hp+1 == temp.second) { // hp가 2이면 시간이 3일때 번식
				breeding(temp);
			}
			if(temp.hp*2 <= temp.second) continue; // hp가 2이면 4초일때 죽음
			q.offer(temp);
		}
		pq.addAll(q);
	}

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1}; 
	private static void breeding(Cell cell) {
		for(int d=0; d<4; d++) {
			int nx = cell.x+dx[d]; 
			int ny = cell.y+dy[d];
			if(hs.contains(nx+","+ny) == true) {
				continue;
			}
			hs.add(nx+","+ny);
			q.offer(new Cell(nx,ny,cell.hp,0));
		}
	}

	private static class Cell implements Comparable<Cell>{
		int x;
		int y;
		int hp;
		int second;
		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.hp, this.hp);
		}
		
		public Cell(int x, int y, int hp, int second) {
			this.x = x;
			this.y = y;
			this.hp = hp;
			this.second = second;
		}
		
	}
}
