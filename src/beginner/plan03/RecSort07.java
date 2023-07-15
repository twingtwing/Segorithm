package beginner.plan03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RecSort07 {
    /**
     * [18870 좌표 압축]
     * <br>
     * 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.<br>
     * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.<br>
     * X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.<br><br>
     * 첫째 줄에 N이 주어진다.<br>
     * 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.<br><br>
     * 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder result = new StringBuilder();

        int [] origin = new int[cnt];
        int [] coordinates = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            origin[i] = Integer.parseInt(tokenizer.nextToken());
            coordinates[i] = origin[i];
        }

        Arrays.sort(coordinates); // 좌표 정렬

        int index = 0;
        Map<Integer, Integer> compress = new HashMap<>();
        compress.put(coordinates[0],index);

        for (int i = 1; i < cnt; i++) {
            if (coordinates[i] != coordinates[i-1]){
                index++;
                compress.put(coordinates[i],index);
            }
        }

        for (int i = 0; i < cnt; i++) {
            result.append(compress.get(origin[i])).append(" ");
        }

        System.out.println(result);
        reader.close();
    }
}
