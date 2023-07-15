package beginner.plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dy15486 {
    /**
     * [15486 퇴사2]
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        int [] date = new int[cnt + 2];

        int index;
        StringTokenizer token;
        for (int i = 1; i <= cnt; i++) {
            token = new StringTokenizer(reader.readLine());
            index = Integer.parseInt(token.nextToken()) + i;
            date[i] = Math.max(date[i - 1], date[i]) ; // 합산값 중의 최댓값 저장 (불필요한 변수 대신 안쓰는 배열 인덱스 사용)
            if (index > cnt + 1) continue; // 상담날짜를 제외한경우
            date[index] = Math.max(date[index], date[i] + Integer.parseInt(token.nextToken())); // 합산값 저장
        }

        System.out.println(Math.max(date[cnt + 1], date[cnt])); // 마지막날까지 상담한 경우
        reader.close();

    }
}
