package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점심식사시간 {
	
	static int map[][];
	static List<Person> person;
	static List<Stair> stair;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N= 5;
			
			person = new ArrayList<Person>();
			stair = new ArrayList<Stair>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 1) {
						person.add(new Person(i,j,0));
					}
					else if(temp >= 2) {
						stair.add(new Stair(i,j,0));
					}
				}
			}
			
			numbers = new int[person.size()];
			combi(0, 0);
		}
		
	}
	
	static int numbers[];
	static Queue<Person> stair1 = new LinkedList<Person>();
	static Queue<Person> stair2 = new LinkedList<Person>();
	private static void combi(int cnt, int idx) {
		if(cnt!=0) {
			boolean arr[] = new boolean[person.size()];
			for(int i=0; i<cnt; i++) {
				arr[numbers[i]] = true; // true면 1번계단 false면 2번계단
			}
			for(int i=0; i<person.size(); i++) {
				if(arr[i] == true) { // 1번 계단이랑 거리구함
					person.get(i).time = Math.abs(person.get(i).x - stair.get(0).x) +
										Math.abs(person.get(i).y - stair.get(0).y) + 1; // 1분후ㅐ
					person.get(i).pick=0;
				}
				else { // 2번 계단이랑 거리구함
					person.get(i).time = Math.abs(person.get(i).x - stair.get(1).x) +
										Math.abs(person.get(i).y - stair.get(1).y) + 1;
					person.get(i).pick=1;
				}
			}
			Collections.sort(person);
			int time = person.get(0).time-1;
			while(true) {
				time++;
				if(person.get)
			}
		}
		
		for(int i=idx; i<person.size(); i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1);
		}
		
	}

	static class Stair{
		int x;
		int y;
		int length;
		public Stair(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	
	static class Person implements Comparable<Person>{
		int x;
		int y;
		int time;
		int pick;
		public Person(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.time, o.time);
		}
	}
}
