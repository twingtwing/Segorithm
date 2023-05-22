package plan03;

import java.math.BigInteger;
import java.util.Scanner;

public class RecHanoi01 {
    /**
     * [1914 하노이 탑]
     * <br>
     * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.
     * 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
     * 
     * 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
     * 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
     * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
     * 입력값이 20보다 많은 경우는 출력할 필요가 없다.
     *
     * KeyPoint
     * 1. 실제 값이 이동하지 않고, 가상으로 값을 변경한다.
     * 2. 1 -> 2 -> 3 으로 재귀 처리 하지 않고 3 -> 2 -> 1 로 재귀 처리한다.
     * 3. 오름차순으로 완성된 탑의 from 값을 to로 이동할때는 무조건 값이 크므로, 미리 옮겨 주어야한다.
     *    미리 이동해주는게 중요하다.
     * 4. 미리 이동하기 때문에, to위치의 탑 갯수는 from값 - 1 이댜.
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        System.out.println(BigInteger.valueOf(2).pow(num).subtract(BigInteger.ONE));

        if (num <= 20){
            move(num, 1, 2, 3);
        }

    }

    public static void move(int num, int from, int other,int to){
        if (num == 1) {
            System.out.println(from + " " + to);
            return;
        }
        // 꼭대기 층까지 홀수, 짝수 위치 재귀적으로 변경
        move(num - 1, from, to, other);

        System.out.println(from + " " + to);

        // from값의 다음값은 무조건 other값 보다 끌 것이기 때문에
        // other값들을 to위치로 모두 미리 이동해야한다.
        // 그래서 other 탑 값을 모두 이동시키는 재귀함수를 발동한다.
        // to가 아니라 왜 other이면 홀수 짝수 위치가 변경되기 때문이다.
        move(num - 1, other, from, to);

    }


}
