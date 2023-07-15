package beginner.plan10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ip14503 {
    /**
     * [14503 로봇 청소기]
     * <br>
     * 문제를 제대로 읽자,,,
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int [][] room = new int[N][M];

        tokens = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(tokens.nextToken());
        int y = Integer.parseInt(tokens.nextToken());
        int way = Integer.parseInt(tokens.nextToken());

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M ; j++)
                room[i][j] = Integer.parseInt(tokens.nextToken());
        }

        int cnt = 0;
        int [][] four = {{-1,0},{0,1},{1,0},{0,-1}};
        // 방향을 지문에서 정해놓았기 때문에 위치를 변경하면 안된다.
        while (true){
            if (room[x][y] == 0){
                room[x][y] = 2; // 청소공간을 2로 표시
                cnt++;
            }
            boolean isClean = false;
            for (int i = 0; i < 4; i++) {
                way = (way + 3) % 4;
                int tx = x + four[way][0];
                int ty = y + four[way][1];
                if (room[tx][ty] == 0){
                    isClean = true;
                    x = tx;
                    y = ty;
                    break;
                }
            }

            if(!isClean){
                x += four[(way + 2) % 4][0];
                y += four[(way + 2) % 4][1];
                if (room[x][y] == 1)
                    break;
            }
        }

        System.out.println(cnt);
        reader.close();
    }
}
