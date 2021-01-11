package PROG.lv1;

import java.util.ArrayList;

public class 인형뽑기 {
	public static void main(String[] args) {
		인형뽑기 service = new 인형뽑기();
		System.out.println(service.solution(new int[][] {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
	}
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<moves.length; i++) {
        	for(int j=0; j<board.length; j++) {
        		if(board[j][moves[i]-1] != 0) {
        			if(arr.size() !=0 && arr.get(arr.size()-1) == board[j][moves[i]-1]){
        				arr.remove(arr.size()-1);
        				answer+= 2;
        				board[j][moves[i]-1] =0;
        				break;
        			}else {
        				arr.add(board[j][moves[i]-1]);
        				board[j][moves[i]-1] = 0;
        				break;
        			}
        		}
        	}
        }
        
        return answer;
    }
}
