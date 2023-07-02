package plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Sort1946 {
    /**
     * [1946 신입사원]
     * <br>
     * 굳이 합계까지 정렬할 필요가 없음
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        while (T--> 0){
            Test t = new Test();
            int N = Integer.parseInt(reader.readLine());
            while (N-->0){
                StringTokenizer toknes = new StringTokenizer(reader.readLine());
                t.addNum(Integer.parseInt(toknes.nextToken()),Integer.parseInt(toknes.nextToken()));
            }
            t.sort();
            result.append(t.getCount()).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}

class Test{
    private List<Node> sort;
    Test(){
        this.sort = new ArrayList<>();
    }

    void addNum(int x, int y){
        this.sort.add(new Node(x,y));
    }

    void sort(){
        Collections.sort(this.sort);
    }

    int getCount(){
        int count = 0;

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (Node n : this.sort) {
            if (n.x < x || n.y < y){
                x = Math.min(n.x, x);
                y = Math.min(n.y, y);
                count++;
            }
        }

        return count;
    }

}

class Node implements Comparable<Node>{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Node o) {
        if (this.x != o.x)
            return this.x - o.x;
        else
            return this.y - o.y;
    }
}