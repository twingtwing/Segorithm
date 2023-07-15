package beginner.plan03;

import java.util.Arrays;
import java.util.Scanner;

public class RecFun03 {
    public static void main(String[] args) {
        // 2447 : 별 찍기27
        Scanner scanner = new Scanner(System.in);

        // 메모리 문제로 StringTokenizer, StringBuilder 사용을 줄임
        // 왜 메모리가 많이 드는 걸까?
        int in = scanner.nextInt();
        int sqrt = (int) Math.pow(3,in);

        char [][] stars = new char[sqrt][sqrt];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) stars[i][j] = ' ';
                else stars[i][j] = '*';
            }
        }
        loopStart(stars, in, 1);

        scanner.close();
    }

    private static void loopStart(char[][] stars, int in, int cnt) {
        if (cnt == in){
            System.out.print(Arrays.toString(stars));
            return;
        }
//        for (int i = 0; i < cnt*3; i++) {
//
//        }
        loopStart(stars,in,cnt+1);
    }

}
