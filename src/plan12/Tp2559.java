package plan12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tp2559 {
    /**
     * [2559 수열]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
        int [] temp = new int[N];

        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            temp[i] = Integer.parseInt(tokens.nextToken());

        int s = 0;
        int e = K;
        int sum = 0;
        for (int i = s; i < K; i++)
            sum += temp[i];

        int max = sum;

        while (e < N){
            sum -= temp[s++];
            sum += temp[e++];
            max = Math.max(max, sum);
        }

        System.out.println(max);
        reader.close();
    }
}
