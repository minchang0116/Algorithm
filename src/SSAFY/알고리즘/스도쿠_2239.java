package SSAFY.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 스도쿠_2239 {
	static char map[][];
	static ArrayList<int[]> nList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[9][9];
		nList = new ArrayList<>();
		for(int i=0; i<9; i++) {
			String s = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					nList.add(new int[] {i,j});
				}
			}
		}
		
		dfs(0, 0, 0);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	static boolean flag;
	static void dfs(int x, int y, int idx){
		if(nList.size() == idx) {
			flag = true;
			return;
		}
		
		int sx = nList.get(idx)[0];
		int sy = nList.get(idx)[1];
		for(int n=1; n<=9; n++) {
			map[sx][sy] = (char)(n +'0');
			if(check(sx, sy)) {
				dfs(sx, sy, idx+1);
			}
			if(flag == true) {
				return;
			}
			map[sx][sy] = '0';
			
		}
	}
	
	static boolean check(int x, int y) {
		for(int i=0; i<9; i++) {
			//행체크
			if(map[x][i] == map[x][y] && i!=y) {
				return false;
			}
			//열체크
			if(map[i][y] == map[x][y] && i!=x) {
				return false;
			}
		}
		//범위체크
		int sx = (x/3)*3;
		int sy = (y/3)*3;
		for(int i=sx; i<sx+3; i++) {
			for(int j=sy; j<sy+3; j++) {
				if(map[i][j] == map[x][y] && i!=x  && i!=y) {
					return false;
				}
			}
		}
		
		return true;
	}
}
