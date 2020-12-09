package SW.알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 혁진이와프로그램검증 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1}; //상하좌우
	static int R, C;
	static char arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new char[R][C];
			for(int i=0; i<R; i++) {
				String temp = br.readLine();
				for(int j=0; j<C; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			check = new boolean[R][C][16][4];
			answer = "NO";
			dfs(0, -1, 3, '0');
			System.out.println("#"+t+" "+answer);
			
		}
	}

	static boolean check[][][][];
	static String answer;
	private static void dfs(int x, int y ,int dir, char memory) {
		while(true) {
			x += dx[dir];
            y += dy[dir];
			
			if(x <0) x = R-1;
			else if(x >= R) x =0;
			else if(y <0) y = C-1;
			else if(y >= C)	y = 0;
			
			if(check[x][y][memory-'0'][dir] == true) {
				return;
			}
			
			check[x][y][memory-'0'][dir] = true;
			if(arr[x][y] >= '0' && arr[x][y] <= '9') {
				memory = arr[x][y];
			}
			else {
				switch(arr[x][y]) {
				case '<':
					dir=2;
					break;
				case '>':
					dir=3;
					break;
				case '^':
					dir=0;
					break;
				case 'v':
					dir=1;
					break;
				case '_':
					if(memory == '0') dir=3;
					else dir = 2;
					break;
				case '|':
					if(memory == '0') dir=1;
					else dir = 0;
					break;
				case '?':
					for(int i=0; i<4; i++) {
						if(dir == i ) continue;
						dfs(x, y, i, memory);
					}
					break;
				case '.':
					break;
				case '+':
					memory += 1;
					if(memory == '0'+16) memory ='0';
					break;
				case '-':
					memory -= 1;
					if(memory == '0'-1) memory ='0'+15;
					break;
				case '@':
					answer = "YES";
					return;
				}
			}
			
		}
	}
}
