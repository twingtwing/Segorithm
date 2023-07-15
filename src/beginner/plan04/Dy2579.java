package beginner.plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dy2579 {
    /**
     * [2579 계단 오르기]
     * <br>
     * 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수<br>
     * top-down 방식이 아닌 down-top 방식 방식으로 진행되어야한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(reader.readLine());
        int [] stairs = new int[300];
        int [] score = new int[300];

        for (int i = 0; i < cnt; i++)
            stairs[i] = Integer.parseInt(reader.readLine());

        // 경우는 2개가 생긴다 : 연속 혹은 1개 텀을 두고 있는 경우
        score[0] = stairs[0];
        score[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
        score[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < cnt; i++)
            score[i] = Math.max(score[i-2] + stairs[i], score[i-3] + stairs[i-1] + stairs[i]);
        // 텀을 두고 있는 경우는 그전에 연속적인 경우를 고려해야하므로 i-3 지점에서 시작한다.

        System.out.println(score[cnt-1]); // 마지막 계단은 꼭 밞아야하기때문에 해당 지점을 호출한다.
        reader.close();
    }

}
