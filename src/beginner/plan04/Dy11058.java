package beginner.plan04;

import java.util.Scanner;

public class Dy11058 {
    /**
     * [11058 크리보드]
     * <br>
     * N(1 ≤ N ≤ 100)
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long [] out = new long[101];

        for (int i = 1; i <= num; i++) {
            if (i < 7)
                out[i] = i;
            else{
                for (int j = 3; j <= i - 3; j++)
                    out[i] = Math.max(out[i], out[j] * (i - j - 1));
            }
        }

        System.out.println(out[num]);
        scanner.close();
    }
}
