package PROG.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		다리를지나는트럭 service = new 다리를지나는트럭();
		System.out.println(service.solution(2, 10, new int[] {7,4,5,6}));
	}
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> wait_truck = new LinkedList<Integer>();
        Queue<Truck> passing_truck = new LinkedList<Truck>();
        
        for(int i=0; i<truck_weights.length; i++) {
        	wait_truck.offer(truck_weights[i]);
        }
        int time =0;
        int cnt = 0;
        int curWeight = 0;
        while(cnt < truck_weights.length) {
        	
        	time++;
        	if(!wait_truck.isEmpty()) {
        		if(curWeight + wait_truck.peek() <= weight) {
        			curWeight += wait_truck.peek();
        			passing_truck.offer(new Truck(wait_truck.poll(), time+bridge_length-1));
        		}
        	}
        	
        	if(!passing_truck.isEmpty()) {
        		if(passing_truck.peek().time == time) {
        			curWeight -= passing_truck.poll().weight;
        			cnt++;
        		}
        	}
        	
        }
        
        return answer = time+1;
    }
    
    private class Truck{
    	int weight;
    	int time;
		public Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
    }
}
