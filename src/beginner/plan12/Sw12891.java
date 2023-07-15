package beginner.plan12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw12891 {
    /**
     * [12891 DNA 비밀번호]
     * <br>
     * 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙<br>
     * 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다<br>
     * {‘A’, ‘C’, ‘G’, ‘T’} 이외의 문자는 주어지지 않는다고 지문에서 은유적으로 업급됨!!
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int S = Integer.parseInt(tokens.nextToken());
        int P = Integer.parseInt(tokens.nextToken());

        int [] rule = new int[4];
        int [] window = new int[4];
        String [] str = reader.readLine().split("");

        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 4; i++)
            rule[i] = Integer.parseInt(tokens.nextToken());

        int count = 1;
        for (int i = 0; i < P; i++) {
            switch (str[i]){
                case "A" :
                    window[0]++;
                    break;
                case "C" :
                    window[1]++;
                    break;
                case "G" :
                    window[2]++;
                    break;
                case "T" :
                    window[3]++;
                    break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (rule[i] > window[i]){
                count--;
                break;
            }
        }

        for (int i = 0; i < str.length - P; i++) {
            switch (str[i]){
                case "A" :
                    window[0]--;
                    break;
                case "C" :
                    window[1]--;
                    break;
                case "G" :
                    window[2]--;
                    break;
                case "T" :
                    window[3]--;
                    break;
            }
            switch (str[i + P]){
                case "A" :
                    window[0]++;
                    break;
                case "C" :
                    window[1]++;
                    break;
                case "G" :
                    window[2]++;
                    break;
                case "T" :
                    window[3]++;
                    break;
            }

            count++;
            for (int j = 0; j < 4; j++) {
                if (rule[j] > window[j]){
                    count--;
                    break;
                }
            }
        }


        System.out.println(count);
        reader.close();
    }
}
