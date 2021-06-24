package PROG.lv1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		문자열내림차순으로배치하기 service = new 문자열내림차순으로배치하기();
		service.solution("Zbcdefg");
	}
    public String solution(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new StringBuilder(new String(arr)).reverse().toString();
    }
}
