package PROG.lv1;

import java.util.Arrays;

public class K번째수 {
	public static void main(String[] args) {
		K번째수 service = new K번째수();
		int temp[] = service.solution(new int[] {1,5,2,6,3,7,4}, new int[][] {{2,5,3},{4,4,1},{1,7,3}});
		for(int i=0; i<temp.length; i++) {
			System.out.println(temp[i]);
		}
	}
	
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
        	int arr[] = new int[commands[i][1]-commands[i][0]+1];
    		for(int k=commands[i][0]-1; k<commands[i][1]; k++) {
    			arr[k-(commands[i][0]-1)] = array[k];
    		}
    		Arrays.sort(arr);
    		answer[i] = arr[commands[i][2]-1];
        }
        return answer;
    }
}
