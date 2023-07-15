package beginner.plan03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecSort01_2 {
    /**
     * [2750 수 정렬하기]
     * <br>
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성<br>
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.<br>
     * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.<br>
     * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.<br><br>
     * 재귀함수 버전<br>
     * !!Key Point<br>
     * 퀵 정렬(Quick Sort)은 재귀적인 접근을 기반으로 한 정렬 알고리즘 : 시간 복잡도는 O(NlogN)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int cnt = Integer.parseInt(reader.readLine());
        int [] sort = new int[cnt];

        while (cnt -- > 0)
            sort[cnt] = Integer.parseInt(reader.readLine());

        quickSort(sort, 0, sort.length - 1);

        for(int i : sort)
            result.append(i).append("\n");

        System.out.println(result);
        reader.close();

    }

    private static void quickSort(int[] sort, int start, int end) {
        if (start >= end) return;
        int divide = divide(sort, start, end);
        quickSort(sort, start, divide - 1);
        quickSort(sort, divide, end);
    }

    private static int divide(int[] ary, int start, int end) {
        int pivot = ary[(start + end) / 2];
        while (start <= end){
            while (ary[start] < pivot) start ++; // 큰값 찾을때까지 이동
            while (ary[end] > pivot) end--; // 작은값 찾을때까지 이동
            if (start <= end){ // start > pivot > end 상태 => swap
                swap(ary, start, end);
                start ++;
                end --;
            }
        }
        return start;
    }

    private static void swap(int[] ary, int one, int two) {
        int tmp = ary[one];
        ary[one] = ary[two];
        ary[two] = tmp;
    }
}
