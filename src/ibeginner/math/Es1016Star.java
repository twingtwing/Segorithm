package ibeginner.math;

import java.util.Scanner;

public class Es1016Star {
    /**
     * [1016 제곱 ㄴㄴ 수]
     * <br>
     * 해당 문제는 소수를 찾는게 아니라 제곱수의 배수를 찾는 것이 목표이다.<br>
     * 대신, 찾는 방식을 에라토스테네스의 체를 이용해서 구현한것이다.<br>
     * 물론 소수를 찾은 후에 전개하여도 괜찮지만, <br>
     * 오히려 소수를 찾는 loop를 한 번 더 돌아야하므로 불필요한 작업이다.
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        int count = (int) (max - min + 1);
        boolean [] isSquare = new boolean[count];

        // 제곱수 찾기
        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long s = (min / square) * square;
            if (s < min)
                s += square;
            for (long j = s; j <= max; j+=square) {
                if (!isSquare[(int) (j - min)]){
                    isSquare[(int) (j - min)] = true;
                    count--;
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
