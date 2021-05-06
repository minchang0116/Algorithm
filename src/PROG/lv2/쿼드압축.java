package PROG.lv2;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        solve(arr, 0, 0, arr.length, answer);

        return answer;
    }
    static void solve(int[][] arr, int sx, int sy, int length, int[] answer){
        for(int i=sx; i<sx+length; i++){
            for(int j=sy; j<sy+length; j++){
                if(arr[i][j] != arr[sx][sy]){ // 다르면 재귀
                    solve(arr, sx, sy, length/2, answer);
                    solve(arr, sx+length/2, sy, length/2, answer);
                    solve(arr, sx, sy+length/2, length/2, answer);
                    solve(arr, sx+length/2, sy+length/2, length/2, answer);
                    return;
                }
            }
        }
        answer[arr[sx][sy]] += 1;
    }
}