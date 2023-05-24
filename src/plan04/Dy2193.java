package plan04;

import java.util.Scanner;

public class Dy2193 {
    /**
     * [2193 이친수]
     * <br>
     * 0과 1로만 이루어진 수를 이진수라 한다.<br>
     * 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다.<br><br>
     * 1. 이친수는 0으로 시작하지 않는다.<br>
     * 2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.<br>
     * 예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다.<br>
     * 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.<br><br>
     * N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        Long [] fibonacci = new Long[91];
        fibonacci[1] = 1L;
        fibonacci[2] = 1L;

        for (int i = 3; i <= num; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        System.out.println(fibonacci[num]);
        scanner.close();
    }
}
