package plan1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MathProgress01_Short{
    static int N, M;
    static boolean[] check;
    static char[] answer;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 15649 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열 (1 ≤ M ≤ N ≤ 8)
        // DFS ???
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        answer = new char[2 * M];

        for(int i = 0; i < M - 1; i++)
            answer[2 * i + 1] = ' ';

        answer[2 * M - 1] = '\n';

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int m) {
        if(m == M) {
            sb.append(answer);
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!check[i]) {
                check[i] = true;
                answer[2 * m] = (char)(i + '0');

                dfs(m + 1);

                check[i] = false;
            }
        }
    }
}