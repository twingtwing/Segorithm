package beginner.plan13;

import java.util.Scanner;

public class Bt15652 {
    /**
     * [15652 N과 M (4)]
     * */
    private static StringBuilder result;
    private static char[] chars;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        chars = new char[M*2];
        result = new StringBuilder();
        for (int i = 1; i < chars.length; i+=2) 
            chars[i] = ' ';
        
        for (int j = 1; j <= N; j++) {
            chars[0] = (char) (j + '0');
            backTracking(chars, 2, N);
        }
        
        System.out.println(result);
        sc.close();
    }

    private static void backTracking(char[] chars, int i, int n) {
        if (i >= chars.length){
            result.append(chars).append("\n");
            return;
        }
        for (int j = chars[i-2] - '0'; j <= n; j++) {
            chars[i] = (char)(j + '0');
            backTracking(chars, i + 2, n);
        }
    }
}
