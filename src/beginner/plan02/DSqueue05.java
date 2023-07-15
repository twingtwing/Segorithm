package beginner.plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue05 {
    public static void main(String[] args) throws IOException {
        // 11866 : 요세푸스 순열
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int count = Integer.parseInt(token.nextToken());
        double hurdle = Integer.parseInt(token.nextToken());
        int jump = hurdle == 1 ? count - 1 : (int) Math.ceil(count / hurdle);

        int[] queue = new int[count];

        int cnt = 0;
        int point = 0;

        for (int i = 0; i < count; i++) {
            point = (point+1) % count;
            queue[point] = i + 1;
        }

        int [] tmp;
        result.append("<");
        while (queue.length > 1) {
            point = (int) ((point + hurdle) % queue.length);
            result.append(String.valueOf(queue[point])).append(", ");
            queue[point] = 0;
            if (jump == ++cnt){
                tmp = new int[queue.length - cnt];
                for (int i = 1; i <= tmp.length; i++) {
                    point = (point + 1) % queue.length;
                    while (queue[point] == 0) point = (point + 1) % queue.length;
                    tmp[i % tmp.length] = queue[point];
                }
                jump = (int) Math.ceil(tmp.length / hurdle);
                queue = tmp;
                point = 0;
                cnt = 0;
            }
        }

        result.append(queue[0]).append(">");

        writer.write(result.toString());

        reader.close();
        writer.close();

    }
}
