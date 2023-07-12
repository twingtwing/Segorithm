package plan13;

import java.util.Scanner;

public class Bt9663_2 {
    /**
     * [9663 N-Queen]
     * <br>
     * !!keyPoint!!
     * 대각선 선상 값을 따로 저장한다.
     * */
    private static int N;
    private static int count;
    private static int [] col; // 열의 값을 저장하는 배열
    private static int [] ten; // \ 배열
    private static int [] two; // / 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        count = 0;
        ten = new int[N * 2 - 1];
        two = new int[N * 2 - 1];
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
            // 행을 기준으로 백트래킹을 진행하므로 행은 체크하지 않느다.
            if (col[i] == 1 || ten[N + row - i - 1] == 1 || two[row + i] == 1)
                continue;
            col[i] = 1;
            ten[N + row - i - 1] = 1;
            two[row + i] = 1;
            backTrack(row + 1);
            col[i] = 0;
            ten[N + row - i - 1] = 0;
            two[row + i] = 0;
        }
    }

}
