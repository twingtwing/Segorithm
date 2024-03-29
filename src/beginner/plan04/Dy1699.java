package beginner.plan04;

import java.util.Scanner;

public class Dy1699 {
    /**
     * [1699 제곱수의 합]
     * <br>
     * 어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다.<br>
     * (제곱수 : 어떤 자연수를 두 번 곱해서 나오는 정수)<br>
     * 예를 들어 11=3^2+1^2+1^2(3개 항)이다.<br>
     * 이런 표현방법은 여러 가지가 될 수 있는데, 11의 경우 11=2^2+2^2+1^2+1^2+1^2(5개 항)도 가능하다.<br>
     * 이 경우, 수학자 숌크라테스는 “11은 3개 항의 제곱수 합으로 표현할 수 있다.”라고 말한다. <br>
     * 또한 11은 그보다 적은 항의 제곱수 합으로 표현할 수 없으므로, <br>
     * 11을 그 합으로써 표현할 수 있는 제곱수 항의 최소 개수는 3이다.<br>
     * 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램<br><br>
     * 첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)<br>
     * 제곱수의 합으로 나타낼 때에 그 제곱수 항의 최소 개수를 출력한다.<br><br>
     * top-down 방식이 아닌 down - top 방식으로 진행<br>
     * 최대한 이중루프 범위를 줄여야함<br>
     * Math.sqrt() 은 오히려 속도를 줄임
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int [] dp = new int[num + 1];

        // Math.sqrt() 같은 제곱근 계산은 오히려 속도를 줄이기때문에 j*j로 치환해서 최대한 속도를 줄여야함
        for (int i = 1; i <= num; i++){
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) // 범위를 제곱근으로 줄임
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 제곱수는 무조건 1이기 때문

        }

        System.out.println(dp[num]);
        scanner.close();
    }
}
