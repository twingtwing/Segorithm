package plan04;

import java.util.Scanner;

public class Dy11054 {
    /**
     * [11054 가장 긴 바이토닉 부분 수열]
     * <br>
     * 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면,<br>
     * 그 수열을 바이토닉 수열<br>
     * 수열 A가 주어졌을 때,<br>
     * 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성<br>
     * 첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다.<br>
     * (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)<br>
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());

        int max = 0;
        int [] sort = new int[cnt];
        int [] plus = new int[cnt];  // 올라가는길
        int [] minus = new int[cnt]; // 내려가는길

        for (int i = 0; i < sort.length; i++) {
            plus[i] = 1;
            minus[i] = 1;
            sort[i] = scanner.nextInt();
            for (int j = i -1; j >= 0; j--) {
                if(sort[i] > sort[j])
                    plus[i] = Math.max(plus[i],plus[j] + 1);
                else if (sort[i] < sort[j])
                    minus[i] = Math.max(minus[i], Math.max(plus[j] + 1,minus[j] + 1));
            }
            max = Math.max(max, Math.max(minus[i],plus[i]));
        }

        System.out.println(max);
        scanner.close();
    }
}
