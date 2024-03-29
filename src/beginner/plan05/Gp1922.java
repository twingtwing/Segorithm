package beginner.plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gp1922 {
    /**
     * [1922 네트워크 연결]
     * <br>
     * 최소 신장트리 / Kruskal 알고리즘
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        ArrayMST mst = new ArrayMST(N);
        while (M-- > 0){
            str = new StringTokenizer(reader.readLine());
            mst.addEdge(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
        }


        System.out.println(mst.totalVal());
        reader.close();
    }

}

class ArrayMST{
    boolean [] visited;
    ArrayList<Edge> [] graph;

    ArrayMST(int n){
        this.visited = new boolean[n + 1];
        this.graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            this.graph[i] = new ArrayList<>();
    }

    void addEdge(int i ,int j, int v){
        this.graph[i].add(new Edge(j,v));
        this.graph[j].add(new Edge(i,v));
    }

    int totalVal(){
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        Edge e;
        int max = 0;
        int total = 0;
        int cnt = this.visited.length - 1;
        queue.add(new Edge(1, 0));
        while (cnt > 0) {
            e = queue.poll();
            if (this.visited[e.p]) continue;
            cnt--;
            total += e.v;
            max = Math.max(max,e.v);
            this.visited[e.p] = true;
            for (Edge a : this.graph[e.p]){
                if (!this.visited[a.p])
                    queue.add(a);
            }
        }

        return total - max;
    }

}

class Edge implements Comparable<Edge>{
    int p;
    int v;

    Edge(int p, int v){
        this.p = p;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o) {
        return this.v - o.v;
    }
}