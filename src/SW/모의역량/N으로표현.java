package SW.모의역량;

import java.util.PriorityQueue;

public class N으로표현 {
	public static void main(String[] args) {
		System.out.println(solution(1,11112));
	}
    public static int solution(int N, int number) {
        int answer = bfs(N, number, 0);
        return answer;
    }
	private static int bfs(int n, int number, int cnt) {
		
		int n2 = n*10+n;
		int n3 = n2*10+n;
		int n4 = n3*10+n;
		int n5 = n4*10+n;
		int n6 = n5*10+n;
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(n, 1));
		pq.offer(new Point(n2, 2));
		pq.offer(new Point(n3, 3));
		pq.offer(new Point(n4, 4));
		pq.offer(new Point(n5, 5));
		pq.offer(new Point(n6, 6));
		while(!pq.isEmpty()) {
			Point temp = pq.poll();
			if(temp.cnt >8) {
				return -1;
			}
			else if(temp.n == number) {
				return temp.cnt;
			}
			pq.offer(new Point(temp.n+n, temp.cnt+1));
			pq.offer(new Point(temp.n-n, temp.cnt+1));
			pq.offer(new Point(temp.n*n, temp.cnt+1));
			pq.offer(new Point(temp.n/n, temp.cnt+1));
			pq.offer(new Point(temp.n+(n*n), temp.cnt+2));
			pq.offer(new Point(temp.n-(n/n), temp.cnt+2));

			pq.offer(new Point(temp.n+n2, temp.cnt+2));
			pq.offer(new Point(temp.n-n2, temp.cnt+2));
			pq.offer(new Point(temp.n*n2, temp.cnt+2));
			pq.offer(new Point(temp.n/n2, temp.cnt+2));

			pq.offer(new Point(temp.n+n3, temp.cnt+3));
			pq.offer(new Point(temp.n-n3, temp.cnt+3));
			pq.offer(new Point(temp.n*n3, temp.cnt+3));
			pq.offer(new Point(temp.n/n3, temp.cnt+3));

			pq.offer(new Point(temp.n+n4, temp.cnt+4));
			pq.offer(new Point(temp.n-n4, temp.cnt+4));
			pq.offer(new Point(temp.n*n4, temp.cnt+4));
			pq.offer(new Point(temp.n/n4, temp.cnt+4));

			pq.offer(new Point(temp.n+n5, temp.cnt+5));
			pq.offer(new Point(temp.n-n5, temp.cnt+5));
			pq.offer(new Point(temp.n*n5, temp.cnt+5));
			pq.offer(new Point(temp.n/n5, temp.cnt+5));

			pq.offer(new Point(temp.n+n6, temp.cnt+6));
			pq.offer(new Point(temp.n-n6, temp.cnt+6));
			pq.offer(new Point(temp.n*n6, temp.cnt+6));
			pq.offer(new Point(temp.n/n6, temp.cnt+6));
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
