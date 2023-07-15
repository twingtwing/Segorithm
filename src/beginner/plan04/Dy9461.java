package beginner.plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dy9461 {
    /**
     * [9461 파도반 수열]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        Long [] padoban = new Long[102];
        int cnt = Integer.parseInt(reader.readLine());
        padoban[1] = 1L;
        padoban[2] = 1L;
        padoban[3] = 1L;

        for (int i = 4; i < padoban.length; i++)
            padoban[i] = padoban[i-3] + padoban[i-2];
        
        while(cnt -- > 0)
            result.append(padoban[Integer.parseInt(reader.readLine())]).append("\n");

        System.out.println(result);
        reader.close();
    }


}
