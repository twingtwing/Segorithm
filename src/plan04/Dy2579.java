package plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dy2579 {
    /**
     * [2579 계단 오르기]
     * <br>
     * 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(reader.readLine());
        int [] stairs = new int[cnt + 1];

        for (int i = 1; i <= cnt; i++)
            stairs[i] = Integer.parseInt(reader.readLine());

        // 답보기

        reader.close();
    }

}
