package plan10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ip1244 {
    /**
     * [1244 스위치 켜고 끄기]
     * <br>
     * 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서<br>
     * 가장 많은 스위치를 포함하는 구간을 찾아서,<br>
     * 그 구간에 속한 스위치의 상태를 모두 바꾼다.<br><br>
     * 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.<br>
     * 즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.<br>
     *  이때 구간에 속한 스위치 개수는 항상 홀수가 된다.<br>
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] switchs = new int [Integer.parseInt(reader.readLine()) + 1];
        StringTokenizer tokens = new StringTokenizer(reader.readLine());

        for (int i = 1; i < switchs.length; i++)
            switchs[i] = Integer.parseInt(tokens.nextToken());

        int K = Integer.parseInt(reader.readLine());
        while (K-- > 0){
            tokens = new StringTokenizer(reader.readLine());
            int g = Integer.parseInt(tokens.nextToken());
            int idx = Integer.parseInt(tokens.nextToken());
            if (g > 1){
                int s = idx;
                int e = idx;
                while (s > 0 && e < switchs.length){
                    if (switchs[s] != switchs[e])
                        break;
                    switchs[s] = 1 - switchs[s];
                    switchs[e++] = switchs[s--];
                }
            }else{
                int cnt = 1; // 배수를 +로 구하면 배수가 아니라 제곱형태로 나옴
                while (idx*cnt < switchs.length){
                    switchs[idx*cnt] = 1 - switchs[idx*cnt];
                    cnt++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < switchs.length; i++){
            if ( i % 20 == 0)
                result.append(switchs[i]).append("\n");
            else
                result.append(switchs[i]).append(" ");
        }

        System.out.println(result);
        reader.close();
    }
}
