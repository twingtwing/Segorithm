package beginner.plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dy1932 {
    /**
     * [1932 정수 삼각형]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int [][] trianle = new int[501][501];
        trianle[1][1] = Integer.parseInt(reader.readLine());

        StringTokenizer tokens;
        int max = trianle[1][1];
        for (int i = 2; i <= len; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= i; j++) {
                if (j == 1)
                    trianle[i][j] = trianle[i-1][j] + Integer.parseInt(tokens.nextToken());
                else if (j == i)
                    trianle[i][j] = trianle[i-1][j - 1] + Integer.parseInt(tokens.nextToken());
                else
                    trianle[i][j] = Math.max(trianle[i-1][j-1],trianle[i-1][j])+
                            Integer.parseInt(tokens.nextToken());

                max = Math.max(max, trianle[i][j]);
            }
        }

        System.out.println(max);
        reader.close();
    }
}
