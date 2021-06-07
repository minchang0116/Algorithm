package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Lecture lecture[] = new Lecture[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lecture[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(lecture);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(lecture[0].T);
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= lecture[i].S) {
				pq.poll();
			}
			pq.add(lecture[i].T);
		}
		System.out.println(pq.size());
	}

	static class Lecture implements Comparable<Lecture> {
		int S;
		int T;

		public Lecture(int s, int t) {
			S = s;
			T = t;
		}

		@Override
		public int compareTo(Lecture o) {
			return Integer.compare(this.S, o.S);
		}
	}
}
