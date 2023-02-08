package plan02;

import java.io.*;
import java.util.PriorityQueue;

public class DSheap02_2 {
    public static void main(String[] args) throws IOException {
        // 11286 : 절댓값 heap => PriorityQueue
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        int in;
        int count = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> plusHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minusHeap = new PriorityQueue<>();


        while (count-- > 0){
            in = Integer.parseInt(reader.readLine());
            if (in == 0) {
                int out;
                if (plusHeap.isEmpty() && minusHeap.isEmpty()) out = 0;
                else if(plusHeap.isEmpty()) out = minusHeap.poll() * -1;
                else if(minusHeap.isEmpty()) out = plusHeap.poll();
                else out = plusHeap.peek() >= Math.abs(minusHeap.peek()) ? minusHeap.poll() * -1 : plusHeap.poll();
                result.append(String.valueOf(out)).append("\n");
            }else{
                if (in > 0) plusHeap.add(in);
                else minusHeap.add(in * -1);
            }
        }

        writer.write(result.toString());

        reader.close();
        writer.close();

    }
}
