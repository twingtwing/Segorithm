package plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dy2579 {
    /**
     * [2579 계단 오르기]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int cnt = Integer.parseInt(reader.readLine());
        int [] sort = new int[cnt + 1];

        for (int i = 1; i <= cnt; i++)
            sort[i] = Integer.parseInt(reader.readLine());

        sum = sort[cnt];

        while (cnt > 2){
            sum+= Math.max(sort[cnt - 1] , sort[cnt - 2]);
            cnt-=2;
            // 상태가 3 혹은 2인 경우
        }

        System.out.println(sum);
        reader.close();
    }
}
