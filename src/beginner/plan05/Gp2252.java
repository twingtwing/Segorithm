package beginner.plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gp2252 {
    /**
     * [2252 줄 세우기]
     * <br>
     * 학생의 선후관계를 파악해야하므로 위상정렬 이용<br>
     * N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        int [][] subun = new int[2][N+1];
        int [] inDegree = new int[N+1]; // 진입 차수
        ArrayList<Integer> [] graph = new ArrayList[N+1]; // Adjacent List

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        int a;
        int b;
        int idx = 0;
        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(reader.readLine());
            a = Integer.parseInt(tokens.nextToken());
            b = Integer.parseInt(tokens.nextToken());
            graph[a].add(b);
            inDegree[b]++;
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()){
            idx = queue.poll();
            result.append(idx).append(" ");
            for (int n : graph[idx]) {
                inDegree[n]--;
                if (inDegree[n] == 0)
                    queue.add(n);
            }
        }

        System.out.println(result);
        reader.close();
    }
}
