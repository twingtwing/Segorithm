package plan06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sr2178 {
    /**
     * [2178 미로탐색]
     * <br>
     * - 최단경로<br>
     * - 가중치가 없기 때문에 BFS 이용 <br>
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str;
        // 상하좌우
        int [] x = {-1,1, 0,0};
        int [] y = { 0,0,-1,1};
        // 미로, 경로 저장
        int [][] maze = new int[N + 1][M + 1];
        int [][] dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            str = reader.readLine();
            for (int j = 1; j <= M; j++)
                maze[i][j] = str.charAt(j-1) - '0';
        }

        Queue<Spot> queue = new LinkedList<>();
        queue.add(new Spot(1,1));

        int xi;
        int yi;
        Spot spot;
        dist[1][1] = 1;
        while (!queue.isEmpty()){
            spot = queue.poll();
            for (int i = 0; i < 4; i++) {
                xi = spot.x + x[i];
                yi = spot.y + y[i];
                // 범위제한
                if (xi > N || yi > M)
                    continue;
                // 이동 가능 유무
                if (maze[xi][yi] == 0)
                    continue;
                // 첫 방문 경우에만 최단 경로 갱신
                if (dist[xi][yi] == 0){
                    dist[xi][yi] = dist[spot.x][spot.y] + 1;
                    queue.add(new Spot(xi,yi));
                }
            }
        }

        System.out.println(dist[N][M]);
        reader.close();
    }
}

class Spot{
    int x;
    int y;
    Spot(int x, int y){
        this.x = x;
        this.y = y;
    }
}
