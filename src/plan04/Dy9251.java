package plan04;

import java.util.Scanner;

public class Dy9251 {
    /**
     * [9251 LCS]
     * <br>
     * LCS(Longest Common Subsequence, 최장 공통 부분 수열)
     * <br>
     * i를 j개의 정수로 더해서 만들 수 있는 경우의 수<br> = <br>
     * 0 ~ i를 j - 1 개의 정수로 더해서 만들 수 있는 경우의 수 합산<br>
     * 위의 경우를 성립하기 위해 길이 저장 인덱스와 <br>
     * 기준이 되는 문자열의 인덱스가 같이 진행되도록 하여 <br>
     * 역순을 고려하지 않아도 되도록 진행한다.
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = sc.nextLine();
        String two = sc.nextLine();

        char [] big = (one.length() > two.length() ? one : two).toCharArray();
        char [] small = (one.length() > two.length() ? two : one).toCharArray();

        int [] len = new int[small.length]; // 길이 저장

        int tmp;
        // 나의 문제 : 기준이 되는 문자열을 바깥쪽에서 진행되도록 해서
        //            역순을 고민하도록 진행했다
        for (int i = 0; i < big.length; i++) {
            tmp = 0;
            // 큰 경우를 먼저 하지않고,
            // 작은 경우를 먼저 함으로써 인덱스가 차례대로 진행된다.
            // 그러므로 역순을 고민하지 않아도 괜찮다
            for (int j = 0; j < small.length; j++) {
                // j 번째 글자를 포함하지 않은경우가 길이가 더 긴 경우
                // 길이 저장 인덱스와 작은 글자 인덱스가 같이 진행되므로 역순을 고려하지 않아도 된다.
                if (len[j] > tmp)
                    tmp = len[j];
                // j번째 길이를 포함하는 경우
                else if (big[i] == small[j])
                    len[j] = tmp + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < len.length; i++) {
            max = Math.max(max, len[i]);
        }

        System.out.println(max);
        sc.close();
    }
}
