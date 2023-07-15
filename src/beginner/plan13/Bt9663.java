package beginner.plan13;

import java.util.Scanner;

public class Bt9663 {
    /**
     * [9663 N-Queen]
     * <br>
     * 규칙을 최대한 loop가 아닌 N(1)의 시간이 걸리도록 찾는다
     * */
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean [][] queen = new boolean[N*2][4]; // 가로 세로 10시 2시
        count = 0;
        backTrack(queen, 0, N);

        System.out.println(count);
        sc.close();
    }

    private static void backTrack(boolean [][] queen, int s, int n) {
        if (n == 0){
            count++;
            return;
        }

        // backtracing
        for (int i = 0; i < queen.length / 2; i++) {
            if (queen[s][0] || queen[i][1] || queen[queen.length / 2 + s - i][2] || queen[i + s][3])
                continue;
            queen[s][0] = true; // 가로
            queen[i][1] = true; // 세로
            queen[queen.length / 2 + s - i][2] = true;// 10시
            queen[i+s][3] = true;// 2시
            backTrack(queen, s + 1, n - 1);
            queen[s][0] = false;
            queen[i][1] = false;
            queen[queen.length / 2 + s - i][2] = false;
            queen[i+s][3] = false;
        }
    }

}
