package plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gp1647 {
    /**
     * [1647 도시 분할 계획]
     * <br>
     * 최소 신장트리
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        CityMST mst = new CityMST(N);
        while (M-- > 0) {
            st = new StringTokenizer(reader.readLine());
            mst.addNode(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        System.out.println(mst.totalAmt());
        reader.readLine();
    }

}

class CityMST{
    boolean [] visited;
    ArrayList<Node> [] graph;

    CityMST(int n) {
        this.visited = new boolean[n + 1];
        this.graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            this.graph[i] = new ArrayList<Node>();
    }

    void addNode(int i, int j, int v) {
        this.graph[i].add(new Node(j,v));
        this.graph[j].add(new Node(i,v));
    }

    int totalAmt(){
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(1,0));
        this.visited[1] = true;
        int total = 0;
        Node node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (this.visited[node.p]) continue;
            total += node.v;
            this.visited[node.p] = true;
            for (Node n : this.graph[node.p]) {
                if (!this.visited[n.p])
                    queue.add(n);
            }
        }

        return total;
    }

}

class Node implements Comparable<Node>{
    int p;
    int v;

    Node(int p, int v){
        this.p = p;
        this.v = v;
    }

    @Override
    public int compareTo(Node o) {
        return this.v - o.v;
    }
}
