package beginner.plan11;

import java.util.Scanner;

public class St1786 {
    /**
     * [1786 찾기]
     * <br>
     * KMP 알고리즘<br>
     * 문자열 P가 문자열 T 중간에 몇 번, 어느 위치에서 나타나는지 알아내는 문제를 '문자열 매칭'이라고 한다.
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String ptn = sc.nextLine();

        // 패턴 문자열을 전처리하여 접두사와 접미사가 일치하는 부분을 구함
        int len = 0; // 배열을 순회하는 인덱스
        int idx = 1; // 패턴 문자열을 순회하는 인덱스
        int [] LPS = new int[ptn.length()];

        while (idx < ptn.length()) {
            if (ptn.charAt(idx) == ptn.charAt(len))
                LPS[idx++] = ++len;
            else if (len != 0)
                len = LPS[len - 1];
            else
                LPS[idx++] = 0;
        }

        // 패턴 문자열을 사용하여 검색 대상 문자열을 순회하면서 매칭
        int i = 0;
        int j = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (i < txt.length()) {
            if (txt.charAt(i) == ptn.charAt(j)){
                i++;
                j++;
                if (j == ptn.length()){
                    count++;
                    sb.append(i - j + 1).append(" ");
                    j = LPS[j - 1]; // 겹치는 위치가 중복이 될수가 있음
                }
            } else if (j != 0)
                j = LPS[j - 1];
            else i++;
        }

        // 몇번 나오는지
        // 나오는 위치 index
        System.out.println(count);
        System.out.println(sb);
        sc.close();
    }
}
