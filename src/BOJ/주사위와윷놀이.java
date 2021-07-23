package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위와윷놀이 {
	static class HorseInfo{
		int cur;
		int dir;
		public HorseInfo(int cur, int dir) {
			this.cur = cur;
			this.dir = dir;
		}
	}
	
	static int map[][];
	static HorseInfo horse[];
	static int dice[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[4][];
		map[0] = new int[] {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40};
		map[1] = new int[] {10,13,16,19,25,30,35,40};
		map[2] = new int[] {20,22,24,25,30,35,40};
		map[3] = new int[] {30,28,27,26,25,30,35,40};
		
		dice = new int[10];
		for(int i=0; i<10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		horse = new HorseInfo[4];
		for(int i=0; i<4; i++) {
			horse[i] = new HorseInfo(0,0);
		}
		
		answer = 0;
		for(int i=0; i<4; i++) {
			move(i,0,0);
		}
		System.out.println(answer);
		
	}

	static int answer;
	private static void move(int horseIdx, int diceIdx, int sum) {
		int prev = horse[horseIdx].cur;
		int prevDir = horse[horseIdx].dir;
		
		horse[horseIdx].cur += dice[diceIdx];
		if(!isEnd(horseIdx)) {
			
			sum += map[horse[horseIdx].dir][horse[horseIdx].cur];
		}
		
		if(diceIdx == 9) {
			answer = Math.max(sum, answer);
			horse[horseIdx].cur = prev;
			horse[horseIdx].dir = prevDir;
			return;
		}
		
		
		// 블루 화살표로 이동
		if(horse[horseIdx].dir == 0) {
			if(horse[horseIdx].cur == 5) {
				horse[horseIdx].dir = 1;
				horse[horseIdx].cur = 0;
			}
			else if(horse[horseIdx].cur == 10) {
				horse[horseIdx].dir = 2;
				horse[horseIdx].cur = 0;
			}
			else if(horse[horseIdx].cur == 15) {
				horse[horseIdx].dir = 3;
				horse[horseIdx].cur = 0;
			}
		}

		
		for(int i=0; i<4; i++) {
			if(isEnd(i)) 
				continue;
			if(horseCheck(i,diceIdx+1)) {
				move(i,diceIdx+1,sum);
			}
		}
		
		horse[horseIdx].cur = prev;
		horse[horseIdx].dir = prevDir;
	}
	private static boolean isEnd(int horseIdx) {
		if(horse[horseIdx].cur >= map[horse[horseIdx].dir].length) {
			return true;
		}
		return false;
	}
	private static boolean horseCheck(int horseIdx, int diceIdx) {
		for(int i=0; i<4; i++) {
			if(horse[horseIdx].dir == horse[i].dir) {
				if(horse[horseIdx].cur+dice[diceIdx] == horse[i].cur && !isEnd(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
