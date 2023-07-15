package beginner.plan03;

import java.io.*;
import java.util.Scanner;

public class RecFibonacci01 {
    public static void main(String[] args) throws IOException {
        // 10870 : 피보나치 수
        Scanner scanner = new Scanner(System.in);

        int point = scanner.nextInt();
        int [] fibonacci = new int[21];
        fibonacci[1] = 1;

        for (int i = 0; i < point - 1; i++) fibonacci[i + 2] = fibonacci[i+1] + fibonacci[i];

        System.out.println(fibonacci[point]);

        scanner.close();

    }
}
