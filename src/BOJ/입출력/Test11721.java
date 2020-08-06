package BOJ.입출력;

import java.util.Scanner;

public class Test11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for(int i=0; i<s.length(); i++) {
			if(i % 10 == 0 && i !=0) {
				System.out.println();
			}
			System.out.print(s.charAt(i));
		}

	}

}
