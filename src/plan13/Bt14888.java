package plan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bt14888 {
    /**
     * [14888 연산자 끼워넣기]
     * */
    private static int max;
    private static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int [] A = new int[N];
        int [] sums = new int[4]; // + - x /
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 4; i++)
            sums[i] = Integer.parseInt(tokens.nextToken());

        reader.close();
    }
}
