package plan02;

import java.io.*;

public class DSqueue01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        int count = Integer.parseInt(reader.readLine());
        int [] queue = new int[count];

        // 10845 : Queue 구현
        // 18258 : Queue 구현2
//        int front = 0;
//        int rear = -1;
//        StringTokenizer str;
//        int out;
//        while (count -- > 0){
//            out = -2;
//            str = new StringTokenizer(reader.readLine());
//            switch (str.nextToken()){
//                case "push" : queue[++rear] = Integer.parseInt(str.nextToken());
//                    break;
//                case "pop" : out = front > rear ? -1 : queue[front++];
//                    break;
//                case "size" : out = rear - front + 1;
//                    break;
//                case "empty" : out = front > rear ? 1 : 0;
//                    break;
//                case "front" : out = front > rear ? -1 : queue[front];
//                    break;
//                case "back" : out = front > rear ? -1 : queue[rear];
//                    break;
//            }
//            if (out != -2) result.append(out).append("\n");
//        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }
}
