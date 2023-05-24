package plan04;

import java.util.Scanner;

public class Dy1463 {
    /**
     * [1463 1로 만들기]
     * <br>
     * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.<br>
     * - X가 3으로 나누어 떨어지면, 3으로 나눈다.<br>
     * - X가 2로 나누어 떨어지면, 2로 나눈다.<br>
     * - 1을 뺀다.<br>
     * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.<br>
     * 연산을 사용하는 횟수의 최솟값을 출력하시오.<br><br>
     * 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.<br><br>
     * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.<br><br>
     * !!KeyPoint!!<br>
     * 1. 2 or 3의 배수라 할지라도 최소 경로임은 알 수 없다. => 경우의 수를 구해야한다.<br>
     * 2. 배열을 사용가능하기 위해서 앞에서 풀이한다.<br>
     *    뒤에서부터 풀이하면 재귀함수로 풀어야하는데 이러면, 경우의 수 문제로 오래 걸린다.<br>
     * 3. 6의 배수인 경우, -1,/2,/3 모두 비교해야한다.
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        int [] path = new int[1000001];
        path[2] = 1;
        path[3] = 1;

        for (int i = 4; i <= num; i++) {
            path[i] = path[i-1] + 1;
            if (i % 2 == 0)
                path[i] = Math.min(path[i/2]+1, path[i]);
            if (i % 3 ==0) // 6의 배수일 경우 고려 -> else if 가 아니라 if
                path[i] = Math.min(path[i/3]+1, path[i]);
        }

        System.out.println(path[num]);
    }


}
