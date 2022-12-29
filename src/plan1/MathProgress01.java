package plan1;

import java.io.*;
import java.util.StringTokenizer;

// 수열
public class MathProgress01 {
    public static void main(String[] args) throws IOException {
        //15649 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열 (1 ≤ M ≤ N ≤ 8)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer str = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(str.nextToken());
        int col = Integer.parseInt(str.nextToken());

        for (int i = 1; i <= row; i++){
            madeCase(i, row, col, result);
        }
    }

    private static void madeCase(int start,int row, int col, StringBuilder result) {
        if (col == 0) {
            result.append("/n");
            return;
        }

        col--;


    }
}
