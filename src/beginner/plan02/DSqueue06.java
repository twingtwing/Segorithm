package beginner.plan02;

import java.io.*;

public class DSqueue06 {
    public static void main(String[] args) throws IOException {
        // 5430 : Queue
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int count = Integer.parseInt(reader.readLine());

        int front;
        int rear;
        String [] queue = null;

        boolean direction; // true : 정방향, false 역방향
        boolean error;

        String [] ac;
        String readline;
        while (count-- > 0) {
            error = true;
            direction = true;
            ac = reader.readLine().split("");

            front = 0;
            rear = Integer.parseInt(reader.readLine());

            readline = reader.readLine();
            if (rear> 0){
                queue = readline
                        .replaceFirst("\\[",",")
                        .replace("]",",")
                        .split(",");
            }

            for (String a : ac) {
                if (a.equals("R")) direction = !direction;
                else{
                    if (front >= rear) {
                        error = false;
                        break;
                    }
                    if (direction) front++;
                    else rear--;
                }
            }

            // Circle Queue가 아니므로 들어가면서 수행 가능 => loop를 한번만 돌게 됨

            if (error){
                result.append("[");
                if (front < rear){
                    if (direction) {
                        for (int i = front + 1  ; i < rear; i++) result.append(queue[i]).append(",");
                        result.append(queue[rear]);
                    }
                    else{
                        for (int i = rear; i > front + 1; i--) result.append(queue[i]).append(",");
                        result.append(queue[front + 1]);
                    }
                }
                result.append("]\n");
            }else result.append("error\n");
        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }
}
