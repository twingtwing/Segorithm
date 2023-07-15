package beginner.plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dy14501 {
    /**
     * [14501 퇴시]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        int [] sum = new int[cnt + 2];

        int idx;
        StringTokenizer tokens;
        for (int i = 1; i <= cnt; i++){
            sum[i] = Math.max(sum[i], sum[i-1]);
            tokens = new StringTokenizer(reader.readLine());
            idx = Integer.parseInt(tokens.nextToken()) + i;
            if (idx > cnt + 1) continue;
            sum[idx] = Math.max(sum[idx], sum[i] +  Integer.parseInt(tokens.nextToken()));
        }

        System.out.println(Math.max(sum[cnt+1], sum[cnt]));
        reader.close();
    }
}
