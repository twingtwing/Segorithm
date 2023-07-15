package beginner.plan09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Gd11000 {
    /**
     * [11000 강의실 배정]
     * <br>
     * Queue에 두 값을 모두 넣을 필요는 없다.<br>
     * 지금 시작, 종료 모두 따로 정렬된 경우가 필요할 경우<br>
     * 따로 해도 된다.<br>
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int [][] lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            String [] input = reader.readLine().split(" ");
            lectures[i][0] = Integer.parseInt(input[0]);
            lectures[i][1] = Integer.parseInt(input[1]);
        }

        // 시작 시간 기준으로 정렬
        Arrays.sort(lectures, (a,  b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(lectures[0][1]); // 종료시간을 넣음

        for (int i = 1; i < N; i++) {
            if (lectures[i][0] >= queue.peek())
                queue.poll();
            queue.offer(lectures[i][1]);
        }

        System.out.println(queue.size());
        reader.close();
    }
}
