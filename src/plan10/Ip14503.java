package plan10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ip14503 {
    /**
     * [14503 로봇 청소기]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int [][] room = new int[N + 1][M + 1];

        tokens = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(tokens.nextToken());
        int y = Integer.parseInt(tokens.nextToken());
        int way = Integer.parseInt(tokens.nextToken());


        reader.close();
    }
}
