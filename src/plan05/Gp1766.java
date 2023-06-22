package plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gp1766 {
    /**
     * [1766 문제집]
     * <br>
     * - N개의 문제는 모두 풀어야 한다.<br>
     * - 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.<br>
     * - 가능하면 쉬운 문제부터 풀어야 한다.<br>
     * <br>
     * 우선순위 큐를 이용한 위상정렬
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        int [] inDegree = new int[N+1];
        ArrayList<Integer> [] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        int a;
        int b;
        while (M-- > 0) {
            tokens = new StringTokenizer(reader.readLine());
            a = Integer.parseInt(tokens.nextToken());
            b = Integer.parseInt(tokens.nextToken());
            graph[a].add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()){
            a = queue.poll();
            for (int i : graph[a]) {
                inDegree[i]--;
                if (inDegree[i] == 0)
                    queue.add(i);
            }
            result.append(a).append(" ");
        }

        System.out.println(result);
        reader.close();
    }
}
