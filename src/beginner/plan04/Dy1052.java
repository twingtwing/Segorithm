package beginner.plan04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Dy1052 {
    /**
     * [1052 물병]
     * <br>
     * 규칙 : 2로 나누었을때 나머지가 1이면 물병이 1개가 더 생긴다.
     * */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringTokenizer tok = new StringTokenizer(input.nextLine());
        int water = Integer.parseInt(tok.nextToken());
        int bottle = Integer.parseInt(tok.nextToken());

        int result = 0;

        if (water > bottle){
            while (true){
                // Integer.bitCount : 이진수 일때 1의 갯수를 반환 = (/2 %2 == 1) 갯수
                if (Integer.bitCount(water) <= bottle) // 추가된 물병이 필요한 최소한의 물병 개수를 충족
                    break;
                result+= water % 2 == 1 ? 1 : 2;
                water+= water % 2 == 1 ? 1 : 2; // 물병 추가
            }
        }

        System.out.println(result);

        input.close();
    }
}
