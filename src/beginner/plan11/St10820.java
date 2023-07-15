package beginner.plan11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class St10820 {
    /**
     * [10820 문자열 분석]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        StringBuilder result = new StringBuilder();
        while ((str = reader.readLine()) != null) {
            char [] chars = str.toCharArray();
            int [] count = new int[4];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') count[3]++;
                else if (chars[i] >= 'A' && chars[i] <= 'Z') count[1]++;
                else if (chars[i] >= 'a' && chars[i] <= 'z') count[0]++;
                else count[2]++;
            }
            for (int i = 0; i < count.length; i++)
                result.append(count[i]).append(" ");
            result.append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}
