package plan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Gd1715 {
    /**
     * [1715 카드 정렬하기]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(N);

        while (N-- > 0)
            queue.add(Integer.parseInt(reader.readLine()));

        // 2 이상인 경우
        int sum = 0;
        while (queue.size() > 1) {
            int num = queue.poll() + queue.poll();
            sum += num;
            queue.add(num);
        }

        System.out.println(sum);
        reader.close();
    }
}
