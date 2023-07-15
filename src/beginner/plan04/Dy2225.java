package beginner.plan04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Dy2225 {
    /**
     * [2225  합분해]
     * <br>
     * 덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). <br>
     * 또한 한 개의 수를 여러 번 쓸 수도 있다. <br>
     * N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200) <br>
     * 첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력 <br><br>
     * !!KeyPoint!!
     * <br>
     * i를 j개의 정수로 더해서 만들 수 있는 경우의 수 <br>
     * = <br>
     * 0 ~ i를 j - 1 개의 정수로 더해서 만들 수 있는 경우의 수 합산<br>
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer tokens = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());

        // i를 j개의 정수로 더해서 만들 수 있는 경우의 수
        int [] dp = new int[N+1];

        // 0 - i : 1 자리수 경우의수
        for (int i = 0; i <= N; i++)
            dp[i] = 1;

        for (int j = 1; j < K; j++) {
            for (int i = N - 1; i >= 0; i--)
                dp[i] = (dp[i] + dp[i+1]) % 1000000000;
        }

        System.out.println(dp[0]);
        sc.close();
    }
}
