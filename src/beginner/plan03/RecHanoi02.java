package beginner.plan03;

import java.math.BigInteger;
import java.util.Scanner;

public class RecHanoi02 {
    /**
     * [11729 하노이 탑 이동 순서]
     * <br>
     * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다.
     * 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
     *
     * 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
     * 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
     * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
     *
     * 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.
     *
     * 두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,
     * 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
     *
     * KeyPoint!!
     * System.out.println() 여러개가 있을 경우 StringBuilder가 속도가 빠르다.
     * */
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        result.append(BigInteger.valueOf(2).pow(num).subtract(BigInteger.ONE)).append("\n");

        recHanoi(num, 1, 2, 3, result);

        System.out.print(result);

    }

    private static void recHanoi(int num, int from, int other, int to, StringBuilder result) {
        if (num == 1){
            result.append(from).append(" ").append(to).append("\n");
            return;
        }

        recHanoi(num-1, from, to, other, result);
        result.append(from).append(" ").append(to).append("\n");
        recHanoi(num-1,other, from, to, result);

    }
}
