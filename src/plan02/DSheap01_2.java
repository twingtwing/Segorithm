package plan02;

import java.io.*;
import java.util.PriorityQueue;

public class DSheap01_2 {
    public static void main(String[] args) throws IOException {
        // 1927 : PriorityQueue(우선순위 Queue로 구현)

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int in;
        int count = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (count-- > 0) {
            in = Integer.parseInt(reader.readLine());
            if (in == 0) {
                if (minHeap.isEmpty()) result.append("0\n");
                else result.append(String.valueOf(minHeap.remove())).append("\n");
            }
            else minHeap.add(in);
        }

        writer.write(result.toString());

        writer.close();
        reader.close();
    }
}
