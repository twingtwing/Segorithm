package beginner.plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
     * 1. 이분 그래프를 판별하는 알고리즘 중 하나인 색칠 (Coloring) 알고리즘<br>
     * 2. 메모리 제한이 있기 때문에 Adjacency list 을 이용한다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());

        int N;
        int M;
        BiGraph graph;
        StringBuilder result = new StringBuilder();
        StringTokenizer tokens;
        while (K-- > 0) {
            tokens = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());

            graph = new BiGraph(N);
            while (M-- > 0) {
                tokens = new StringTokenizer(reader.readLine());
                graph.addEdge(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
            }

            result.append(graph.judgeColor()).append("\n");
        }

        System.out.println(result);
        reader.close();
    }

}

class BiGraph{
    private int [] colors;
    private ArrayList<ArrayList<Integer>> graph;

    BiGraph(int N){
        this.colors = new int[N+1];
        this.graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            this.graph.add(new ArrayList<>());
    }

    void addEdge(int i, int j){
        this.graph.get(i).add(j);
        this.graph.get(j).add(i);
    }

    // 연결 조합이 2개 이상인 경우도 고려
    String judgeColor(){
        for (int i = 1; i < this.colors.length; i++) {
            if (this.colors[i] == 0 && !srhColor(i, 1))
                return "NO";
        }
        return "YES";
    }

    // colors에 값이 모두 들어가면 break가 되기때문에 따로 if 하거나 간선을 수정할 필요가 없음
    private boolean srhColor(int idx, int val){
        this.colors[idx] = val;
        for (int i : graph.get(idx)) {
            if (this.colors[i] == val)
                return false;
            if (this.colors[i] == 0 && !srhColor(i, val * -1))
                return false;
        }
        return true;
    }

}
