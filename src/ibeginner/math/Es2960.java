package ibeginner.math;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class Es2960 {
    /**
     * [2960 에라토스테네스의 체]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean [] isNotPrime = new boolean[sc.nextInt() + 1];
        int K = sc.nextInt();

        int idx = -1;
        for (int i = 2; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) continue;
            if (--K == 0){
                idx = i;
                break;
            }
            for (int j = i * i; j < isNotPrime.length; j+=i) {
                if (isNotPrime[j]) continue;
                isNotPrime[j] = true;
                if (--K == 0){
                    idx = j;
                    break;
                }
            }
            if (K == 0) break;
        }

        System.out.println(idx);
        sc.close();
    }
}
