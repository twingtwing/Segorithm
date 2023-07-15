package beginner.plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSstack06 {
    static int [] stack;
    static int [] storage;
    static int top = -1;
    static int stg = -1;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 2493 : 탑 레이저
        // point!! => push시에 내림차순으로 정렬하면서 삽입하는것이 관건!!
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        stack = new int[count];
        storage = new int[count];
        StringTokenizer token = new StringTokenizer(reader.readLine());

        stack[++top] = Integer.parseInt(token.nextToken());
        storage[++stg] = top;
        result.append(String.valueOf(0)).append(" ");

        while(--count  > 0){
            stack[++top] = Integer.parseInt(token.nextToken());
            if (stack[storage[stg]] < stack[top]){
                storage[stg] = top;
                if (stg > 0) recStack();
                if (stg == 0)result.append(String.valueOf(0)).append(" ");
                else findTop(stg - 1);
            }else{
                findTop(stg);
                storage[++stg] = top;
            }

        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void findTop(int start) {
        for (int i = start; i > -1; i--){
            if (stack[storage[i]] > stack[top]){
                result.append(String.valueOf(storage[i] + 1)).append(" ");
                break;
            }
        }
    }

    private static void recStack() {
        if (stg < 1 || stack[storage[stg - 1]] > stack[top]) return;
        storage[--stg] = top;
        recStack();
    }
}
