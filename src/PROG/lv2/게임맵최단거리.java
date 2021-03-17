package PROG.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	public static void main(String[] args) {
		게임맵최단거리 service = new 게임맵최단거리();
		System.out.println(service.solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = 1;
        Queue<int []> q = new LinkedList<int[]>();
        boolean visited[][] = new boolean [maps.length][maps[0].length];
        visited[0][0] = true;
        q.offer(new int[] {0,0});
        boolean success = false;
        outer: while(!q.isEmpty()) {
        	answer++;
        	int qSize = q.size();
        	for(int qs = 0; qs<qSize; qs++) {
        		int xy[] = q.poll();
        		for(int i=0; i<4; i++) {
        			int nx = xy[0] + dx[i];
        			int ny = xy[1] + dy[i];
        			if(nx <0 || nx >= maps.length || ny<0 || ny>=maps[0].length || visited[nx][ny] == true || maps[nx][ny] == 0)continue;
        			if(nx == maps.length-1 && ny == maps[0].length-1) {
        				success = true;
        				break outer;
        			}
        			visited[nx][ny] = true;
        			q.offer(new int[] {nx, ny});
        		}
        	}
        }
        if(success == true) {
        	return answer;
        }
        else {
        	return -1;
        }
    }
}
