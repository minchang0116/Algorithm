package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 차량정비소 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 접수 창구 개수
			int jubsu[] = new int[N];
			Arrays.fill(jubsu, -1);
			int M = Integer.parseInt(st.nextToken()); // 정비 창구 개수
			int jungbi[] = new int[M];
			Arrays.fill(jungbi, -1);
			int K = Integer.parseInt(st.nextToken()); // 고객 수 
			int A = Integer.parseInt(st.nextToken())-1; // 분실고객이 이용한 접수창구
			int B = Integer.parseInt(st.nextToken())-1; // 분실고객이 이용한 정비창구
			int a[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken()); // 접수 창구에서 걸리는 시간
			}
			int b[] = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				b[i] = Integer.parseInt(st.nextToken()); // 정비 창구에서 걸리는 시간
				
			}
			st = new StringTokenizer(br.readLine());
			int t[] = new int[K];
			for(int i=0; i<K; i++) {
				t[i] = Integer.parseInt(st.nextToken()); // 고객이 접수창고에 오는 시간
			}
			
			int tempA[] = Arrays.copyOf(a, N);
			int tempB[] = Arrays.copyOf(b, M);
			int time=-1;
			boolean jub[] = new boolean[K];
			boolean jung[] = new boolean[K];
			int result[] = new int[K];
			PriorityQueue<Go> pq = new PriorityQueue<Go>();
			while(true) {
				time++; // 0초부터
				for(int i=0; i<K; i++) { // i번째 사람
					if(t[i] <= time && jub[i] == false) { // 타임이 됬다면 접수부터
						for(int j=0; j<N; j++) {
							if(jubsu[j] == -1) {
								if(A==j) {
									result[i]++;
								}
								jubsu[j] = i;
								jub[i] = true;
								break;
							}
						}
					}
				}
				
				for(int i=0; i<N; i++) { // 이번엔 접수창고 시간 줄이고
					if(jubsu[i] != -1) { //여기 사람이 있으면, jubsu[i]에 사람번호들어있음
						a[i]--; // 접수창고에서 걸리는 시간 한개 까줌
					}
					if(jubsu[i]!=-1 && a[i] == 0) {
						a[i] = tempA[i];
						pq.add(new Go(jubsu[i], i, time)); // q에 넣구 접수창구 비워줌
						jubsu[i] = -1;
					}
				}
				
				for(int j=0; j<M; j++) {
					if(jungbi[j] == -1) { // 정비창고 비어있으면
						if(!pq.isEmpty()) { // 비어있지않으면 하나 빼줌
							Go go = pq.poll(); 
							if(B==j) {
								result[go.idx]++;
							}
							jungbi[j]= go.idx;
						}
					}
				}
				
				for(int i=0; i<M; i++) { // 이번엔 정비창고 시간 줄임
					if(jungbi[i] != -1) { //여기 사람이 있으면
						b[i]--; // 정비창고에서 걸리는 시간 한개 까줌
					}
					if(jungbi[i] != -1 && b[i] == 0) { //정비창고 일끝나면 비워줌
						b[i] = tempB[i];
						jung[jungbi[i]] = true;
						jungbi[i] = -1;
					}
				}
				
				boolean flag=false;
				for(int i=0; i<K; i++) { // 종료조건
					if(jung[i] == false) {
						flag = true;
					}
				}
				if(flag == false) {
					break;
				}
			}
			
			int sum=0;
			for(int i=0; i<K; i++) {
				if(result[i] == 2) {
					sum+= i+1;
				}
			}
			if(sum==0) {
				System.out.println("#"+test_case+" "+-1);
				
			}
			else {
				System.out.println("#"+test_case+" "+sum);
				
			}
		}
	}
	
	static class Go implements Comparable<Go>{
		int idx;
		int jubsuIdx;
		int time;
		public Go(int idx, int jubsuIdx, int time) {
			this.idx = idx;
			this.jubsuIdx = jubsuIdx;
			this.time = time;
		}
		@Override
		public int compareTo(Go o) {
			if(this.time == o.time) {
				return Integer.compare(this.jubsuIdx, o.jubsuIdx);
			}
			return Integer.compare(this.time, o.time);
		}
		
	}
}
