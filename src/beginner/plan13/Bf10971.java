package beginner.plan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bf10971 {
    /**
     * [10971 외판원 순회 2]
     * <br>
     * 백트랭킹 문제
     * */
    private static int min;
    private static int [][] pay;
    private static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        pay = new int[N][N];
        visited = new boolean[N];

        StringTokenizer str;
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++)
                pay[i][j] = Integer.parseInt(str.nextToken());
        }

        visited[0] = true; // 미리 0을 막아서 도착전에는 0이 오지 못하도록 한다.
        min = Integer.MAX_VALUE;
        backTracking(0, 0, N);

        System.out.println(min);
        reader.close();
    }

    private static void backTracking(int i, int sum, int n) {
        if (n == 1){ // 강제적으로 0이 마지막으로 오도록해야함
            if(pay[i][0] > 0)
                min = Math.min(min, sum + pay[i][0]);
            return;
        }
        for (int j = 1; j < pay.length; j++) {
            if (pay[i][j] == 0 || visited[j]) continue;
            visited[j] = true;
            backTracking(j, sum + pay[i][j], n -1);
            visited[j] = false;
        }
    }
}

