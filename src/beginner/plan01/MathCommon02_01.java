package beginner.plan01;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class MathCommon02_01 {
    static int [] first = new int[1000];
    static int [] second = new int[1000];
    static boolean [] prime = new boolean[1000000001];
    static int one;
    static int two;
    public static void main(String[] args) throws IOException {
        //2824 : N, M개의 곲한 수의 최대 공약수를 구해라 (1 ≤ N,M ≤ 1000)
        // 경우1. 유클리드 호제법

        // !! key point !! : 숫자의 오버플로우를 해결해야한다.
        // 즉, 먼저 곱하지 말고 최대 공약수를 구한 후에 진행한다.
        // 먼저 곱함으로써 발생하는 오버플로우를 막을 수 있다.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder(9);

        one = Integer.parseInt(reader.readLine());
        StringTokenizer str = new StringTokenizer(reader.readLine());
        for (int i = 0; i < one; i++)  {
            first[i] = Integer.parseInt(str.nextToken());
        }

        two = Integer.parseInt(reader.readLine());
        str = new StringTokenizer(reader.readLine());
        for (int i = 0; i < two; i++) {
            second[i] = Integer.parseInt(str.nextToken());
        }

        String re = String.valueOf(findEUC());


        result.append(re);

        if (re.length() > 9) result.delete(0, re.length() - 9);

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    // 1. 유클리드 호제법
    // 배열들은 각각의 약수나 마찬가지이다. 약수들간의 최대 공약수를 구한다.
    // 두 약수 배열들의 최대 공약수를 구할 경우, 곱한 후에 하면 오버플로우가 걸릴 수 있다.
    // 두개의 약수 배열들간에 교차로 최대공약수를 구해서 곱하면 된다.
    // 이때, 최대 공약수가 중복 발생 할 경우를 방지하기 위해 최대공약수를 구하면 해당 약수에 최대 공약수를 나누면서 진행해야한다.
    // 시간 복잡도 O(n^2) 이기 때문에 오래 걸린다.
    private static BigDecimal findEUC() {
        BigDecimal result = new BigDecimal(1);
        int tmp;
        for (int i = 0; i < one; i++){
            for (int j = 0; j < two; j++){
                tmp = findEucGCD(first[i],second[j]);
                result = result.multiply(BigDecimal.valueOf(tmp));
                first[i] /= tmp;
                second[j] /= tmp;
            }
        }
        return result;
    }

    private static int findEucGCD(int one, int two) {
        if (two == 0) return one;
        return findEucGCD(two, one%two);
    }

}