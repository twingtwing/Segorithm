package beginner.plan11;

import java.util.Scanner;
import java.util.StringTokenizer;

public class St2902 {
    /**
     * [2902 KMP는 왜 KMP일까?]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(),"-");

        StringBuilder result = new StringBuilder();
        while (st.hasMoreTokens())
            result.append(st.nextToken().charAt(0));

        System.out.println(result);
        sc.close();
    }
}
