package beginner.plan12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw21921 {
    /**
     * [21921 블로그]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int X = Integer.parseInt(tokens.nextToken());
        int [] visited = new int[N];

        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            visited[i] = Integer.parseInt(tokens.nextToken());

        int s = 0;
        int sum = 0;
        int count = 1;
        for (int i = s; i < X; i++) {
            sum += visited[i];
        }

        int max = sum;
        for (int e = X; e < N; e++) {
            sum += (visited[e] - visited[s++]);
            if (sum > max){
                max = sum;
                count = 1;
            }else if (sum == max)
                count++;
        }

        if (max == 0)
            System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(count);
        }
        reader.close();
    }
}
