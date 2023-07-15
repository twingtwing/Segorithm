package beginner.plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gp2056 {
    /**
     * [2056 작업]
     * <br>
     * 최단 속도 위상정렬
     * <br><br>
     * !!KeyPoint!!<br>
     * A(2) -> B (1) -> C (9)<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-> D (8)<br>
     * 이떼, (B,C)와 (D)는 독립적이기 때문에<br>
     * 2 + Math.min(1,8) + 9 가 아니라<br>
     * 2 + Math.min(1 + 9,8) 이어야 한다.<br><br>
     * 1. Queue을 이용<br>
     * 2. 배열을 이용해서 Max값을 저장
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
//        ArrayList<Integer> [] graph = new ArrayList[N+1];
//
//        for (int i = 1; i <= N; i++) {
//            graph[i] = new ArrayList<>();
//        }

        int [] sums = new int[N+1];
        int [] values = new int[N+1];
//        int [] inDegree = new int[N + 1];

        int idx;
        StringTokenizer tokens;
        for (int i = 1; i <= N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            values[i] = Integer.parseInt(tokens.nextToken());
            sums[i] = values[i];
            idx = Integer.parseInt(tokens.nextToken());
            for (int j = 0; j < idx; j++){
                sums[i] = Math.max(sums[i], sums[Integer.parseInt(tokens.nextToken())] + values[i]);
//                inDegree[i]++;
//                graph[Integer.parseInt(tokens.nextToken())].add(i);
            }
            sums[0] = Math.max(sums[0], sums[i]);
        }

//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 1; i <= N; i++) {
//            if (inDegree[i] == 0){
//                queue.add(i);
//                sums[i] = values[i];
//                sums[0] = Math.max(sums[0], sums[i]);
//            }
//        }
//
//        while (!queue.isEmpty()){
//            idx = queue.poll();
//            for (int i : graph[idx]) {
//                inDegree[i]--;
//                sums[i] = Math.max(sums[i], sums[idx] + values[i]);
//                sums[0] = Math.max(sums[0], sums[i]);
//                if (inDegree[i] == 0)
//                    queue.add(i);
//            }
//        }

        System.out.println(sums[0]);
        reader.close();
    }
}
