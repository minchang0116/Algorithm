package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점심식사시간 {
	static int MAXN =  11;
	static int MAXT = 11*2+11*11;
	// N :방의 한 변의 길이, M : 사람의 수, S( =2) : 계단의 수
	// map : 입력으로 주어지는 방의 정보
	// match[x] = y :x번째 사람이 y번째 계단을 타도록 결정된 상태
	
	static int N;
	static int map[][], match[];
	static int M, S;
	
	static int answer;
	static PT person[], stair[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = S = 0;
			map = new int[N+2][N+2];
			person = new PT[N*N];
			stair = new PT[2];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) person[M++] = new PT(i,j);
					if(map[i][j] >= 2) stair[S++] = new PT(i,j);
				}
			}
			
			answer = Integer.MAX_VALUE;
			match= new int[M];
			dfs(0);
			System.out.println("#"+tc+" "+answer);
		}
	}

	static void update() {
		// 모든 사람들이 계단을 내려가는데 필요한 최소 시간
		int total_min_time = 0;
		
		//두 계단은 서로 독립적이므로 각각에 대해서 계산한다.
		for (int stair_index=0; stair_index <2; stair_index++) {
			PT now_stair = stair[stair_index];
			int arrival_time[] = new int[MAXN * 2]; //시간 t일 때 계단에 도착하는 사람의 수
			int current_stair[] = new int[MAXT]; //시간 t일때 계단을 내려가고 있는 사람의 수
			
			for(int man_index =0; man_index <M; man_index++) {
				if(match[man_index] == stair_index) {
					arrival_time[dist(man_index, stair_index)+1]++;
				}
			}
			
			//stair_index번째 계단을 내려가는 사람이 모두 작업을 마치기 위해 필요한 최소 시간
			int now_min_time=0;
			//계단에 도착하는 시간 오름차순으로 각 사람이 계단을 내려가도록 시뮬레이션
			for(int time=1; time<=20; time++) {
				//time에 도착한 사람이 있다면
				while(arrival_time[time] >0) {
					arrival_time[time]--;
					//해당 계단에 내려가는데 필요한 시간
					int remain_time = map[now_stair.r][now_stair.c];
					
					//도착한 시점부터 사람 3명이 동시에 내려가고 있지 않을 때에 1칸씩 밑으로 내려 보낸다.
					for(int walk_time= time; walk_time<MAXT; walk_time++) {
						if(current_stair[walk_time] < 3) {
							current_stair[walk_time]++;
							remain_time--;
							
							//계단을 다 내려갔으면 now_min_time 갱신
							if(remain_time ==0) {
								now_min_time = Math.max(now_min_time, walk_time+1);
								break;
							}
						
						}
					}
				}
			}
			//"전체 계단을 내려가는데 필요한 최소 시간"은 (두 계단을 내려가는데 필요한 최소 시간) 중 최댓값
			total_min_time = Math.max(total_min_time, now_min_time);
		}
		answer = Math.min(answer,total_min_time);
	}
	
	static void dfs(int man_index) {
		if(man_index == M) {
			update();
			return;
		}
		
		for(int stair_index=0; stair_index<2; stair_index++) {
			match[man_index] = stair_index;
			dfs(man_index +1);
		}
	}
	
	
	static int dist(int man_index, int stair_index) {
		return Math.abs(person[man_index].r - stair[stair_index].r) + Math.abs(person[man_index].c - stair[stair_index].c);
	}
	
	private static class PT{
		int r, c;
		public PT(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}