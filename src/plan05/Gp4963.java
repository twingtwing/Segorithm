package plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gp4963 {
    /**
     * [4963 섬의 개수]
     * <br>
     * 이분 그래프
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Island island;
        StringTokenizer tokens;
        StringBuilder result = new StringBuilder();
        while (true) {
            tokens = new StringTokenizer(reader.readLine());
            island = new Island(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
            if (island.getWidht() + island.getHeight() == 0) break;
            for (int i = 1; i <= island.getHeight(); i++) {
                tokens = new StringTokenizer(reader.readLine());
                for (int j = 1; j <= island.getWidht(); j++) {
                    if (Integer.parseInt(tokens.nextToken()) == 1)
                        island.addEdge(i,j);
                }
            }
            
            result.append(island.cntIsland()).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}

class Island{
    private int [][] graph;

    Island(int w, int h) {
        this.graph = new int[h+1][w+1];
    }
    
    int getHeight(){
        return graph.length - 1;
    }
    int getWidht(){
        return graph[0].length - 1;
    }
    
    int cntIsland(){
        int count = 0;
        for (int i = 1; i < this.graph.length; i++) {
            for (int j = 1; j < this.graph[0].length; j++) {
                if (this.graph[i][j] == 1){
                    count++;
                    findIsland(i, j);
                }
            }
        }
        return count;
    }

    private void findIsland(int i, int j){
        this.graph[i][j] = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            if (this.graph.length <= k) continue;
            for (int l = j - 1; l <= j + 1 ; l++) {
                if (this.graph[0].length <= l) continue;
                if (this.graph[k][l] == 1)
                    findIsland(k,l);
            }
        }
    }

    void addEdge(int i, int j) {
        this.graph[i][j] = 1;
    }

}