package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        Arrays.sort(tower, (x,y) -> y[0] - x[0]);

        for (int i = 0; i < cnt; i++) {

        }

        reader.close();
    }
}
