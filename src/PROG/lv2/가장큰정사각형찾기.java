package PROG.lv2;

public class 가장큰정사각형찾기 {
	public static void main(String[] args) {
		가장큰정사각형찾기 service = new 가장큰정사각형찾기();
		System.out.println(service.solution(new int[][] {{0,1,1,1}, {1,1,1,1},{1,1,1,1},{0,0,1,0}}));
	}

    public int solution(int [][]board)
  {
  	answer= 1;
      for(int i=0; i<board.length; i++) {
      	for(int j=1; j<board[i].length; j++) {
      		if(board[i][j] == 1) {
      			board[i][j] += board[i][j-1];
      		}
      	}
      }

      for(int i=0; i<board.length; i++) {
      	for(int j=0; j<board[i].length; j++) {
      		if(flag==true && board[i][j] <= answer) continue;
      		if(board[i][j] > 1) { // 4
      			if(i+1 <board.length) {
      				dfs(i+1, j, board, board[i][j], 2);
      			}
      		}
      	}
      }
      
      return answer*answer;
  }
  static int answer;
  static boolean flag;
	private void dfs(int x, int y, int[][] board, int target, int depth) {
		if(board[x][y] < target) target = board[x][y];
		if(depth >= target) { // 초기 depth 2
			answer = Math.max(answer, target);
			flag= true;
		}
		else if(x+1 <board.length && board[x+1][y] != 0) {
			dfs(x+1, y, board, target, depth+1);
		}
	}


}
