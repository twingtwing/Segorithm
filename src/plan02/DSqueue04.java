package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue04 {
    public static void main(String[] args) throws IOException {
        // 1966 : print 큐
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer first;
        StringTokenizer second;
        
        int front;
        int rear;
        int point;
        int [] queue;

        int in;
        int count;
        int cnt = Integer.parseInt(reader.readLine());
        while (cnt -- > 0) {
            first = new StringTokenizer(reader.readLine());
            second = new StringTokenizer(reader.readLine());

            count = Integer.parseInt(first.nextToken()) + 1;
            point = Integer.parseInt(first.nextToken()) + 1;

            front = 0;
            rear = 0;
            queue = new int[count];
            queue[0] = Integer.MAX_VALUE;
//https://www.acmicpc.net/board/view/67762
            boolean flag;
            for (int i = 1; i < count; i++) {
                rear = (rear + 1) % count;
                in = Integer.parseInt(second.nextToken());
                queue[rear] = in;
                if (rear > 1 && in > queue[rear - 1]) {
                    flag = true;
                    int spot = rear - 1;
                    while (spot > front && in > queue[spot]) spot = spot - 1;
                    int [] tmp = new int[count];
                    for (int j = 1; j <= spot; j++) tmp[j] = queue[j];
                    for (int j = rear, z = 1; j < count; j++,z++) {
                        tmp[spot + z] = queue[j];
                        if (point == j && flag) {
                            point = spot + z;
                            flag = false;
                        }
                    }
                    for (int j = spot + 1; j < rear; j++) {
                        tmp[count - rear + j] = queue[j];
                        if (point == j && flag) point = count - rear + j;
                    }
                    queue = tmp;
                    rear = spot + 1;
                }
            }

            // 아직 끝 나지 않은 경우
            while (rear < count - 1){
                rear = (rear + 1) % count;
                int spot = rear - 1;
                if (queue[rear] > queue[spot]) {
                    flag = true;
                    while (spot > front && queue[rear] > queue[spot]) spot = spot - 1;
                    int [] tmp = new int[count];
                    for (int j = 1; j <= spot; j++) tmp[j] = queue[j];
                    for (int j = rear, z = 1; j < count; j++,z++) {
                        tmp[spot + z] = queue[j];
                        if (point == j && flag) {
                            point = spot + z;
                            flag = false;
                        }
                    }
                    for (int j = spot + 1; j < rear; j++) {
                        tmp[count - rear + j] = queue[j];
                        if (point == j && flag) point = count - rear + j;
                    }
                    queue = tmp;
                    rear = spot + 1;
                }

            }

            result.append(String.valueOf(point)).append("\n");
        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }

}
