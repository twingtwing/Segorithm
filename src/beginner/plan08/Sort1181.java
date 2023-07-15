package beginner.plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort1181 {
    /**
     * [1181 단어 정렬]
     * <br>
     * 삽입정렬
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String [] sort = new String[N];

        for (int i = 0; i < N; i++)
            sort[i] = reader.readLine();

        int j;
        String val;
        for (int i = 1; i < N; i++){
            val = sort[i];
            j = i - 1;

            // 지정한 값보다 큰 원소들은 오른쪽으로 한 칸 씩 이동
            while (j >= 0 && compareString(sort[j] , val)){
                sort[j + 1] = sort[j];
                j -- ;
            }

            // 지정한 위치에 삽입
            sort[j + 1] = val;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sort[0]).append("\n");
        for (int i = 1; i < sort.length; i++){
            if (sort[i-1].equals(sort[i])) continue;
            sb.append(sort[i]).append("\n");
        }

        System.out.println(sb);
        reader.close();
    }

    private static boolean compareString(String sort, String val){
        if (sort.length() != val.length())
            return sort.length() > val.length();
        else
            return sort.compareTo(val) > 0;
    }
}
