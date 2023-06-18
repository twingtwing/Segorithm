package plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Gp1199 {
    /**
     * [1199 오일러 회로]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int [][] graph = new int[size][size];

        Map<String, Integer> map = new HashMap<>();

        int count = 0;
        StringTokenizer token;
        for (int i = 0; i < size; i++) {
            token = new StringTokenizer(reader.readLine());
            for (int j = 0; j < size; j++){
                graph[i][j] = Integer.parseInt(token.nextToken());
                count += graph[i][j];
            }
        }

        // DFS : 재귀호출
        count /= 2;
        int [] path = new int[count+1];
        dfsRec(0,0, graph, path);

        StringBuilder result = new StringBuilder();
        if (path[0] != path[count])
            result.append("-1");
        else{
            for (int i = 0; i < path.length; i++) {
                if (path[i] == 0) {
                    result = new StringBuilder("-1");
                    break;
                }
                result.append(path[i]).append(" ");
            }
        }

        System.out.println(result);

        reader.close();
    }

    private static void dfsRec(int spot, int count, int[][] graph, int [] path) {
        path[count] = spot + 1;
        if (count + 1 == path.length)
            return;
        if (graph[spot][0] + graph[spot][1] + graph[spot][2] + graph[spot][3]+ graph[spot][4] + graph[spot][5] == 0)
            return;
        for (int i = 0; i < graph.length; i++){
            if (spot == i || graph[spot][i] == 0)
                continue;
            graph[spot][i] = 0;
            graph[i][spot] = 0;
            dfsRec(i,count+1, graph, path);
            if (path[0] == path[path.length - 1]) return;
            graph[spot][i] = 1;
            graph[i][spot] = 1;
        }
    }

}
