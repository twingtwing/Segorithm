package beginner.plan01;

import java.io.*;
import java.util.StringTokenizer;

public class MathProgress01 {
    public static void main(String[] args) throws IOException {
        //15649 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열 (1 ≤ M ≤ N ≤ 8)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer str = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(str.nextToken());
        int col = Integer.parseInt(str.nextToken());

        for (int i = 1; i <= row; i++) madeCase(i, col, new boolean[row + 1], result, new StringBuilder());

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static void madeCase(int start, int col, boolean [] storage,  StringBuilder result, StringBuilder line) {
        storage[start] = true;
        if (col == 1) {
            result.append(line).append(start).append("\n");
            return;
        }
        col--;
        line.append(start).append(" ");
        for (int i = 1; i < storage.length; i++){
            if (storage[i]) continue;
            removeLast(start, line);
            madeCase(i, col, storage.clone(), result, line);
        }
    }

    private static void removeLast(int start, StringBuilder line) {
        int val = line.length() > 2 ? Integer.parseInt(String.valueOf(line.charAt(line.length() - 2))) : start;
        if (start == val) return;
        line.delete(line.length() - 2,line.length());
        removeLast(start,line);
    }
}
