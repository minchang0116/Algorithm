package PROG.lv2;

import java.util.Arrays;

public class 행렬테두리회전하기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 행렬테두리회전하기().solution(6,6,new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
	}
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows+1][columns+1];
        
        int num = 1;
        for(int i=1; i<=rows; i++) {
        	for(int j=1; j<=columns; j++) {
        		map[i][j] = num++;
        	}
        }
        
       
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
        	answer[i] = rotate(map, queries[i]);
        }
        return answer;
    }
	private int rotate(int[][] map, int[] queries) {
		int x1 = queries[0];
		int y1 = queries[1];
		int x2 = queries[2];
		int y2 = queries[3];
		
		int temp = map[x1][y1]; 
		int cx = x1;
		int cy = y1;
		int dx[] = new int[] {1,0,-1,0};
		int dy[] = new int[] {0,1,0,-1};
		int dir = 0;
		int min = map[x1][y1];
		while(true){
			if(cx == x1 && cy == y1+1) {
				map[cx][cy] = temp;
				return min;
			}
			
			if(cx+dx[dir] > x2 || cx+dx[dir] < x1
					|| cy+dy[dir] > y2 || cy+dy[dir] < y1) {
				dir++;
			}
			map[cx][cy] = map[cx+dx[dir]][cy+dy[dir]];
			cx+= dx[dir];
			cy+= dy[dir];
			if(min > map[cx][cy]) {
				min = map[cx][cy];
			}
		}
	}
}
