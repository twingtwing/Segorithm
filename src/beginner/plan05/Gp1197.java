package beginner.plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gp1197 {
    /**
     * [1197 최소 스패닝 트리]
     * <br><br>
     * Prim 알고리즘:<br>
     * - 임의의 정점을 시작점으로 선택합니다.<br>
     * - 선택한 정점과 연결된 간선 중 최소 가중치를 가진 간선을 선택하여 트리에 추가합니다.<br>
     * - 추가된 간선과 연결된 정점을 방문하지 않은 정점 중에서
     *  최소 가중치를 가진 간선을 선택하여 트리에 추가합니다.<br>
     * - 모든 정점이 트리에 포함될 때까지 위의 과정을 반복합니다.<br>
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int V = Integer.parseInt(tokens.nextToken());
        int E = Integer.parseInt(tokens.nextToken());

        MST mst = new MST(V);

        while (E-- > 0) {
            tokens = new StringTokenizer(reader.readLine());
            mst.addEdge(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
        }

        System.out.println(mst.sumMST());
        reader.close();
    }
}


class MST{
    ArrayList<Node>[] graph;
    boolean [] marked;

    class Node implements Comparable<Node>{
        int spot;
        int val;
        Node(int spot, int val){
            this.spot = spot;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }

    MST(int V){
        this.marked = new boolean[V + 1];
        this.graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++)
            this.graph[i] = new ArrayList<>();
    }

    void addEdge(int i, int j, int val){
        this.graph[i].add(new Node(j, val));
        this.graph[j].add(new Node(i, val));
    }

    int sumMST(){
        int total = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (this.marked[node.spot])
                continue;

            this.marked[node.spot] = true;
            total += node.val;

            for (Node n : this.graph[node.spot]) {
                if (!marked[n.spot])
                    queue.add(n);
            }

        }

        return total;
    }

}
