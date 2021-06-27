package PROG.lv1;

public class 김서방찾기 {
	public static void main(String[] args) {
		김서방찾기 service = new 김서방찾기();
		service.solution(new String[] {"Jane", "Kim"});
	}
    public String solution(String[] seoul) {
    	int idx = 0;
    	for(int i=0; i<seoul.length; i++) {
    		if(seoul[i].equals("Kim")) {
    			idx=i;
    			break;
    		}
    	}
        return "김서방은 " + idx + "에 있다";
    }
}
