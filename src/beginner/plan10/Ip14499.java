package beginner.plan10;

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

        int [] dice = new int[6];
        int [][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(tokens.nextToken());
        }

        StringBuilder result = new StringBuilder();
        tokens = new StringTokenizer(reader.readLine());
        int [][] four = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4

        // 주사위 이동경로를 규칙적으로 하기는 힘들기 때문에
        // 이동할때마다 주사위 숫자를 변경하는걸로 수정
        while (K-- > 0){
            int way = Integer.parseInt(tokens.nextToken());
            int tx = x + four[way][0];
            int ty = y + four[way][1];
            if (tx < 0 || tx >= N || ty < 0 || ty >= M)
                continue;
            x = tx;
            y = ty;

            int tmp = dice[5];
            switch (way) {
                case 1: // 동쪽 이동
                    dice[5] = dice[3];
                    dice[3] = dice[0];
                    dice[0] = dice[1];
                    dice[1] = tmp;
                    break;
                case 2:
                    dice[5] = dice[1];
                    dice[1] = dice[0];
                    dice[0] = dice[3];
                    dice[3] = tmp;
                    break;
                case 3:
                    dice[5] = dice[4];
                    dice[4] = dice[0];
                    dice[0] = dice[2];
                    dice[2] = tmp;
                    break;
                case 4:
                    dice[5] = dice[2];
                    dice[2] = dice[0];
                    dice[0] = dice[4];
                    dice[4] = tmp;
                    break;
            }

            if (map[x][y] == 0)
                map[x][y] = dice[5];
            else{
                dice[5] = map[x][y];
                map[x][y] = 0;
            }

            result.append(dice[0]).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}
