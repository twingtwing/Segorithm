package beginner.plan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bt14889 {
    /**
     * [14889 스타트와 링크]
     * <br>
     * 규칙이 존재함 => row, col을 분리해서 계산 가능함
     * */
    private static int min;
    private static int [][] power;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 짝수

        int sum = 0;
        StringTokenizer tokens;
        power = new int[N][2];
        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++){
                int num = Integer.parseInt(tokens.nextToken());
                sum += num;
                power[i][0] += num;
                power[j][1] += num;
            }
        }

        min = Integer.MAX_VALUE;

        backTracking( 1, N / 2 - 1, sum - power[0][0] - power[0][1]);

        System.out.println(min);
        reader.close();
    }

    private static void backTracking(int s, int cnt, int sum) {
        if (cnt == 0){
            min = Math.min(min, Math.abs(sum));
            return;
        }

        for (int i = s; i <= power.length - cnt; i++)
            backTracking(i + 1, cnt - 1, sum- power[i][0] - power[i][1]); // 시작 위치가 중요!!!

    }

}
