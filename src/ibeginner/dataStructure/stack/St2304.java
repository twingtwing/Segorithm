package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class St2304 {
    /**
     * [2304 창고 다각형]
     * 자기 자신과 값 비교
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        int [][] tower = new int[cnt][2];

        StringTokenizer tn;
        while (cnt-- > 0){
            tn = new StringTokenizer(reader.readLine());
            tower[cnt][0] = Integer.parseInt(tn.nextToken());
            tower[cnt][1] = Integer.parseInt(tn.nextToken());
        }

        // X축 정렬
        Arrays.sort(tower, Comparator.comparingInt(x -> x[0]));

        int idx = 0;
        int sum = 0;
        for (int i = 1; i < tower.length; i++) {
            if (tower[i][1] < tower[idx][1]) continue;
            sum += (tower[i][0] - tower[idx][0]) * tower[idx][1];
            idx = i;
        }

        sum += tower[idx][1];
        if (idx < tower.length - 1){
            int h = tower.length - 1;
            int top = tower.length - 1;
            while (top-- > idx){
                if (tower[h][1] > tower[top][1]) continue;
                sum += (tower[h][0] - tower[top][0]) * tower[h][1];
                h = top;
            }
        }

        System.out.print(sum);
        reader.close();
    }
}
