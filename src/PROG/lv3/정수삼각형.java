package PROG.lv3;

public class 정수삼각형 {
	public static void main(String[] args) {
		정수삼각형 service = new 정수삼각형();
		System.out.println(service.solution(new int[][] {{7},{3,8},{8,1,0},{2, 7, 4, 4},{4, 5, 2, 6, 5}}));
	}
    public int solution(int[][] triangle) {
        int memo[][] = new int[triangle.length][];
        for(int i=0; i<memo.length; i++) {
        	memo[i] = triangle[i].clone();
        }
        
        for(int i=triangle.length-1; i>=1; i--) {
        	for(int j=0; j<triangle[i].length; j++) {
        		if(j == 0) { // 첫번째 값 처리
        			memo[i-1][j] +=  memo[i][j];
        		}
    			else if(j == triangle[i].length - 1 ) { // 마지막 값 처리
        			if(memo[i-1][j-1] < triangle[i-1][j-1] + memo[i][j]) {
        				memo[i-1][j-1] = triangle[i-1][j-1] + memo[i][j];
        			}
        		}
    			else {
    				if(memo[i-1][j-1] < triangle[i-1][j-1] + memo[i][j]) // 중간값 처리
    					memo[i-1][j-1] = triangle[i-1][j-1] + memo[i][j];
    				if(memo[i-1][j] < triangle[i-1][j] + memo[i][j]) // 중간값 처리
    					memo[i-1][j] = triangle[i-1][j] + memo[i][j];
    			}
        	}
        }
        return memo[0][0];
    }
}
