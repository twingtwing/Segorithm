package plan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Gd4386 {
    /**
     * [4386 별자리 만들기]
     * <br>
     * 프림 알고리즙
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        String [] input;
        double [][] stars = new double[N][2]; // 실수가 2개이니 2차원 배열을 사용하자..(이게 생각이 안나다니,..ㅠㅜㅠㅜㅠㅜ)
        boolean [] marked = new boolean[N];
        PriorityQueue<Star> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");
            stars[i] = new double[]{ Double.parseDouble(input[0]),Double.parseDouble(input[1]) };
        }

        queue.offer(new Star(0,stars[0][0],stars[0][1],0));

        Star s;
        double len = 0;
        while (!queue.isEmpty()){
            s = queue.poll();
            if (marked[s.idx]) continue;
            len += s.val;
            marked[s.idx] = true;
            for (int i = 0; i < N; i++) {
                if (!marked[i])
                    queue.offer(new Star(i, stars[i][0], stars[i][1], Math.sqrt(Math.pow(s.x - stars[i][0],2) + Math.pow(s.y - stars[i][1],2))));
            }
        }

        System.out.printf("%.2f", len);
        reader.close();
    }
}

class Star implements Comparable<Star> {
    int idx;
    double x;
    double y;
    double val;

    Star(int idx, double x, double y, double val) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Star o) {
        if (this.val > o.val)
            return 1;
        return -1;
    }
}