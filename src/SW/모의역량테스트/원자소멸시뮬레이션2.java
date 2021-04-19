package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 원자소멸시뮬레이션2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 원자 수
			int N = Integer.parseInt(br.readLine());
			int checkd[][] = new int[4005][4005];
			ArrayList<Atom> atom = new ArrayList<Atom>();
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				atom.add(new Atom((Integer.parseInt(st.nextToken())+1000) * 2, (Integer.parseInt(st.nextToken())+1000) * 2,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			// 상하좌우
			int dx[] = { 0, 0, -1, 1 };
			int dy[] = { 1, -1, 0, 0 };
			int answer = 0;
			while (!atom.isEmpty()) {
				for (int i = atom.size() - 1; i >= 0; i--) {

					// 이전 체크 값 0
					checkd[atom.get(i).x][atom.get(i).y] = 0;
					atom.get(i).x += dx[atom.get(i).dir];
					atom.get(i).y += dy[atom.get(i).dir];
					
					if (atom.get(i).x > 4000 || atom.get(i).x < 0 || atom.get(i).y > 4000
							|| atom.get(i).y < 0) {
						atom.remove(i);
					}
					else {
						// 이미 1이면 겹친거므로 2로 바꿔주고 다 터트림
						if(checkd[atom.get(i).x][atom.get(i).y] >= 1) {
							answer += atom.get(i).energy;
							checkd[atom.get(i).x][atom.get(i).y] = 2;
							atom.remove(i);
						}
						else {
							// 처음 방문 하면 1
							checkd[atom.get(i).x][atom.get(i).y] = 1;
						}
					}
					
				}
			
				for(int i = atom.size() -1; i>= 0; i--) {
					// 겹쳐서 터졌다면 처음에 값도 지워줌
					if(checkd[atom.get(i).x][atom.get(i).y] == 2) {
						answer += atom.get(i).energy;
						checkd[atom.get(i).x][atom.get(i).y] = 0;
						atom.remove(i);
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

	// x,y 는 좌표
	static class Atom {
		int x;
		int y;
		int dir;
		int energy;

		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}

	}

}
