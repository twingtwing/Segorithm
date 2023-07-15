package beginner.plan01;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MathProgress04 {
    static StringBuilder result = new StringBuilder();
    static int max;
    static int len;
    public static void main(String[] args) throws IOException {
        //15650 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열
        // 중복 x, 오른차순, (1 ≤ M ≤ N ≤ 8)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        max = Integer.parseInt(str.nextToken());
        len = Integer.parseInt(str.nextToken());
        char [] progeress = new char[len*2];

        Arrays.fill(progeress, ' ');
        madeProgress(progeress,0,0);

        writer.write(result.toString());

        reader.close();
        writer.close();

    }

    private static void madeProgress(char [] progeress, int start,int count) {
        if (len == count){
            result.append(progeress).append("\n");
            return;
        }
        for (int i = start; i < max; i++){
            progeress[count*2] = (char) ((i+1) + '0');
            madeProgress( progeress, i + 1, count + 1);
        }
    }
}
