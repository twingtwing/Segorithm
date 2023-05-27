package plan04;

import java.util.Scanner;

public class Dy11055 {
    /**
     * [11055 가장 큰 증가하는 부분 수열]
     * <br>
     * 수열 A가 주어졌을 때,
     * 그 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램<br><br>
     * 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우,<br>
     * 합이 가장 큰 증가하는 부분 수열은 A = {1, 2, 50, 60}<br><br>
     * 동적 계획법으로 풀이<br>
     * 오름차순만뿐만 아니라 합계라는 조건이 있어서 이진검색 알고리즘 힘듦
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());

        int max = 0;
        int [] sort = new int[cnt + 1];
        int [] sum = new int[cnt + 1];

        for (int i = 1; i <= cnt; i++) {
            sort[i] = scanner.nextInt();
            sum[i] = sort[i];
            for (int j = 1; j < i; j++) {
                if (sort[i] > sort[j])
                    sum[i] = Math.max(sum[i], sum[j] + sort[i]);
            }
            max = Math.max(sum[i], max);
        }

        System.out.println(max);
        scanner.close();
    }


}
