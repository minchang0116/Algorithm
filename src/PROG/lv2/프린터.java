package PROG.lv2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터 {
	public static void main(String[] args) {
		프린터 service = new 프린터();
		System.out.println(service.solution(new int[] {2,1,3,2}, 2));
	}
	
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i< priorities.length; i++) {
        	pq.offer(priorities[i]);
        	q.offer(priorities[i]);
        }
        
        while(true) {
        	int temp = q.poll();
        	if(pq.peek() == temp) {
        		answer++;
        		if(location == 0) {
        			break;
        		}
        		pq.poll();
        	}
        	else {
        		q.offer(temp);
        	}
        	
        	location--;
        	if(location == -1) {
    			location = q.size()-1;
    		}
        }
        return answer;
    }
}
