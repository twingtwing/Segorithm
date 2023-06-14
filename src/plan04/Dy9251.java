package plan04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dy9251 {
    /**
     * [9251 LCS]
     * <br>
     * LCS(Longest Common Subsequence, 최장 공통 부분 수열)
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = sc.nextLine();
        String two = sc.nextLine();

        char [] big = (one.length() > two.length() ? one : two).toCharArray();
        char [] small = (one.length() > two.length() ? two : one).toCharArray();

        int idx;
        int max = -1;
        for (int i = small.length - 1; i >= 0; i--) {
            if (max >= i) break;
            idx = i;
            for (int j = big.length - 1; j >= 0; j--) {
                if (idx < 0) break;
                if (small[idx] == big[j])
                    idx--;
            }
            max = Math.max((i - idx - 1), max);
        }

        System.out.println(max);
        sc.close();
    }
}
