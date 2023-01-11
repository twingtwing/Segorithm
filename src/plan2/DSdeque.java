package plan2;

import java.io.*;
import java.util.StringTokenizer;

public class DSdeque {
    public static void main(String[] args) throws IOException {
        // 10866 : Deque
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        int [] deque = new int[count];
        int top = -1;
        int front = 0;
        int rear = -1;

        StringTokenizer str;
        while (count-- > 0) {
            str = new StringTokenizer(reader.readLine());
            switch (str.nextToken()) {
                case "push_front":
                    break;
                case "push_back":
                    break;
                case "pop_front":
                    break;
                case "pop_back":
                    break;
                case "size":
                    break;
                case "empty":
                    break;
                case "front":
                    break;
                case "back":
                    break;
            }
        }

    }
}
