package beginner.plan12;

import java.util.Scanner;

public class Tp1644 {
    /**
     * [1644 소수의 연속합]
     * <br>
     * 1은 소수가 아니다!!
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean [] minor = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (minor[i])
                continue;
            for (int j = i * 2; j <= N; j += i)
                minor[j] = true;
        }

        int sum = 2;
        int count = 0;
        for (int i = 2, j = 2; i <= N; i++) {
            if (minor[i])
                continue;
            while (j < N && sum < N) {
                if (minor[++j])
                    continue;
                sum += j;
            }
            if (sum == N)
                count++;
            sum -= i;
        }

        System.out.println(count);
        sc.close();
    }
}
