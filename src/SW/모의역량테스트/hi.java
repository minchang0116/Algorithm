import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특이한자석sw {
   static final int MAX = 8;

   static class Wheel {
      int curPos;
      int data[];

      public Wheel() {
         data = new int[MAX];
      }

      void moveL() {
         curPos = (curPos + 1) % MAX;
      }

      void moveR() {
         curPos = (curPos + 7) % MAX;
      }

      int getLeft() {
         return data[(curPos + 6) % 8];
      }

      int getRight() {
         return data[(curPos + 2) % 8];
      }

      int getValue() {
         return data[curPos];
      }
   }

   static final int R = 1;
   static final int L = -1;

   static final int WMAX = 4;

   static class Simulator {
      Wheel wheels[];
      int chain[];

      public Simulator() {
         wheels = new Wheel[WMAX];
         for (int i = 0; i < WMAX; i++)
            wheels[i] = new Wheel();
         chain = new int[WMAX];
      }

      // 체이닝 여부 체크 Union집합 유사
      private void chainChk() {
         for (int i = 0; i < WMAX; i++)
            chain[i] = i;
         for (int i = 0; i < WMAX - 1; i++) {
            if (wheels[i].getRight() != wheels[i + 1].getLeft()) {
               chain[i + 1] = chain[i];
            }
         }
      }

      void rotateWheel(int move, int wIdx) {
         chainChk();
         int chk = chain[wIdx]; // 체이닝 값
         for (int i = 0; i < WMAX; i++) {
            if (chk == chain[i]) { // 체이닝 값이 같다면 회전
               if (Math.abs(wIdx - i) % 2 == 0) { // 같은 방향으로 회전
                  moveWheel(move, i);
               } else { // 반대 방향으로 회전
                  moveWheel(move * -1, i);
               }
            }
         }
      }

      void moveWheel(int move, int wIdx) {
         if (move == R)
            wheels[wIdx].moveR();
         else
            wheels[wIdx].moveL();

      }

      int getValue() {
         int val = 0;
         for (int i = 0; i < WMAX; i++) {
            val += wheels[i].getValue() << i;
         }
         return val;
      }
   }

   static int Tcase;
   static int K;
   static Simulator simulator;

   public static void main(String[] args) throws Exception {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder out = new StringBuilder();
      Tcase = Integer.parseInt(in.readLine().trim());
      for (int t = 1; t <= Tcase; t++) {
         simulator = new Simulator();
         K = Integer.parseInt(in.readLine().trim());
         for (int i = 0; i < WMAX; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < MAX; j++) {
               simulator.wheels[i].data[j] = Integer.parseInt(st.nextToken());
            }
         }

         for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int wIdx = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());
            simulator.rotateWheel(move, wIdx - 1);
         }

         int ans = 0;
         ans = simulator.getValue();
         out.append('#').append(t).append(' ').append(ans).append('\n');
      }
      System.out.print(out);
   }
}