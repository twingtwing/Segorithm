package plan04;

import java.util.Scanner;

public class Dy10844 {
    /**
     * [10844 쉬운 계단 수]
     * <br>
     * 45656이란 수를 보자. <br>
     * 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다. <br>
     * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자.<br>
     * 0으로 시작하는 수는 계단수가 아니다. <br>
     * 첫째 줄에 N이 주어진다. (1 <= N <= 100, 자연수)<br>
     * 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.<br><br>
     * KeyPoint<br>
     * 0부터 시작하지 않기때문에  규칙을 찾기가 힘들어서 추가 공간을 이용함
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int [][] stairs = new int[num + 1][10];

        for (int i = 1; i < 10; i++)
            stairs[1][i] = 1;

        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    stairs[i][j] = stairs[i - 1][j + 1] % 1000000000;
                else if(j == 9)
                    stairs[i][j] = stairs[i - 1][j - 1] % 1000000000;
                else
                    stairs[i][j] = (stairs[i - 1][j - 1] + stairs[i - 1][j + 1]) % 1000000000;
            }
        }

        long count = 0;
        for (int i = 0; i < 10; i++)
            count += stairs[num][i];

        System.out.println(count % 1000000000);
        sc.close();
    }
}
