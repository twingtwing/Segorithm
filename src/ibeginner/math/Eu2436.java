package ibeginner.math;

import java.util.Scanner;

public class Eu2436 {
    /**
     * [2436 공약수]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gcd = sc.nextInt();
        int lcm = sc.nextInt();
        int div = lcm / gcd;

        int min = 100000001;
        int max = 100000001;
        for (int i = 1; i * i <= div; i++) {
            if (div % i != 0)
                continue;
            int other = (div / i);

            int a = other;
            int b = i;
            while (b> 0){
                int tmp = a;
                a = b;
                b = tmp % b;
            }
            if (a > 1) continue;

            if (max + min > gcd * other){
                max = gcd * other;
                min = gcd * i;
            }
        }

        System.out.println(min + " " + max);
        sc.close();
    }
}
