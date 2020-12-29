package PROG.lv3;

import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		디스크컨트롤러 service = new 디스크컨트롤러();
		System.out.println(service.solution(new int[][] {{0,3}, {1,9}, {2,6}}));
	}
	
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> ready = new PriorityQueue<int[]>((o1,o2)->{
        	return Integer.compare(o1[0], o2[0]);
        });
        
        PriorityQueue<int[]> wait = new PriorityQueue<int[]>((o1,o2)->{
        	return Integer.compare(o1[1], o2[1]);
        });
        
        for(int i=0; i<jobs.length; i++) {
        	ready.offer(jobs[i]);
        }
        int time=0;
        while(true) {
        	while(!ready.isEmpty()) {
        		if(ready.peek()[0] <= time) {
        			wait.offer(ready.poll());
        		}
        		else break;
        	}
        	
        	if(!wait.isEmpty()) {
        		int temp[] = wait.poll();
        		answer += (time - temp[0]) + temp[1];
        		System.out.println((time - temp[0]) + temp[1]);
        		time += temp[1];
        	}
        	else {
        		time = ready.peek()[0] - time;
        	}
        	
        	if(ready.isEmpty() && wait.isEmpty()) break;
        }
        return answer/jobs.length;
    }
}
