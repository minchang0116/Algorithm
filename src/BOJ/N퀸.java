package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N퀸 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        answer = 0;
        int board[] = new int[N];
        for(int i=0; i<N; i++){
            board[0] = i;
            dfs(1, board, N);
        }
        System.out.println(answer);
	}
    
    static int answer;
    private static void dfs(int idx, int[] board, int N){
        if(idx == N){
            answer++;
            return;
        }
        
        outer: for(int i=0; i<N; i++){
            for(int j=0; j<idx; j++){
                if(i - board[j] == idx - j || i - board[j] == j- idx || board[j] == i){
                    continue outer;
                }
            }
            board[idx] = i;
            dfs(idx+1, board, N);   
        }
    }
}
