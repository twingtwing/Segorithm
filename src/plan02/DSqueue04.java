package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue04 {
    static int front;
    static int rear;
    static int point;
    static int [] queue;
    public static void main(String[] args) throws IOException {
        // 1966 : print 큐 ==> 와 이거,,, 개어렵다
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer first;
        StringTokenizer second;

        int in;
        int count;
        int total;
        int cnt = Integer.parseInt(reader.readLine());
        while (cnt -- > 0) {
            total = 0;
            first = new StringTokenizer(reader.readLine());
            second = new StringTokenizer(reader.readLine());

            count = Integer.parseInt(first.nextToken());
            point = Integer.parseInt(first.nextToken());

            queue = new int[count];
            enQueue(Integer.parseInt(second.nextToken()));
            for (int i = 1; i < count; i++) {
                in = Integer.parseInt(second.nextToken());
                if (queue[i - 1] < in) moveLike(i - 1, in);
                else enQueue(in);
            }
            result.append(String.valueOf(total)).append("\n");
        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }

    private static void enQueue(int num) {
        rear = (rear+1) % queue.length;
        queue[rear] = num;
    }

    private static void moveLike(int i, int in) {
    }

}
