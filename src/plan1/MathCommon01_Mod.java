package plan1;

import java.io.*;
import java.util.StringTokenizer;

public class MathCommon01_Mod {
    public static void main(String[] args) throws IOException {
        //2609 : 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력
        // 최대 공약수를 구하는 가장 빠른 방법 : 유클리드 호제법(Euclidean algorithm)
        // 최소 공배수를 구하는 가장 빠른 방법 : a * b / 최대 공약수

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        StringBuilder result = new StringBuilder();

        int one = Integer.parseInt(str.nextToken());
        int two = Integer.parseInt(str.nextToken());

        int gcd = gcd(one,two);

        result.append(gcd).append("\n").append(one * two / gcd);

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static int gcd(int one, int two) {
        if (two == 0) return one;
        return gcd(two, one%two);
    }
}
