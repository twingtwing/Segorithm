package ibeginner.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Eu9613 {
    /**
     * [9613 GCD 합]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringTokenizer tokens;
        while (N-- > 0){
            long total = 0;
            tokens = new StringTokenizer(reader.readLine());
            int [] gcd = new int[Integer.parseInt(tokens.nextToken())];
            for (int i = 0; i < gcd.length; i++)
                gcd[i] = Integer.parseInt(tokens.nextToken());

            for (int i = 0; i < gcd.length - 1; i++) {
                for (int j = i + 1; j < gcd.length; j++) {
                    int max = Math.max(gcd[i], gcd[j]);
                    int min = Math.min(gcd[j], gcd[i]);
                    while (min > 0){
                        int tmp = max;
                        max = min;
                        min = tmp % min;
                    }

                    total += max;
                }
            }
            System.out.println(total);
        }

        reader.close();
    }
}
