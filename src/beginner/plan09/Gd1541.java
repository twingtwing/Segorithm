package beginner.plan09;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Gd1541 {
    /**
     * [1541 잃어버린 괄호]
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer minus = new StringTokenizer(scanner.nextLine(),"-");

        int sum = 0;
        StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
        while (plus.hasMoreTokens()){
            sum += Integer.parseInt(plus.nextToken());
        }

        while (minus.hasMoreTokens()) {
            plus = new StringTokenizer(minus.nextToken(), "+");
            while (plus.hasMoreTokens()) {
                sum -= Integer.parseInt(plus.nextToken());
            }
        }

        System.out.println(sum);
        scanner.close();
    }
}
