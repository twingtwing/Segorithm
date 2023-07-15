package beginner.plan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gd11047 {
    /**
     * [11047 동전 0]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int [] money = new int[N];

        for (int i = 0; i < N; i++)
            money[i] = Integer.parseInt(reader.readLine());

        int cnt = 0;
        int m = Integer.parseInt(input[1]);
        for (int i = N-1; i >= 0; i--) {
            if (m == 0)
                break;
            if (m < money[i])
                continue;
            cnt += m / money[i];
            m -= money[i] * (m / money[i]);
        }

        System.out.println(cnt);
        reader.close();
    }
}
