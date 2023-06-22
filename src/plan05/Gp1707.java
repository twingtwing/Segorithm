package plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gp1707 {
    /**
     * [1707 이분 그래프]
     * <br>
     * 그래프의 정점의 집합을 둘로 분할하여,
     * 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, <br>
     * 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph)<br>
     * 이분 그래프인지 아닌지 판별하는 그래프 구현
     * <br><br>
     * 이분 그래프를 판별하는 알고리즘 중 하나인 색칠 (Coloring) 알고리즘
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());

        int N;
        int M;
        int V;
        String rs;
        StringTokenizer tokens;
        int [] colors = new int[20001];
        ArrayList<ArrayList<Integer>> graph;
        Stack<Integer> stack = new Stack<>();
        while (K-- > 0) {
            tokens = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());

            graph = new ArrayList<>();
            Arrays.fill(colors,0, N + 1,-1);
            for (int i = 0; i <= N; i++)
                graph.add(new ArrayList<>());

            while (M-- > 0) {
                tokens = new StringTokenizer(reader.readLine());
                N = Integer.parseInt(tokens.nextToken());
                V = Integer.parseInt(tokens.nextToken());
                graph.get(N).add(V);
                graph.get(V).add(N);
            }

            rs = "YES";
            stack.clear();
            for (int i = 1; i <= N; i++) {
                for (int j = 0; i < graph.get(i).size(); j++) {

                }
            }

//            for (int i = 1; i <= N; i++){
//                if (colors[i] == -1){
//                    if (!dfs(i, graph, colors, 0)){
//                        rs = "NO";
//                        break;
//                    }
//                }
//            }

            System.out.println(rs);
        }

        reader.close();
    }

//    private static boolean dfs(int i, ArrayList<ArrayList<Integer>> graph, int[] colors, int val) {
//        colors[i] = val;
//        for (int n : graph.get(i)){
//            if (colors[n] == val)
//                return false;
//            if (colors[n] == -1 && !dfs(n, graph, colors, 1 - val))
//                return false;
//        }
//        return true;
//    }

}
