package plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort2751 {
    /**
     * [2751 수 정렬하기2]
     * <br>
     * 퀵정렬
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Integer [] sort = new Integer[N];

        // 절댓값이 1,000,000보다 작거나 같은 정수
        for (int i = 0; i < N; i++)
            sort[i] = Integer.parseInt(reader.readLine());

        // 백준 숫자 무작위로 섞기
        List<Integer> list = Arrays.asList(sort);
        Collections.shuffle(list);

        sort = list.toArray(new Integer[0]);

        quickSort(sort, 0, N - 1);

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < N; j++)
            result.append(sort[j]).append("\n");

        System.out.println(result);
        reader.close();
    }

    private static void quickSort(Integer[] sort, int s, int e) {
        int pivot = partiion(sort, s, e);
        if(s < pivot - 1) quickSort(sort, s, pivot - 1);
        if(pivot < e)quickSort(sort, pivot, e);

    }

    private static int partiion(Integer[] sort, int s, int e) {
        int pivot = sort[(s + e) / 2];

        do{ // do하는 이유?
            while (sort[s] < pivot) s++;
            while (sort[e] > pivot) e--;
            if (s <= e){
                int tmp = sort[s];
                sort[s ++] = sort[e];
                sort[e --] = tmp;
            }

        } while (s <= e);

        return s;
    }
}
