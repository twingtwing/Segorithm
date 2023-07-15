package beginner.plan13;

import java.util.Scanner;

public class Bt9663_1 {
    /**
     * [9663 N-Queen]
     * <br>
     * !!keyPoint!!
     * 대각선 선상 확인 => 두 점의 x와 y의 차이 값이 일치
     * */
    private static int N;
    private static int count;
    private static int [] col; // 각 행별로 퀸이 위치한 열의 인덱스
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        count = 0;
        col = new int[N];

        backTrack(0); // 행을 기준으로 백트래킹을 실행한다.

        System.out.println(count);
        sc.close();
    }

    private static void backTrack(int row) {
        if (row == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;
            if (isPossible(row)) // 다음행에 공간이 있는지 확인
                backTrack(row + 1);
        }
    }

    private static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) { // 그 전의 행까지만 퀸이 존재하므로 그 전까지만 값을 구한다
            // 같은 열에 퀸이 위치하거나 대각선 상에 퀸이 위치하는 경우
            // 두 점의 x와 y의 차이 값이 일치하면 대각선에 위치한다.
            if (col[i] == col[row] || Math.abs(col[i] - col[row]) == row - i)
                return false;
        }
        return true;
    }
}
