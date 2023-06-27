package plan07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs2470 {
    /**
     * [2470 두 용액]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();

        int [] liquid = new int[N];
        for (int i = 0; i < N; i++) 
            liquid[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(liquid);

        // 어렵다

        reader.close();
    }
}
