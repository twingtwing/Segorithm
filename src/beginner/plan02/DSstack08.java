package beginner.plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSstack08 {
    public static void main(String[] args) throws IOException {
        // 2812 : 큰 수 만들기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer kn = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(kn.nextToken());
        int k = Integer.parseInt(kn.nextToken());
        int size = n - k;
        int top =  0;

        char [] chars = reader.readLine().toCharArray();
        char [] stack = new char[size];

        while(size > 0){
            for (int i = top; i <= n - size; i++) {
                if (stack[n - k - size] < chars[i]) {
                    stack[n - k - size] = chars[i];
                    top = i + 1;
                    if (chars[i] == '9') break;
                }
            }
            size--;
        }

        writer.write(new String(stack));

        writer.close();
        reader.close();

    }
}
