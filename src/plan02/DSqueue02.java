package plan02;

import java.io.*;

public class DSqueue02 {
    static int [] queue;
    static int front;
    static int rear;
    public static void main(String[] args) throws IOException {
        // 2164 : N장의 키드를 위에 지우고 위에를 아래를 이동해서 1개가 남을때까지 작업을 반복한다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        queue = new int[count*2];
        front = 0;
        rear = count - 1;

        for (int i = 0; i < count; i++)  queue[i] = i + 1;

        writer.write(String.valueOf(queue[loopCare()]));

        writer.close();
        reader.close();

    }

    private static int loopCare() {
        if (front == rear) return front;
        front++;
        if (front == rear) return front;
        queue[++rear] = queue[front++];
        return loopCare();

    }
}
