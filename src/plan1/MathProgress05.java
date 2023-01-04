package plan1;

import java.io.*;
import java.util.Arrays;

public class MathProgress05 {
    static boolean [] b;
    static char [] chars;
    static int n;
    public static void main(String[] args) throws IOException {
        //10974 : N이 주어졌을때, 1 부터 N까지의 수로 이루어진 순열을 사전순으로 출력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        n = Integer.parseInt(reader.readLine());
        b = new boolean[n];
        chars = new char[n*2 - 1];
        Arrays.fill(chars, ' ');

        runDFS(0,result);

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void runDFS(int len, StringBuilder result) {
        if (len == n){
            result.append(chars).append("\n");
            return;
        }
        // 오른차순이 아니기 때문에 시작 위치는 처음위치로 고정하는 대신 방문여부를 기록해야한다.
        for (int i = 0; i < b.length; i++){
            if (b[i]) continue;
            b[i] = true;
            chars[len*2] = (char) (i + 1 + '0');
            runDFS(len + 1, result);
            b[i] = false;
        }
    }
}
