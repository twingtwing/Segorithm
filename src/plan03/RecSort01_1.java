package plan03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecSort01_1 {
    /**
     * [2750 수 정렬하기]
     * <br>
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성<br>
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.<br>
     * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.<br>
     * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.<br><br>
     * 퀵정렬 대신 배열을 사용하는 경우 : 시간 복잡도는 O(N)
     * */
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        int num;
        boolean [] plus = new boolean[1001];
        boolean [] minus = new boolean[1001];

        while (cnt -- > 0){
            num = Integer.parseInt(reader.readLine());
            if (num >= 0)
                plus[num] = true;
            else
                minus[num * -1] = true;

        }
        for (int i = minus.length -1; i > 0; i--) {
            if (!minus[i]) continue;
            result.append(i * -1).append("\n");
        }
        for (int i = 0; i < plus.length; i++) {
            if (!plus[i]) continue;
            result.append(i).append("\n");
        }

        System.out.println(result);

        reader.close();

    }
}
