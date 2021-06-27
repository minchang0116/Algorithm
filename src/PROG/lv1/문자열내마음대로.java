package PROG.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로 {
	public static void main(String[] args) {
		문자열내마음대로 service = new 문자열내마음대로();
		service.solution(new String[] {"abcd", "abce", "cdx"}, 1);
	}
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		if(o1.charAt(n) == o2.charAt(n)) 
        			return o1.compareTo(o2);
        		else
        			return Character.compare(o1.charAt(n), o2.charAt(n));
        	}
		});
        return strings;
    }
}
