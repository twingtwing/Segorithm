package plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gp2252 {
    /**
     * [2252 줄 세우기]
     * <br>
     * 학생의 선후관계를 파악해야하므로 위상정렬 이용<br>
     * N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        int i, j;
        int [][] graph = new int[N+1][N+1];
        while (M-- > 0) {
            tokens = new StringTokenizer(reader.readLine());
            i = Integer.parseInt(tokens.nextToken());
            j = Integer.parseInt(tokens.nextToken());
            graph[i][++graph[i][0]] = j;
            graph[0][j]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int k = 1; k <= N; k++) {
            if(graph[0][k] == 0)
                queue.add(k);
        }

        int idx;
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()){
            idx = queue.remove();

//            result.append(idx),graph" "
        }

        reader.close();
    }
}
