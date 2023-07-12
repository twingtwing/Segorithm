package plan13;

import java.util.Scanner;

public class Bt9663 {
    /**
     * [9663 N-Queen]
     * */
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][] queen = new int[N][N];
        count = 0;
        if (N > 8){
            for (int i = 0; i < N; i++) 
                backTrack(queen, i, 0, N);
        }
        System.out.println(count);
        sc.close();
    }

    private static void backTrack(int[][] queen, int s, int e, int n) {
        if (n == 0){
            count++;
            return;
        }
        queen[s][e] = 1;
        for (int i = 0; i < queen.length; i++) {
        }
    }
}
