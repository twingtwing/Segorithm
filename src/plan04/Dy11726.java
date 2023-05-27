package plan04;

import java.io.IOException;
import java.util.Scanner;

public class Dy11726 {
    /**
     * [11726 2×n 타일링]
     * <br>
     * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램<br>
     * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력 (1 ≤ n ≤ 1,000)<br><br>
     * !!KeyPoint!!<br>
     * 1. Long type 이라 할지라도 오버플로우가 날 수 있다.
     * 2. Mod를 계속 처리하는 것이 오버플로우 방지할수있다.
     * */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Long [] fibonacci = new Long[1001];
        int cnt = scanner.nextInt();
        fibonacci[1] = 1L;
        fibonacci[2] = 2L;

        for (int i = 3; i <= cnt; i++)
            fibonacci[i] = ( fibonacci[i-1] + fibonacci[i-2] ) % 10007;

        System.out.println(fibonacci[cnt]);
    }
}
