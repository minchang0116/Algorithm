package PROG.lv2;

import java.util.Arrays;

public class 행렬의곱셈 {
	public static void main(String[] args) {
		행렬의곱셈 service = new 행렬의곱셈();
		System.out.println(Arrays.toString(service.solution(new int[][] {{1, 4}, {3, 2}, {4, 1}}, 
				new int[][] {{3, 3}, {3, 3}})));
	}
    public int[][] solution(int[][] arr1, int[][] arr2) {
    	
    	int[][] answer = new int[arr1.length][arr2[0].length];
    	for(int i=0; i<arr1.length; i++) { // 첫번쨰의 행 갯수
    		for(int j=0; j<arr2[0].length; j++) { // 두번째의 열 갯수
    			answer[i][j] = solve(i, j, arr1, arr2);
    		}
    	}
        return answer;
    }
	private int solve(int i, int j, int[][] arr1, int[][] arr2) {
		int sum = 0;
		// i는 행 시작 , j는 열 시작
		for(int k=0; k<arr1[0].length; k++) {
				sum = arr1[i][k]*arr2[k][j] + sum;
		}
		return sum;
	}
}
