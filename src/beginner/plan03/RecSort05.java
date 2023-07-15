package beginner.plan03;

import java.util.Scanner;

public class RecSort05 {
    /**
     * [2947 나무 조각]
     * <br>
     * 동혁이는 나무 조각을 5개 가지고 있다. 나무 조각에는 1부터 5까지 숫자 중 하나가 쓰여져 있다.<br>
     * 또, 모든 숫자는 다섯 조각 중 하나에만 쓰여 있다.<br><br>
     * 동혁이는 나무 조각을 다음과 같은 과정을 거쳐서 1, 2, 3, 4, 5 순서로 만들려고 한다.<br><br>
     * 1.첫 번째 조각의 수가 두 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.<br>
     * 2.두 번째 조각의 수가 세 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.<br>
     * 3.세 번째 조각의 수가 네 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.<br>
     * 4.네 번째 조각의 수가 다섯 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.<br>
     * 5.만약 순서가 1, 2, 3, 4, 5 순서가 아니라면 1 단계로 다시 간다.<br>
     * 처음 조각의 순서가 주어졌을 때, 위치를 바꿀 때 마다 조각의 순서를 출력하는 프로그램을 작성하시오.<br>
     * <br>
     * 첫째 줄에 조각에 쓰여 있는 수가 순서대로 주어진다.<br>
     * 숫자는 1보다 크거나 같고, 5보다 작거나 같으며, 중복되지 않는다. 처음 순서는 1, 2, 3, 4, 5가 아니다.<br>
     * 두 조각의 순서가 바뀔때 마다 조각의 순서를 출력한다.<br><br><br>
     * KeyPoint!!
     * 해당 방법은 버블정렬이다.
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sort = new int[5];

        for (int i = 0; i < sort.length; i++)
            sort[i] = scanner.nextInt();

        System.out.println(bubbleSort(sort));

        scanner.close();

    }

    private static StringBuilder bubbleSort(int[] sort) {
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (int i = 1; i < sort.length; i++) {
            if (sort[i - 1] > sort[i]) {
                swap(sort,i-1, i);
                result.append(aryToStr(sort)).append("\n");
            }
            if (sort[i-1] != i) flag = true;
        }
        if (flag) result.append(bubbleSort(sort)).append("\n");
        return result;
    }

    private static StringBuilder aryToStr(int[] sort) {
        StringBuilder str = new StringBuilder();
        for (int i : sort) str.append(i).append(" ");
        return str;
    }

    private static void swap(int[] sort, int one, int two) {
        int tmp = sort[two];
        sort[two] = sort[one];
        sort[one] = tmp;
    }

}
