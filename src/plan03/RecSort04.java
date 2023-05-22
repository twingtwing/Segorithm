package plan03;

import java.util.Scanner;

public class RecSort04 {
    /**
     * [1427 소트인사이드]
     *<br>
     * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬<br>
     * 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수<br>
     * 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력<br>
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        StringBuilder result = new StringBuilder();
        int [] sort = new int[10];

        while(num >= 1){
            sort[num%10]++;
            num/=10;
        }

        for (int i = 9; i >= 0; i--)
            result.append(String.valueOf(i).repeat(Math.max(0, sort[i])));

        System.out.println(result);
    }
}
