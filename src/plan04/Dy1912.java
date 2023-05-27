package plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dy1912 {
    /**
     * [1912 연속합]
     * <br>
     * n개의 정수로 이루어진 임의의 수열이 주어진다.<br>
     * 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.<br>
     * 단, 수는 한 개 이상 선택해야 한다.<br><br>
     * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.<br>
     * 여기서 정답은 12+21인 33이 정답이 된다.<br><br>
     * 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.<br>
     * 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.<br><br>
     * KeyPoint<br>
     * - 연속된 숫자가 오름차순 내림차순이라는 말이 없다.<br>
     *   즉, 오름차순 내림차순 짬봉이어도 상관없다는 말장난<br>
     * - 값이 많을 수록 Scanner보다는 BufferedReader가 빠르다<br>
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        StringTokenizer tokens = new StringTokenizer(reader.readLine());

        int max = -1001;
        int [] sum = new int[cnt + 1];
        int [] sort = new int[cnt + 1];

        for (int i = 1; i <= cnt; i++) {
            sort[i] = Integer.parseInt(tokens.nextToken());
            sum[i] = Math.max(sum[i-1] + sort[i], sort[i]);
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
        reader.close();
    }
}

