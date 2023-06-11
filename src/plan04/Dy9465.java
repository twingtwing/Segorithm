package plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dy9465 {
    /**
     * [9465 스티커]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        int max;
        int len;
        int [][] dp = new int[2][100001];
        StringTokenizer top;
        StringTokenizer bottom;
        while (cnt -- > 0){
            len = Integer.parseInt(reader.readLine());
            top = new StringTokenizer(reader.readLine());
            bottom = new StringTokenizer(reader.readLine());

            dp[0][1]= Integer.parseInt(top.nextToken());
            dp[1][1] = Integer.parseInt(bottom.nextToken());
            for (int i = 2; i <= len; i++) {
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + Integer.parseInt(top.nextToken());
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + Integer.parseInt(bottom.nextToken());
            }
            max = Math.max(dp[0][len], dp[1][len]);
            result.append(max).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}
