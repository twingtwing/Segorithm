package plan04;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Dy2225 {
    /**
     * [2225  합분해]
     * <br>
     * 덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). <br>
     * 또한 한 개의 수를 여러 번 쓸 수도 있다. <br>
     * N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200) <br>
     * 첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력 <br>
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer tokens = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());



        sc.close();
    }
}
