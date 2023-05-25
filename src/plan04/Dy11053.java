package plan04;

import java.util.Scanner;

public class Dy11053 {
    /**
     * [11053 가장 긴 증가하는 부분 수열]
     * <br>
     * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램<br>
     * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우,<br>
     * 가장 긴 증가하는 부분 수열은 A = {10, 20, 30, 50} 이고, 길이는 4이다.<br><br>
     * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
     * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)<br><br>
     * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());

        int [] sort = new int[cnt];
        int [] len = new int[cnt];

        int max = 1;
        for (int i = 0; i < sort.length; i++) {
            len[i] = 1;
            sort[i] = scanner.nextInt();
            for (int j = 0; j < i; j++){
                if (sort[j] < sort[i])
                    len[i] = Math.max(len[i], len[j] + 1);
            }
            max = Math.max(len[i],max);
        }

        System.out.println(max);
        scanner.close();
    }
}
