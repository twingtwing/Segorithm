package plan03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecSort02 {
    /**
     * [10989 수 정렬하기 3]
     * <br>
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성<br>
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.<br>
     * 이 수는 10,000보다 작거나 같은 자연수이다.<br>
     *
     * KeyPoint!!
     * 정수가 아닌 자연수 이므로 음수는 존재하지 않는다.
     * 퀵정렬도 가능하나 배열로도 가능하다.
     * => 시간 복잡도는 O(N)
     * */
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        int [] sort = new int[10001];
        int count = cnt;

        while (cnt-- > 0)
            sort[Integer.parseInt(reader.readLine())] ++;

        for (int i = 1; i < sort.length; i++) {
            if (count == 0) break;
            for(int j = 1; j <= sort[i]; j++){
                result.append(i).append("\n");
                count --;
            }
        }

        System.out.println(result);
        reader.close();
    }
}
