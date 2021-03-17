package PROG.lv2;

import java.util.Arrays;

public class 삼각달팽이 {
	public static void main(String[] args) {
		삼각달팽이 service = new 삼각달팽이();
		System.out.println(Arrays.toString(service.solution(4)));
	}
	
	static int dir[][] = {{1,0},{0,1},{-1,-1}}; //하 우 왼위
    public int[] solution(int n) {
    	int goalCnt = n*(n+1)/2;
    	int[] answer = new int[goalCnt];

    	int triangle[][] = new int[n][n];
        int x = 0;
        int y = 0;
        int curDir = 0;
        int curCnt = 1;
        int tempN = n;
        triangle[0][0] = 1;
        int idx = 1;
        while(true) {
        	if(curCnt == goalCnt) break;
        	curCnt++;
        	idx++;
        	x+= dir[curDir][0];
        	y+= dir[curDir][1];
        	triangle[x][y] = curCnt;
        	if(idx == tempN) {
        		idx = 0;
        		curDir = (curDir+1)%3;
        		tempN--;
        	}
        }
        tempN = 1;
        idx=0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<tempN; j++) {
        		answer[idx++] = triangle[i][j];
        	}
        	tempN++;
        }
        return answer;
    }
}
