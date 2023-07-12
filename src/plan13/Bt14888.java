package plan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bt14888 {
    /**
     * [14888 연산자 끼워넣기]
     * <br>
     * 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. <br>
     * 나눗셈은 정수 나눗셈으로 몫만 취한다. <br>
     * */
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int [] A = new int[N];
        int [] operator = new int[4]; // + - x /
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(tokens.nextToken());

        backTrack(A, operator, 1, A[0]);

        System.out.println(max);
        System.out.println(min);
        reader.close();
    }

    private static void backTrack(int[] a, int[] operator, int i, int cal) {
        if (i == a.length){
            max = Math.max(cal, max);
            min = Math.min(cal, min);
            return;
        }
        for (int j = 0; j < 4; j++) {
            if (operator[j] == 0)
                continue;
            operator[j]--;
            int result = cal;
            switch (j){
                case 0 :
                    result += a[i];
                    break;
                case 1 :
                    result -= a[i];
                    break;
                case 2 :
                    result *= a[i];
                    break;
                case 3 :
                    result /= a[i];
                    break;
            }
            backTrack(a, operator, i + 1, result);
            operator[j]++;
        }
    }
}
