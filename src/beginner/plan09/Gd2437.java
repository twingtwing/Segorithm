package beginner.plan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gd2437 {
    /**
     * [2437 저울]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int [] wgt = new int[N];
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        while (N-- > 0)
            wgt[N] = Integer.parseInt(tokens.nextToken());

        Arrays.sort(wgt);

        int sum = 0;
        for (int i = 0; i < wgt.length; i++) {
            if (sum < wgt[i] - 1)
                break;
            sum += wgt[i];
        }

        System.out.println(sum + 1);
        reader.close();
    }
}
