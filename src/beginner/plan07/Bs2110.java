package beginner.plan07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs2110 {
    /**
     * [2110 공유기 설치]
     * <br>
     * !!KeyPoint<br>
     * - 최대 거리를 기준으로 구한다.<br>
     * - 최대 거리를 줄어나가면서 공유기 갯수가 일치한 거리를 구한다.<br>ㄴ
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int C = Integer.parseInt(tokens.nextToken());

        int [] houses = new int[N];
        for (int i = 0; i < N; i++)
            houses[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(houses);

        int s = 1; // 최소거리
        int e = houses[N -1] - houses[0]; // 최대거리
        int result = 0;

        int mid;
        int previous;
        int distacne;
        int cnt = 0;

        // 지점을 구하는게 아니라 거리를 구하는 문제이므로
        // 거리로 재귀함수를 한다.
        while (s <= e){
            cnt = 1;
            previous = houses[0];
            mid = (s + e) / 2;

            for (int j = 1; j < N; j++) {
                distacne = houses[j] - previous;
                if (distacne >= mid){
                    cnt++;
                    previous = houses[j];
                }
            }

            if (C <= cnt){
                // 꼭 명확하게 C = cnt일 필요가 없다.
                // 거리를 구하는거기 때문에 가능한 거리만 구하면된다.
                result = mid;
                s = mid + 1; // 거리를 늘린다.
            }
            else
                e = mid - 1; // 거리를 좁힌다.

        }

        System.out.println(result);
        reader.close();
    }
}
