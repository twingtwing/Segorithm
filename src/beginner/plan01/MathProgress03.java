package beginner.plan01;

import java.io.*;
import java.util.StringTokenizer;

public class MathProgress03 {

    static int [] progress = new int[13];
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //6603 : 로또
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());

        int len = Integer.parseInt(str.nextToken());

        while(len != 0){
            madeProgress(len, str);
            printProgress(len, 0, 6, new StringBuilder());
            str = new StringTokenizer(reader.readLine());
            len = Integer.parseInt(str.nextToken());
            result.append("\n");
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void printProgress(int len, int start, int count, StringBuilder line) {
        if (count == 0) {
            result.append(line).append("\n");
            return;
        }
        String str;
        for (int i = start; i <= len - count; i ++){
            str = String.valueOf(progress[i]);
            line.append(str).append(" ");
            printProgress(len, i + 1, count - 1, line);
            line.delete(line.length() - str.length() - 1, line.length());
        }
    }

    private static void madeProgress(int len, StringTokenizer str) {
        for (int i = 0; i < len; i++) {
            progress[i] = Integer.parseInt(str.nextToken());
        }
    }

}
