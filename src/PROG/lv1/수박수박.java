package PROG.lv1;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] subac = {'수', '박'};
        for(int i=0; i<n; i++){
            sb.append(subac[i%2]);            
        }
        answer = sb.toString();
        return answer;
    }
}