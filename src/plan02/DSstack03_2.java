package plan02;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class DSstack03_2 {
    static Stack<Character> stack = new Stack<Character>();
    static Stack<Character> cursor = new Stack<Character>();
    public static void main(String[] args) throws IOException {
        //1406 : 소문자만을 기록할 수 있는 편집기 + 커서 존재 => 후입선출 Stack을 이용한다.
        // 두개의 stack으로 풀어본다. (직접 만들지 말고)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (char c : reader.readLine().toCharArray()) {stack.push(c);}

        StringTokenizer token;
        int count = Integer.parseInt(reader.readLine());

        while(count-->0){
            token = new StringTokenizer(reader.readLine());
            switch (token.nextToken()){
                case "L" : moveLeft();
                    break;
                case "D" : moveRight();
                    break;
                case "B" : delete();
                    break;
                case "P":  insert(token.nextToken().charAt(0));
                    break;
                default:
                    break;
            }
        }

        StringBuilder result = new StringBuilder();



        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static boolean isEmptyL(){
        return stack.size() == 0;
    }

    private static boolean isEmptyR(){
        return cursor.size() == 0;
    }

    private static void moveLeft() {
        if (isEmptyL()) return;
        cursor.push(stack.pop());
    }

    private static void moveRight() {
        if (isEmptyR()) return;
        stack.push(cursor.pop());

    }

    private static void delete() {
        if (isEmptyL()) return;
        stack.pop();
    }

    private static void insert(char c) {
        stack.push(c);
    }
}
