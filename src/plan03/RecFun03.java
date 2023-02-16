package plan03;

import java.util.Scanner;
import java.util.StringTokenizer;

public class RecFun03 {
    public static void main(String[] args) {
        // 2447 : 별 찍기27
        Scanner scanner = new Scanner(System.in);


        int in = scanner.nextInt();
        loopStars((int) Math.cbrt(in), 3);

        scanner.close();
    }

    // 메모리 문제로 StringTokenizer, StringBuilder 사용을 줄임
    private static void loopStars(int count, int len) {
//        if (count == 1) return;
//        StringTokenizer token = new StringTokenizer(result.toString(),"\n");
//        result.setLength(0);
//
//        String [] str = new String[token.countTokens()];
//
//        for (int i = 0; i < str.length; i++) {
//            str[i] = token.nextToken();
//            result.append(str[i]).append(str[i]).append(str[i]).append("\n");
//        }
//
//        for (int i = 0; i < str.length; i++) {
//            result.append(str[i]);
//            for (int j = 0; j < len; j++) result.append(" ");
//            result.append(str[i]).append("\n");
//        }
//        for (int i = 0; i < str.length; i++) result.append(str[i]).append(str[i]).append(str[i]).append("\n");
//
//        loopStars(result, count-1, len*3);
    }
}
