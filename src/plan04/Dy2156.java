package plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dy2156 {
    /**
     * [2156 포도주 시식]
     * <br>
     *  3 연속을 못하기 때문에 현재 위치의 4 전까지 찾아야한다 ?
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());

        int [] sum = new int[cnt + 1];
        int [] list = new int[cnt + 1];

        list[1] = Integer.parseInt(reader.readLine());
        sum[1] = list[1];
        int max = sum[1];

        for (int i = 2; i <= cnt; i++) {
            list[i] = Integer.parseInt(reader.readLine());
            if (i == 2)
                sum[i] = list[2] + list[1];
            else
                sum[i] = list[i] + Math.max(list[i-1] + (i > 3 ? Math.max(sum[i-3], sum[i-4]) : sum[i-3]), sum[i-2]);
            max = Math.max(sum[i], max);
        }

        System.out.println(max);
        reader.close();
    }
}
