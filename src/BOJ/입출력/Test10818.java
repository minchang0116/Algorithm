package BOJ.입출력;

import java.util.Scanner;

public class Test10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1000000;
		int min = 1000000;
		int no = sc.nextInt();
		for(int i=0; i<no; i++) {
			int input = sc.nextInt();
			if(input <min) {
				min = input;
			}
			if(input> max) {
				max = input;
			}
		}
		
		System.out.println(min + " " + max);
		sc.close();
	}

}
