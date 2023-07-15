package beginner.plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dy9095 {
    /**
     * [9095 1,2,3 더하기]
     * <br>
     * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.<br>
     * - 1+1+1+1<br>
     * - 1+1+2<br>
     * - 1+2+1<br>
     * - 2+1+1<br>
     * - 2+2<br>
     * - 1+3<br>
     * - 3+1<br>
     * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램. <br>
     * n은 양수이며 11보다 작다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int cnt = Integer.parseInt(reader.readLine());
        int [] fibnacci = new int[11];
        fibnacci[1] = 1;
        fibnacci[2] = 2;
        fibnacci[3] = 4;

        for (int i = 4; i < fibnacci.length; i++)
            fibnacci[i] = fibnacci[i-1] + fibnacci[i-2] + fibnacci[i-3];

        while (cnt-->0)
            result.append(fibnacci[Integer.parseInt(reader.readLine())]).append("\n");

        System.out.println(result);
        reader.close();
    }
}
