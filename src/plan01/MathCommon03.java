package plan01;

import java.io.*;
import java.util.StringTokenizer;

public class MathCommon03 {
    public static void main(String[] args) throws IOException {
        // 17087 : 현재 위치가 X일때, 1초 후에는 X + M, X - M 으로 이동할 수 있다.
        // N개의 지점 A들을 모두 이동할 수 있는 최댓값 M 을 구해보자. N(1 ≤ N ≤ 105), S(1 ≤ S ≤ 109), Ai(1 ≤ Ai ≤ 109)
        // 최대값 => 최대공약수 => 유클리드 호제법
        // 두 집합에서 약수를 구하는 게 아니므로 에라토네스의 체를 하지 않는다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer one = new StringTokenizer(reader.readLine());
        StringTokenizer two = new StringTokenizer(reader.readLine());

        int kid = Integer.parseInt(one.nextToken());
        int unnie = Integer.parseInt(one.nextToken());

        int pre = 0;
        int now = 0;
        while(kid -- > 0){
            now = Math.abs(unnie - Integer.parseInt(two.nextToken()));
            if (pre > 0) pre = findGCD(pre, now);
            else pre = now;
        }

        writer.write(String.valueOf(pre));

        writer.close();
        reader.close();
    }

    private static int findGCD(int one, int two) {
        if (two == 0) return one;
        return findGCD(two, one%two);
    }
}
