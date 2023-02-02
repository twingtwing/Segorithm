package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSdeque02 {
    static int [] deque = new int[10000];
    static int front = 0;
    static int rear = 0;
    static int size = 10000;
    static int len = 0;
    public static void main(String[] args) throws IOException {
        // 10866 : Deque => 순차 자료구조 버전
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int count = Integer.parseInt(reader.readLine());
        int out;
        StringTokenizer token;

        while(count-- > 0){
            out = -2;
            token = new StringTokenizer(reader.readLine());
            switch (token.nextToken()) {
                case "push_front": addFront(Integer.parseInt(token.nextToken()));
                    break;
                case "push_back": addRear(Integer.parseInt(token.nextToken()));
                    break;
                case "pop_front": out = removeFront();
                    break;
                case "pop_back": out = removeRear();
                    break;
                case "size": out = len;
                    break;
                case "empty": out = isEmpty() ? 1 : 0;
                    break;
                case "front": out = getFront();
                    break;
                case "back": out = getRear();
                    break;
            }
            if (out > -2) result.append(String.valueOf(out)).append("\n");
        }

        writer.write(result.toString());

        reader.close();
        writer.close();

    }

    private static boolean isEmpty() {
        return front == rear;
    }

    private static int getFront() {
        if (isEmpty()) return -1;
        return deque[(front + 1) % size];
    }

    private static int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }

    private static void addFront(int num) {
        deque[front] = num;
        front = (size + front - 1) % size;
        len++;
    }

    private static void addRear(int num) {
        rear = (rear + 1) % size;
        deque[rear] = num;
        len++;
    }

    private static int removeFront() {
        if (isEmpty()) return -1;
        front = (front + 1) % size;
        len--;
        return deque[front];
    }

    private static int removeRear() {
        if (isEmpty()) return -1;
        int pop = deque[rear];
        rear = (size + rear - 1) % size;
        len--;
        return pop;
    }
}
