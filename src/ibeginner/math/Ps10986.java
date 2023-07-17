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
        int [] nums = new int[Integer.parseInt(tokens.nextToken()) + 1];
        int M = Integer.parseInt(tokens.nextToken());

        int s = 0;
        int e = 0;
        tokens = new StringTokenizer(reader.readLine());
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + Integer.parseInt(tokens.nextToken());
            if(nums[i] < M) e = i;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

        }

        while (s < e){
            if (nums[e] - nums[s] > M){
                if (nums[e] - nums[s++] == M)
                    count++;
            }
            else if (nums[e] - nums[s] < M)
                e++;
        }

        System.out.println(count);
        reader.close();
    }
}
