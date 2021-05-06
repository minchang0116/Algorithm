package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		String boom = br.readLine();
		int front = 0;
		while (true) {
			boolean flag = false;
			int index = sb.indexOf(str)
			if (sb.indexOf(boom, front) > 1) {
				flag = true;
			}
			if (flag == false || sb.length() == 0) {
				break;
			}
		}
		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb.toString());
		}
	}
}
