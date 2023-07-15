package beginner.plan10;

import java.util.Scanner;

public class Es1065 {
    /**
     * [1065 한수]
     * <br>
     * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.<br>
     * 이 등차수열이 오름차순 혹은 내림차순일 수 있다.
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int sum = Math.min(input, 99);

        // 100
        int beak = input == 1000 ? 9 : input / 100;
        while (beak > 0){
            for (int i = 0; i < 5; i++) {
                if (beak * 111 - i * 12 <= input && beak >= i * 2)
                    sum++;
                if (beak * 111 + i * 12 <= input && beak + i * 2 < 10 && i > 0)
                    sum++;
            }
            beak--;
        }

        System.out.println(sum);
        sc.close();
    }
}
