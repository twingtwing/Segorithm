package beginner.plan06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sr5014 {
    /**
     * [5014 스타트 링크]
     * <br>
     * 최솟값 => 최단경로 문제..?
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int [] tower = new int[Integer.parseInt(st.nextToken()) + 1];
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        tower[S] = 1;

        int idx;
        int [] move = {-1 * D, U};
        while (!queue.isEmpty()) {
            idx = queue.poll();
            for (int i : move){
                if (i + idx < 1 || i + idx > tower.length - 1)
                    continue;
                if (tower[i + idx] == 0){
                    tower[i+idx] = tower[idx] + 1;
                    queue.add(i + idx);
                    if (i + idx == G)
                        queue.clear(); // 다른 방법 구하기
                }
            }
        }

        System.out.println(tower[G] == 0 ? "use the stairs" : tower[G] - 1);
        reader.close();
    }
}
