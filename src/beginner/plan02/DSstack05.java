package beginner.plan02;

import java.io.*;

public class DSstack05 {
    public static void main(String[] args) throws IOException {
        // 10799 : 쇠막대기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char [] stack = reader.readLine().toCharArray();
        int count = 0;
        int total = 0;

        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == ')'){
                count--;
                if (stack[i-1] == '(') total += count;
                else total++;
            }
            else count ++;
        }

        writer.write(String.valueOf(total));

        writer.close();
        reader.close();
    }
}
