package beginner.plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gp1260 {
    /**
     * [1260 DFS와 BFS]
     * <br>
     * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력<br>
     * 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,<br>
     * 더 이상 방문할 수 있는 점이 없는 경우 종료<br>
     * 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V<br>
     * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 간선은 양방향<br>
     * <br><br>
     * !!KeyPoint!!<br>
     * - 갔단 길을 다시 가지 말라는 언급이 없으므로 방문여부로 체크한다.
     * - 더 이상 방문할 수 있는 점이 없는 경우 종료 => 즉, 모든 점을 방문하는것이 목표이다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Graph 구현 : Adjacent Matrix
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int V = Integer.parseInt(tokens.nextToken());

        int h;
        int y;
        boolean [] visited = new boolean[N + 1];
        int [][] matrix = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(reader.readLine());
            h = Integer.parseInt(tokens.nextToken());
            y = Integer.parseInt(tokens.nextToken());
            matrix[h][y] = 1;
            matrix[y][h] = 1; // 양 방향이기 때문에?
        }

        StringBuilder result = new StringBuilder();

        // DFS : 재귀호출 이용
        srhDFS(V, matrix, visited, result);

        result.append("\n");

        // BFS : Queue 이용
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = false;

        while (!queue.isEmpty()){
            int idx = queue.remove();
            for (int i = 1; i < matrix[0].length; i++) {
                if(!visited[i]) continue;
                if(matrix[idx][i] == 1 || matrix[i][idx] == 1){
                    visited[i] = false;
                    queue.add(i);
                }
            }
            result.append(idx).append(" ");
        }

        System.out.println(result);
        reader.close();
    }

    private static void srhDFS(int idx, int[][] matrix, boolean [] visited, StringBuilder result) {
        visited[idx] = true;
        result.append(idx).append(" ");
        for (int i = 1; i < matrix[0].length; i++) {
            if (visited[i]) continue;
            if (matrix[idx][i] == 1 || matrix[i][idx] == 1)
                srhDFS(i, matrix, visited, result);
        }
    }
}
