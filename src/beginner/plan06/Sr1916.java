package beginner.plan06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sr1916 {
    /**
     * [1916 최소 비용 구하기]
     * <br>
     * 방향이 존재하는 그래프이다.<br>
     * 다익스트라 알고리즘 : 양의 가중치가 존재하는 최단경로 문제
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        StringTokenizer st;
        Dijkstra graph = new Dijkstra(N);
        while (M-- > 0) {
            st = new StringTokenizer(reader.readLine());
            graph.addEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(reader.readLine());
        System.out.println(graph.shtDistance(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        reader.close();
    }
}

class Dijkstra{
    int [] distance;
    boolean [] marked;
    ArrayList<Node> [] graph;

    Dijkstra(int n){
        this.distance = new int[n + 1];
        this.marked = new boolean[n + 1];
        this.graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++){
            this.graph[i] = new ArrayList<>();
            this.distance[i] = Integer.MAX_VALUE;
        }
    }

    void addEdge(int i, int j, int d){
        this.graph[i].add(new Node(j,d));
    }

    int shtDistance(int s, int e){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(s,0));
        this.distance[s] = 0;

        Node n;
        while (!queue.isEmpty()){
            n = queue.poll();
            if (this.marked[n.p])
                continue;
            this.marked[n.p] = true;

            for (Node nd : this.graph[n.p]){
                // 현재 정점을 통해 이웃 정점까지의 거리가 더 짧은 경우
                if (this.distance[n.p] + nd.d < this.distance[nd.p]){
                    this.distance[nd.p] = this.distance[n.p] + nd.d;
                    queue.offer(new Node(nd.p, this.distance[nd.p]));
                }
            }
        }

        return this.distance[e];
    }

}

class Node implements Comparable<Node>{
    int p;
    int d;
    Node(int p, int d){
        this.p = p;
        this.d = d;
    }
    @Override
    public int compareTo(Node o) {
        return this.d - o.d;
    }
}
