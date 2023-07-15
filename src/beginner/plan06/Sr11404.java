package beginner.plan06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sr11404 {
    /**
     * [11404 플로이드]
     * <br>
     * n(2 ≤ n ≤ 100)개의 도시가 있다. <br>
     * 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. <br>
     * 각 버스는 한 번 사용할 때 필요한 비용이 있다.<br>
     * 모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성
     * <br><br>
     * Floyd-Warshall Algorithm
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int INF = Integer.MAX_VALUE;
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        int [][] dist = new int[N + 1][N + 1];
        for(int [] d : dist)
            Arrays.fill(d, INF);

        int i;
        int j;
        int m;
        StringTokenizer st;
        while (M-- > 0){
            st = new StringTokenizer(reader.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dist[i][j] = Math.min(dist[i][j], m);
        }

        // 중간 정점을 한 번씩 선택하여 최단 경로를 찾음
        for (int k = 1; k <= N; k++) {
            for (int l = 1; l <= N; l++) {
                // 중간지점이 같으면 경로를 이동할 필요가 없다.
                if (k == l) continue;
                for (int z = 1; z <= N; z++) {
                    // 중간지점이 같거나 끝지점과 시작지점이 같으면 굳이 이동할 필요가 없다.
                    if (k == z || l == z) continue;
                    // 정점 l에서 z로 가는 현재의 최단 경로와
                    // l에서 k를 거쳐 z로 가는 경로를 비교하여 더 작은 값을 선택
                    if (dist[l][k] != INF && dist[k][z] != INF)
                        dist[l][z] = Math.min(dist[l][z], dist[l][k] + dist[k][z]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int k = 1; k <= N; k++) {
            for (int l = 1; l <= N; l++) {
                if(dist[k][l] == INF)
                    result.append("0 ");
                else
                    result.append(dist[k][l]).append(" ");
            }
            result.append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}

