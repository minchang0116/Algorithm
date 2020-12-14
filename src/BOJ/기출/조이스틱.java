package BOJ.기출;

public class 조이스틱 {
	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
	}
	
    public static int solution(String name) {
    	int answer = 0;
    	int arr[] = new int[name.length()];
    	
    	// 모든 인덱스에서 위아래로 갈때 최솟값 계산
    	for(int i=0; i<name.length(); i++) {
    		if(name.charAt(i) != 'A') {
    			int up = name.charAt(i) - 'A';
    			int down = 'Z' - name.charAt(i) +1;
    			arr[i] = Math.min(up, down);
    		}
    	}
    	
    	// 모든 위치에서 역으로 갈때 최단거리 계산
    	
    	
        return answer;
    }
    
}
