package ibeginner.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps11660 {
    /**
     * [11660 구간 합 구하기 5]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        int [][] seq = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++)
                seq[i][j] = Integer.parseInt(tokens.nextToken())
                        + seq[i][j - 1] + seq[i - 1][j] - seq[i - 1][j - 1];
        }

        StringBuilder result = new StringBuilder();
        while (M-- > 0){
            tokens = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(tokens.nextToken()) - 1;
            int y1 = Integer.parseInt(tokens.nextToken()) - 1;
            int x2 = Integer.parseInt(tokens.nextToken());
            int y2 = Integer.parseInt(tokens.nextToken());
            result.append(seq[x2][y2] + seq[x1][y1] - seq[x2][y1] - seq[x1][y2]).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}
