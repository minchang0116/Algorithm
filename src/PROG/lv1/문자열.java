package PROG.lv1;

public class 문자열 {

	public static void main(String[] args) {
		문자열 service = new 문자열();
		System.out.println(service.solution("1a234"));
	}
    public boolean solution(String s) {
    	if(s.length() == 4 || s.length() == 6) {
    		for(int i=0; i<s.length(); i++) {
    			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
    			}
    			else {
    				return false;
    			}
    		}
    		return true;
    	}
        return false;
    }
}
