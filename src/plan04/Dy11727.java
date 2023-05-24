package plan04;

import java.util.Scanner;

public class Dy11727 {
    /**
     * [11727 2×n 타일링 2]
     * <br>
     * 2×n 크기의 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램<br>
     * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력 (1 ≤ n ≤ 1,000)
     * <br><br>
     * !!KeyPoint!!<br>
     * 2×n 크기의 직사각형을 1×2, 2×1 => fibonacci 수열<br>
     * 2×n 크기의 직사각형을 1×2, 2×1과 2×2 타일 => fibonacci 수열 변형 : (n-2) * 2 + (n-1)
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = scanner.nextInt();
        int [] fibonacci = new int[1001];
        fibonacci[1] = 1;
        fibonacci[2] = 3;
        for (int i = 3; i <= cnt; i++)
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2] * 2) % 10007;

        System.out.println(fibonacci[cnt]);

        scanner.close();
    }
}
