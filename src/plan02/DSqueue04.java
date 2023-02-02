package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue04 {
    static int front;
    static int rear;
    static int [] queue;
    public static void main(String[] args) throws IOException {
        // 1966 : print 큐
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        int count = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer first;
        StringTokenizer second;

        int n;
        int len;
        int spot;
        queue = new int[count];

        while (count -- > 0){
            front = 0;
            rear = 0;
            first = new StringTokenizer(reader.readLine());
            second = new StringTokenizer(reader.readLine());

            len = Integer.parseInt(first.nextToken());
            spot = Integer.parseInt(first.nextToken());

            for (int i = 0; i < len; i++) {
                n = Integer.parseInt(second.nextToken());
                if (spot == i) total = totalPrint(n);
                else total = addPrint(n);
            }

            result.append(String.valueOf(rear - front));
        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }

    //////////

    private static int totalPrint(int n) {
        int cnt = 0;
        if (isEmpty() || queue[rear] < n) rearPush(n);
        else if(queue[(front + 1) % queue.length] > n) frontPush(n);
        else{
            while (queue[rear] < n){
                rearRemove
                cnt++;
            }
        }
        return cnt;
    }

    private static int addPrint(int n) {
        if (isEmpty() || queue[rear] < n) rearPush(n);
        else if(queue[(front + 1) % queue.length] > n) frontPush(n);
        return 0;
    }

    private static void frontPush(int n) {
        queue[front] = n;
        front = (queue.length + front - 1) % queue.length;
    }

    private static void rearPush(int n) {
        rear = (rear + 1) % queue.length;
        queue[rear] = n;
    }

    private static boolean isEmpty() {
        return front == rear;
    }


}
