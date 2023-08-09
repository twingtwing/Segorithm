package ibeginner.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Hp2075 {
    /**
     * [2075 N번째 큰 수]
     * 정렬을 사용해야하지만 배열 or list를 사용하면 안되는 유형
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                queue.offer(Integer.parseInt(tokens.nextToken()));
            }
        }

        while (N-- > 1)
            queue.poll();

        System.out.println(queue.peek());
        reader.close();
    }
}
