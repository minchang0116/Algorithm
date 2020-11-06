package SW.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 원자소멸시뮬레이션 {
	static int N;
	static LinkedList<Atom> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new LinkedList<Atom>();
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				list.offer(new Atom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			result = 0;
			solve();
			System.out.println("#" + t + " " + result);
			// dir 0상 1하 2좌 3우
			// 상이면 y+1 하 y-1, 우 x+1 좌 x-1
			// 종료조건 ???
		}
	}

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int result;

	private static void solve() {
		while (!list.isEmpty()) {
			Atom atom = list.get(0);
			
			atom.x += dx[atom.dir];
			atom.y += dy[atom.dir];
			if (atom.x > 1000 || atom.y > 1000 || atom.x < -1000 || atom.y < -1000) {
				list.remove(0);
				continue;
			}
			boolean crush = false;
			for (int i = 1; i < list.size(); i++) {
				Atom temp = list.get(i);
				if (atom.x == temp.x && atom.y == temp.y) { // 0.5초
					if (atom.dir == 1 && temp.dir == 2 || atom.dir == 2 && temp.dir == 1
							|| atom.dir == 3 && temp.dir == 4 || atom.dir == 4 && temp.dir == 3) {
						result += temp.energy;
						list.remove(i);
						i--;
						crush = true;
					}
				} else {// 뽑은것에서 한칸 갔는데 같아도 터짐
					temp.x += dx[temp.dir];
					temp.y += dy[temp.dir];
					if (atom.x == temp.x && atom.y == temp.y) { // 같으면 터짐
						result += temp.energy;
						list.remove(i);
						i--;
						crush = true;
					}
				}
			}
			if (crush == false) { // 안뿌숴지면 다시 넣음
			} else { // 뿌숴지면 값증가
				list.remove(0);
				result += atom.energy;
			}
		}
	}

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
