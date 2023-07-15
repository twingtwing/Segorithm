package beginner.plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort1946_A {
    /**
     * [1946 신입사원]
     * <br>
     * 누누히 말하지만 배열을 사용하면 굳이 정렬할 필요가 없으니
     * 가급적 배열을 사용(용량이 적합할 경우에만)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        String [] input;
        int [] sort;
        StringBuilder result = new StringBuilder();
        while (T--> 0){
            int N = Integer.parseInt(reader.readLine());
            sort = new int[N + 1];
            while (N-->0){
                input = reader.readLine().split(" ");
                int i = Integer.parseInt(input[0]);
                int j = Integer.parseInt(input[1]);
                sort[i] = sort[i] == 0 || sort[i] > j ? j : sort[i];
            }

            int count = 1;
            int min = sort[1];
            for (int i = 2; i < sort.length; i++) {
                if (sort[i] < min){
                    min = sort[i];
                    count++;
                }
                if (min == 1)
                    break;
            }

            result.append(count).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}
