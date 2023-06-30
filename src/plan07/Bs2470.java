package plan07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bs2470 {
    /**
     * [2470 두 용액]
     * <br>
     * !!KeyPoint!!<br>
     * - 두개 의 합을 기준으로 s,e를 이동한다<br>
     * - 합이 0보다 크면 더 작은 양의 정수를 가져오고, 합이 0보다 작으면 더 작은 음의 정수를 가져오도록 한다.<br>
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int [] liquid = new int[N];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) 
            liquid[i] = Integer.parseInt(input[i]);
        Arrays.sort(liquid);

        int i = 0;
        int j = 0;
        int s = 0;
        int e = N - 1;
        int min = Integer.MAX_VALUE;

        int sum;
        while (s < e){
            sum = liquid[s] + liquid[e];
            if (Math.abs(sum) < min){
                i = liquid[s];
                j = liquid[e];
                min = Math.abs(sum);
            }

            if (sum < 0) // 절댓값이 작은 마이너스를 찾아감
                s++;
            else if (sum > 0) // 절갯값이 큰 플러스를 찾아감
                e--;
            else
                break;
        }

        System.out.println(i + " " + j);
        reader.close();
    }
}
