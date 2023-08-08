package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class St14719 {
    /*
    * [14719 빗물]
     * 자기 자신과 값 비교
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        tokens.nextToken();

        int idx = 0;
        int sum = 0;
        int [] water = new int[Integer.parseInt(tokens.nextToken())];
        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < water.length; i++) {
            water[i] = Integer.parseInt(tokens.nextToken());
            if (water[idx] < water[i])
                idx = i;
        }

        int m = 0;
        for (int i = 0; i < idx; i++) {
            if (water[m] < water[i])
                m = i;
            else
                sum += (water[m] - water[i]);
        }

        m = water.length - 1;
        for (int i = water.length - 1; i > idx; i--) {
            if (water[m] < water[i])
                m = i;
            else
                sum += (water[m] - water[i]);
        }

        System.out.print(sum);
        reader.close();
    }
}
