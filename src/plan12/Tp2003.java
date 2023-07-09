package plan12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tp2003 {
    /**
     * [2003 수들의 합 2]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        int [] sort = new int[N];
        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            sort[i] = Integer.parseInt(tokens.nextToken());

        int s = -1;
        int e = 0;
        int count = 0;
        int sum = sort[e];
        while (s <= e && s < sort.length - 1){
            while (e < sort.length - 1){
                if (sum >= M)
                    break;
                sum += sort[++e];
            }
            if (sum == M)
                count++;
            sum -= sort[++s];
        }

        System.out.println(count);
        reader.close();
    }
}
