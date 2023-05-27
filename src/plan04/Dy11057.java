package plan04;

import java.util.Scanner;

public class Dy11057 {
    /**
     * [11057 오르막 수]
     * 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다.<br>
     * 이때, 인접한 수가 같아도 오름차순으로 친다.<br>
     * 예를 들어, 2234와 3678, 11119는 오르막 수이지만,<br>
     * 2232, 3676, 91111은 오르막 수가 아니다.<br>
     * 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램<br>
     * 수는 0으로 시작할 수 있다. (1 ≤ N ≤ 1,000)<br><br>
     *  길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력<br><br>
     * KeyPoint<br>
     * 0부터 시작하기때문에 추가공간없이 규칙을 사용함<br>
     * n의 값은 이전 경우의 1..n-1을 더한값이다.
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int cnt = sc.nextInt();
        int [] increa = new int[11];

        for (int i = 1; i < 11; i++)
            increa[i] = 1;

        while (--cnt> 0) {
            for (int i = 1; i <= 10; i++)
                increa[i] = (increa[i-1] + increa[i]) % 10007;
        }

        for (int i : increa)
            sum += i;

        System.out.println(sum % 10007);

        sc.close();
    }
}
