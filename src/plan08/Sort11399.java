package plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort11399 {
    /**
     * [11399 ATM]
     * <br>
     * 버블정렬
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String [] input = reader.readLine().split(" ");
        int [] sort = new int[N];

        for (int i = 0; i < N; i++)
            sort[i] = Integer.parseInt(input[i]);

        int tmp;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (sort[j] > sort[j + 1]){
                    tmp = sort[j];
                    sort[j] = sort[j+1];
                    sort[j+1] = tmp;
                }
            }
        }

        int sum = sort[0];
        for (int j = 1; j < N; j++) {
            sort[j] += sort[j - 1];
            sum += sort[j];
        }

        System.out.println(sum);
        reader.close();
    }
}
