package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class St3986 {
    /**
     * [3986 좋은 단어]
     * 쌓을 이루는 요소
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());

        int total = 0;
        while (cnt -- > 0){
            char [] chars = reader.readLine().toCharArray();
            if (chars.length % 2 != 0)
                continue;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (stack.isEmpty() || stack.peek() != chars[i])
                    stack.push(chars[i]);
                else
                    stack.pop();
            }

            if (stack.isEmpty())
                total++;
        }

        System.out.println(total);
        reader.close();
    }
}
