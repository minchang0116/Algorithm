package BOJ.IM대비;

import java.util.Scanner;

public class Main14696_딱지놀이 {
	public static void main(String[] args) {
		// 별 4 동그라미 3 네모 2 세모 1
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		outer: for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int checkA[] = new int[5]; 
			for(int j=0; j<a; j++) {
				checkA[sc.nextInt()]++;
			}
			int b = sc.nextInt();
			int checkB[] = new int[5];
			for(int j=0; j<b; j++) {
				checkB[sc.nextInt()]++;
			}
			
			// 별 > 동그라미 > 네모  > 세모
			for(int j=4; j>0; j--) {
				if(checkA[j]-- != 0 ) { // 별이 있으면
					if(checkB[j]-- != 0) {	// 별이 있으면
						j++;
					}
					else {	// 없으면 A이김
						System.out.println("A");
						continue outer;
					}
				}
				else {	// 별이 없으면
					if(checkB[j] == 0) { // 별이 없으면
						
					}
					else {
						System.out.println("B");
						continue outer;
					}
				}
			}
			System.out.println("D");
			
		}
	}
}
