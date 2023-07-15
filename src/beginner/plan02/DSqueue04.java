package beginner.plan02;

import java.io.*;
import java.util.*;

public class DSqueue04 {
    public static void main(String[] args) throws IOException {
        // 1966 : print 큐
        // Point  => 우선순위 큐(Max Heap)을 먼저 구한후, 원래 큐를 우선순위 큐대로 변경하는 과정에서 순서를 구한다.
        // Point1 => 중요한 값은 인덱스 이므로 인덱스로 이루어진 큐를 이동시키고, 원본은 그대로 둔다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer first;
        StringTokenizer second;

        int count = Integer.parseInt(reader.readLine());

        // 2중 loop까지만 돌기 때문에 시간안에 가능 => 3중은 절대 안됨됨
        while (count -- > 0){
            first = new StringTokenizer(reader.readLine());
            second = new StringTokenizer(reader.readLine());

            int size = Integer.parseInt(first.nextToken());
            int point = Integer.parseInt(first.nextToken());
            int [] priorities = new int[size]; // 중요도 Queue
            // point : Queue를 만들면서 중요도를 이동시키면, 3중 loop가 되기 때문에 다 만들고 진행하는 것이 좋다.
            for (int i = 0; i < size; i++) priorities[i] = Integer.parseInt(second.nextToken());

            result.append(timeToPrint(priorities, point)).append("\n");
        }


        writer.write(result.toString());

        reader.close();
        writer.close();
    }

    private static String timeToPrint(int[] priorities, int point) {
        int time = 0;
        // Point : 원본을 움직이기보다는 index를 넣고 대조 비교해야한다.
        Queue<Integer> queue = new LinkedList<>(); // index Queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        for (int i = 0; i < priorities.length; i++) {
            queue.add(i); // Queue의 인덱스를 저장
            pQueue.add(priorities[i]); // 중요도를 정리 할경우의 heap
        }

        while (!queue.isEmpty()) {
            int index = queue.remove();
            if (priorities[index] < pQueue.peek()) queue.add(index);
            else{
                pQueue.poll();
                time++;
                if (index == point) break;
            }
        }

        return String.valueOf(time);
    }

}
