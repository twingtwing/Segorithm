package ibeginner.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps10986 {
    /**
     * [10986 나머지 합]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        long [] nums = new long[Integer.parseInt(tokens.nextToken()) + 1];
        int M = Integer.parseInt(tokens.nextToken());

        long count = 0;
        long [] mods = new long[M];
        tokens = new StringTokenizer(reader.readLine());
        for (int i = 1; i < nums.length; i++) {
            nums[i] = (nums[i - 1] + Long.parseLong(tokens.nextToken())) % M;
            count += mods[(int) nums[i]];
            mods[(int) nums[i]]++;
            if (nums[i] == 0)
                count++;

        }

        System.out.println(count);
        reader.close();
    }
}
