package SW.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 활주로건설 {
    static int map[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
             
            map = new int [N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
             
            int result =0;
            // 수평부터 검사
            outer: for(int i=0; i<N; i++) {
                boolean check[] = new boolean[N];
                for(int j=0; j<N-1; j++) {
                    if(map[i][j] < map[i][j+1]) {
                        if(map[i][j+1] - map[i][j] != 1) // 2칸이상차이나면 안됨
                            continue outer;
                        int temp = j+1;
                        int cnt = X;
                        int idx = 0;
                        while(true) {
                            if(idx == cnt) {
                                break;
                            }
                            if(j-idx <0 || check[j-idx] == true || map[i][temp] -map[i][j-idx] >1) {
                                continue outer;
                            } // 이미 경사로가 지어져있거나 // 높이가 2차이나면
                            check[j-idx] = true;
                            idx++;
                        }
                         
                    }
                    else if(map[i][j] > map[i][j+1]) { // 앞에께 더클때
                        if(map[i][j+1] - map[i][j] != -1) // 2칸이상차이나면 안됨
                            continue outer;
                        int temp = j;
                        int cnt = X;
                        int idx = 1;
                        while(true) {
                            if(idx == cnt+1) {
                                break;
                            }
                            if(j+idx >=N || check[j+idx] == true || map[i][temp] -map[i][j+idx] >1) {
                                continue outer;
                            } // 이미 경사로가 지어져있거나 // 높이가 2차이나면
                            check[j+idx] = true;
                            idx++;
                        }
                    }
                } // j반복 끝
                result +=1;
            }
             
            // 이제 수직 검사
            outer: for(int j=0; j<N; j++) {
                boolean check[] = new boolean[N];
                for(int i=0; i<N-1; i++) {
                    if(map[i][j] < map[i+1][j]) { // 현재가 더작을때
                        if(map[i+1][j] - map[i][j] != 1) // 2칸이상차이나면 안됨
                            continue outer;
                        int temp = i+1;
                        int cnt = X;
                        int idx = 0;
                        while(true) {
                            if(idx == cnt) {
                                break;
                            }
                            if(i-idx <0 || check[i-idx] == true || map[temp][j] -map[i-idx][j] >1) {
                                continue outer;
                            } // 이미 경사로가 지어져있거나 // 높이가 2차이나면
                            check[i-idx] = true;
                            idx++;
                        }
                         
                    }
                    else if(map[i][j] > map[i+1][j]) { // 앞에께 더클때
                        if(map[i+1][j] - map[i][j] != -1) // 2칸이상차이나면 안됨
                            continue outer;
                        int temp = i;
                        int cnt = X;
                        int idx = 1;
                        while(true) {
                            if(idx == cnt+1) {
                                break;
                            }
                            if(i+idx >=N || check[i+idx] == true || map[temp][j] -map[i+idx][j] >1) {
                                continue outer;
                            } // 이미 경사로가 지어져있거나 // 높이가 2차이나면
                            check[i+idx] = true;
                            idx++;
                        }
                    }
                } // j반복 끝
                result +=1;
            }
             
            System.out.println("#"+t+ " "+result);
             
        }
    }
}