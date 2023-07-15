package beginner.plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue03_1 {
    static int front = 0;
    static int rear = 0;
    static int [] queue;
    static int [] idx;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        // 1021 : 양방향 회전큐 => 실제로 위치를 이동하여 구함
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int cnt = Integer.parseInt(str.nextToken());
        int count = Integer.parseInt(str.nextToken());

        front = 0;
        rear = 0;
        queue = new int[cnt];
        idx = new int[cnt + 1];

        for (int i = 0; i < cnt; i++) {
            enQueueRear();
            queue[rear] = i + 1;
            idx[i+1] = rear;
        }

        int rmv;
        while(count -- > 0){
            rmv = Integer.parseInt(token.nextToken());
            if (idx[rmv] == getFront()){
                deQueueFront();
                continue;
            }
            if(!forntRear(rmv)) frontChg(rmv);
            else rearChg(rmv);
        }

        writer.write(String.valueOf(total));

        reader.close();
        writer.close();

    }

    private static void deQueueFront() { front = (front + 1) % queue.length; }
    private static void deQueueRear() { rear = (queue.length + rear - 1) % queue.length; }

    private static void enQueueFront() { front = (queue.length + front - 1) % queue.length; }
    private static void enQueueRear() { rear = (rear + 1) % queue.length; }

    private static int getFront() { return (front + 1) % queue.length; }

    private static void frontChg(int rmv) {
        if (idx[rmv] == getFront()) {
            deQueueFront();
            return;
        }
        deQueueFront();
        int value = queue[front];
        enQueueRear();
        queue[rear] = value;
        idx[value] = rear;
        total++;
        frontChg(rmv);
    }

    private static void rearChg(int rmv) {
        if (idx[rmv] == getFront()) {
            deQueueFront();
            return;
        }
        int value = queue[rear];
        deQueueRear();
        queue[front] = value;
        idx[value] = front;
        enQueueFront();
        total ++;
        rearChg(rmv);
    }
    private static boolean forntRear(int rmv) {
        int index = idx[rmv];
        if (getFront() < rear) return index - getFront() > rear - index;
        if (index > rear) index -= queue.length;
        return index - (getFront() - queue.length) > rear - index;
    }
}
