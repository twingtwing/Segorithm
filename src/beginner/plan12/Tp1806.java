package beginner.plan12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tp1806 {
    /**
     * [1806 부분합]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int S = Integer.parseInt(tokens.nextToken());
        int [] seq = new int[N];

        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(tokens.nextToken());

        int s = 0;
        int e = 1;
        int sum = seq[0];
        int len = Integer.MAX_VALUE;
        while (s < e) {
            while (e < seq.length){
                if (sum >= S)
                    break;
                sum += seq[e++];
            }
            if (sum >= S)
                len = Math.min(len, e - s);
            if (len == 1)
                break;
            sum -= seq[s++];
        }

        if (len == Integer.MAX_VALUE)
            len = 0;
        System.out.println(len);
        reader.close();
    }
}
