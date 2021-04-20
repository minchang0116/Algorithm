package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 차량정비소2 {

	static int jubsu[], jungbi[], t[];
	static int N, M, K, A, B, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 접수창구수
			M = Integer.parseInt(st.nextToken()); // 정비창구수
			K = Integer.parseInt(st.nextToken()); // 고객수
			A = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 접수창구번호
			B = Integer.parseInt(st.nextToken()); // 이용한 정비 창구 번호
			jubsu = new int[N + 1]; // 0은 사용안함
			jungbi = new int[N + 1]; // 0은 사용안함
			t = new int[K + 1]; // 이것두 1번고객부터 시작
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				jubsu[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				jungbi[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				t[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			solve();

			if(answer == 0) answer =-1;
			System.out.println("#" + test_case + " " + answer);

		}
	}

	private static void solve() {
		int visitPerson[][] = new int[K + 1][2];
		Person checkJubsu[] = new Person[N + 1];
		Person checkJungbi[] = new Person[M + 1];
		PriorityQueue<Person> jungbiQ = new PriorityQueue<Person>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.time == o2.time) {
					return Integer.compare(o1.prevJubsuNo, o2.prevJubsuNo);
				}
				return Integer.compare(o1.time, o2.time);
			}
		});

		int time = 0;
		outer: while (true) {
			for (int i = 1; i <= M; i++) {
				if (checkJungbi[i] != null && checkJungbi[i].time <= time) { // 정비가 끝난 손님이면
					checkJungbi[i] = null;
				}
			}
			for (int i = 1; i <= N; i++) {
				if (checkJubsu[i] != null && checkJubsu[i].time <= time) { // 접수가 끝난 손님이면
					jungbiQ.offer(new Person(checkJubsu[i].num, time, checkJubsu[i].prevJubsuNo));
					checkJubsu[i] = null;
				}
			}

			for (int i = 1; i <= K; i++) { // 고객이 낮은 순으로
				if (time >= t[i] && visitPerson[i][0] == 0) { // 도착한 손님이면
					for (int j = 1; j <= N; j++) {
						if (checkJubsu[j] == null) { // 접수창구가 비어있는지 확인하고 넣는다
							checkJubsu[j] = new Person(i, time + jubsu[j], j);
							visitPerson[i][0] = j;
							break;
						}
					}
				}
			}

			for (int i = 1; i <= M; i++) {
				if (checkJungbi[i] == null) { // 빈 정비창구가 있으면
					if (!jungbiQ.isEmpty()) {
						Person curPerson = jungbiQ.poll();
						checkJungbi[i] = new Person(curPerson.num, time + jungbi[i], curPerson.prevJubsuNo);
						visitPerson[curPerson.num][1] = i;
					}
					else break;
				}
			}

			for (int i = 1; i <= K; i++) {
				for (int j = 0; j < 2; j++) {
					if (visitPerson[i][j] == 0) {
						time++;
						continue outer;
					}
				}
			}
			break;

		}
		for (int i = 1; i <= K; i++) {
			if (visitPerson[i][0] == A) {
				if (visitPerson[i][1] == B) {
					answer += i;
				}
			}
		}
	}

	static class Person {
		int num;
		int time;
		int prevJubsuNo;

		public Person(int num, int time, int prevJubsuNo) {
			this.num = num;
			this.time = time;
			this.prevJubsuNo = prevJubsuNo;
		}


	}
}
