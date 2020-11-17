package SW.모의역량;

import java.util.ArrayList;

public class 프로그_자물쇠와열쇠 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1,1,1},{1,1,0},{1,0,1}}));
	}
	
    public static boolean solution(int[][] key, int[][] lock) {
    	ArrayList<int []> key1 = new ArrayList<int[]>();
    	ArrayList<int []> lock1 = new ArrayList<int[]>();
    	boolean answer = true;
    	for(int i=0; i<key.length; i++) {
    		for(int j=0; j<key.length; j++) {
    			if(key[i][j] == 1) {
    				key1.add(new int[] {i,j});
    			}
    		}
    	}
    	for(int i=0; i<lock.length; i++) {
    		for(int j=0; j<lock.length; j++) {
    			if(lock[i][j] == 0) {
    				lock1.add(new int[] {i,j});
    			}
    		}
    	}
    	
    	if(move(key1, lock1, key.length, lock.length)) {
			return answer;
		}
    	for(int i=0; i<3; i++) {
    		rotation();
    		if(move(key1, lock1, key.length, lock.length)) {
    			return answer;
    		}
    	}
    	answer = false;
        return answer;
    }

	private static void rotation() {
		// TODO Auto-generated method stub
		
	}

	private static boolean move(ArrayList<int[]> key1, ArrayList<int[]> lock1, int kl, int ll) {
		// 처음 시작을 왼쪽위로 이동한 상태에서 시작해야되네 키 길이가 3이면 2만큼옮김
		for(int i=0; i<key1.size(); i++) {
			key1.get(i)[0] -= (kl-1);
			key1.get(i)[1] -= (kl-1);
		}
		
		int dir = 1;
		for(int i=0; i<ll+(kl-1); i++) {
			for(int j=0; j<ll+(kl-1); j++) {
				if(check(key1, lock1, ll)) {
					return true;
				};
				for(int k=0; k<key1.size(); k++) {
					key1.get(k)[1] += dir; // 오른쪽 or 왼쪽으로 한칸씩 이동
				}
			}
			dir *= -1;
		}
		return false;
	}

	private static boolean check(ArrayList<int[]> key1, ArrayList<int[]> lock1, int ll) {
		int lockCnt = lock1.size();
		outer: for(int i=0; i<key1.size(); i++) {
			int x = key1.get(i)[0];
			int y = key1.get(i)[1];
			if(x <0 || x >= ll || y<0 || y>= ll) continue;
			for(int j=0; j<lock1.size(); j++) {
				if(x == lock1.get(j)[0]) {
					if(y == lock1.get(j)[1]) {
						lockCnt--;
						continue outer;
					}
				}
			}
			return false;
		}
		if(lockCnt != 0) return false;
		return true;
	}
}

