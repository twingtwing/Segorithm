package plan10;

import javax.management.openmbean.CompositeType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ip14499 {
    /**
     * [14499 주사위 굴리기]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int x = Integer.parseInt(tokens.nextToken());
        int y = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());

        int [][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(tokens.nextToken());
        }

        // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        int i = 0;
        int s = 0;
        int e = 1;
        int [] idx = new int[7];
        int [][] four = {{0,1},{0,-1},{-1,0},{1,0}};
        int [][] dice = {{3,1,6,4},{3,2,6,5},{3,4,6,1},{3,5,6,2}};
        StringBuilder result = new StringBuilder();
        tokens = new StringTokenizer(reader.readLine());

        while (K-- > 0){
            idx[i] = map[x][y];

            int way = Integer.parseInt(tokens.nextToken());
            int tx = x + four[way - 1][0];
            int ty = y + four[way - 1][1];
            if (tx < 0 || tx >= N || ty < 0 || ty >= M)
                continue;
            x = tx;
            y = ty;
            switch (way) {
                case 1:
                    e = (e + 1) % 4;
                    break;
                case 2:
                    e = (4 + (e - 1)) % 4;
                    break;
                case 3:
                    if (e % 2 == 0)
                        e = (4 + (e - 1)) % 4;
                    s = (4 + (s - 1)) % 4;
                    break;
                case 4:
                    if (e % 2 == 0)
                        e = (4 + (e - 1)) % 4;
                    s = (s + 1) % 4;
                    break;
            }
            i = dice[s][e];
            result.append(idx[(i + 3) % 6]).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}
