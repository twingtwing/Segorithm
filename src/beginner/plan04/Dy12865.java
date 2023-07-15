package beginner.plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dy12865 {
    /**
     * [12865 평범한 배낭]
     * <br>
     *  무게 (1 ≤ W ≤ 100,000), 가치(0 ≤ V ≤ 1,000)<br>
     *  가치합의 최댓값을 출력
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());

        int [] wgts = new int[N + 1];
        int [] vals = new int[N + 1];
        int [][] dp = new int[N+1][W+1]; // 이중 배열을 이용해서 계산기록을 남겨둔다.

        for (int i = 1; i <= N; i++) {
            token = new StringTokenizer(reader.readLine());
            wgts[i] = Integer.parseInt(token.nextToken());
            vals[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (wgts[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wgts[i]] + vals[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][W]);
        reader.close();
    }
}
