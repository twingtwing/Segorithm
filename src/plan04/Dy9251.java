package plan04;

import java.util.Scanner;

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

        int [][] len = new int[2][small.length + 1];

        len[1][0] = -1;
        for (int i = 0; i < small.length; i++) {
            len[0][i + 1] = len[0][i];
            len[1][i + 1] = len[1][i];
            for (int j = 0; j < big.length; j++) {
                if (small[i] == big[j] && len[1][i] < j){
                    if(len[1][i] < j){
                        len[1][i + 1] = j;
                        len[0][i + 1]++;
                        break;
                    }
                    // 오류
                    // ABCDEFG
                    // BCDEFGA
                }
            }
        }

        System.out.println(len[0][small.length]);
        sc.close();
    }
}
