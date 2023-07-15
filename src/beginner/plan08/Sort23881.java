package beginner.plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort23881 {
    /**
     * [23881  - 알고리즘 수업 - 선택 정렬 1]
     * <br>
     * 선택정렬
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input= reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int [] sort = new int[N];

        input = reader.readLine().split(" ");
        for (int i = 0; i < sort.length; i++)
            sort[i] = Integer.parseInt(input[i]);

        int tmp;
        int maxIdx;
        for (int j = N - 1; j >= 0; j--) {
            maxIdx = j;
            for (int k = j - 1; k >= 0; k--) {
                if (sort[k] > sort[maxIdx])
                    maxIdx = k;
            }
            if (j != maxIdx){
                tmp = sort[maxIdx];
                sort[maxIdx] = sort[j];
                sort[j] = tmp;
                if (--K < 1){
                    System.out.println(sort[maxIdx] + " " + sort[j]);
                    break;
                }
            }
        }

        if (K > 0)
            System.out.println(-1);

        reader.close();
    }
}
