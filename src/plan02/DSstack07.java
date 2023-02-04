package plan02;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DSstack07 {
    static int [] stack;
    static int [] idxStack;
    static int top = -1;
    static int idx = -1;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 17298 : 오큰수
        // point!! : stack을 내림차순 저장. 오큰수 배열을 저장
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());

        stack = new int[count];
        idxStack = new int[count];
        stack[++top] = Integer.parseInt(token.nextToken());
        idxStack[++idx] = top;

        while(-- count > 0){
            stack[++top] = Integer.parseInt(token.nextToken());
            if (stack[top] < stack[idxStack[idx]]) idxStack[++idx] = top;
            else if(stack[top] > stack[idxStack[0]]) fullStack();
            else findStack();
        }

        stack[top] = -1;
        while(idx > -1){
            stack[idxStack[idx--]] = -1;
        }

        count--;

        while(count++ < top){
            result.append(String.valueOf(stack[count])).append(" ");
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void findStack() {
        while(stack[top] > stack[idxStack[idx]]){
            stack[idxStack[idx--]] = stack[top];
        }
        idxStack[++idx] = top;
    }

    private static void fullStack() {
        while(idx >-1){
            stack[idxStack[idx--]] = stack[top];
        }
        idx = 0;
        idxStack[idx] = top;
    }

}
