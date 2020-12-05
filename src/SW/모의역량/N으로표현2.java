package SW.모의역량;

import java.util.PriorityQueue;

public class N으로표현2 {
	public static void main(String[] args) {
		System.out.println(solution(1,11112));
	}
    public static int solution(int N, int number) {
        int answer = bfs(N, number);
        return answer;
    }
	private static int bfs(int n, int number) {
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(0, 0));
		while(!pq.isEmpty()) {
			Point temp = pq.poll();
			if(temp.cnt >8) {
				return -1;
			}
			else if(temp.n == number) {
				return temp.cnt;
			}
			int nn=n;
			pq.offer(new Point(temp.n+(n*n), temp.cnt+2));
			pq.offer(new Point(temp.n-(n/n), temp.cnt+2));
			for(int i=1; i<=6; i++) {
				pq.offer(new Point(temp.n+nn, temp.cnt+i));
				pq.offer(new Point(temp.n-nn, temp.cnt+i));
				pq.offer(new Point(temp.n*nn, temp.cnt+i));
				pq.offer(new Point(temp.n/nn, temp.cnt+i));
				nn= nn*10+n; 
			}
		}
		return -1;
		
	}
	
	private static class Point implements Comparable<Point>{
		int n;
		int cnt;

		public Point(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	
}
