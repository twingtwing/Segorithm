package plan02;

import java.io.*;

public class DSheap01 {
    public static void main(String[] args) throws IOException {
        // 1927 : 최소 힙 => 중위 표기법 (queue로 구현)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int count = Integer.parseInt(reader.readLine());
        int in;
        int point;
        int front = 0;
        int rear = 0;
        int [] queue = new int[count];

        while (count-- > 0) {
            in = Integer.parseInt(reader.readLine());
            if (in == 0){
                if (front == rear) result.append("0\n");
                else {
                    front = (front + 1) % queue.length;
                    result.append(String.valueOf(queue[front])).append("\n");
                }
            }else{
                if (in < queue[(front + 1) % queue.length]){
                    queue[front] = in;
                    front = (queue.length + front - 1) % queue.length;
                }else if(in > queue[rear]){
                    rear = (rear + 1) % queue.length;
                    queue[rear] = in;
                }else{
                    point = rear;
                    rear = (rear + 1) % queue.length;
                    while (queue[point] > in) {
                        queue[(point + 1) % queue.length] = queue[point];
                        point = (queue.length + point - 1) % queue.length;
                    }
                    queue[(point + 1) % queue.length] = in;
                }
            }
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }
}
