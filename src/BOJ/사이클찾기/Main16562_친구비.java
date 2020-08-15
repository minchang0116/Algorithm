package BOJ.사이클찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16562_친구비 {

	
	static int parents[];
	static int friendMoney[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 바이트단위로 받아서 캐릭터형으로 바꾸고 버퍼에 캐릭터형으로 담음
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 친구관계 수
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

		friendMoney = new int[N + 1]; // 각 학생과 친구를 하려면 드는 돈
		parents = new int[N + 1]; // 학생 관계의 대표
		st = new StringTokenizer(br.readLine()); 
		for (int i = 1; i <= N; i++) { // 학생 수만큼 반복
			friendMoney[i] = Integer.parseInt(st.nextToken()); // 학생과 친구를 하려면 드는 돈 갱신
			parents[i] = i; // 학생 관계의 대표를 자기 자신으로
		}
		for (int i = 0; i < M; i++) { // 학생 관계의 수만큼 반복
			st = new StringTokenizer(br.readLine()); // 입력을 공백단위로 나눔
			int a = Integer.parseInt(st.nextToken()); // 학생 a와
			int b = Integer.parseInt(st.nextToken()); // 학생 b
			union(a, b); // 학생 a와 b의 관계를 맺어줌
			
		}
		
		int sum=0;
		for(int i=1; i<=N; i++) {
			if(find(i) == i) {
				K -= friendMoney[i];
				sum += friendMoney[i];
			}
		}
		if(K>=0) {
			System.out.println(sum);
		}
		else {
			System.out.println("Oh no");
		}
		
	}

	static int find(int a) {
		if (parents[a] == a) return a; // 학생 a의 대표가 a면 리턴
		return parents[a] = find(parents[a]);	// 학생a의 대표를 다이렉트로 갱신 1-2 2-3 3-3 -> 1-3
	}

	static boolean union(int a, int b) {
		int aRoot = find(a); //학생 a의 대표	5-1 1-1
		int bRoot = find(b); //학생 b의 대표	2-3 3-4 4-4
		if (aRoot == bRoot) return false; // 둘의 대표가 같으면 리턴
		
		if(friendMoney[aRoot] <friendMoney[bRoot]) { // a의 대표와 b의 대표의 돈을 낮은쪽을 갱신, 합해질때마다 대표는 항상 최저의 돈으로 갱신된다.
			friendMoney[bRoot] = friendMoney[aRoot];
		}
		else {
			friendMoney[aRoot] = friendMoney[bRoot];
		}
		parents[bRoot] = aRoot; // 다르면 b의 대표를 a의 대표로 바꿈
		return true;
	}

}
