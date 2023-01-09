package plan1;

import java.io.*;

public class MathPrime02_Ary {
    static boolean [] prime = new boolean[123456*2 + 1];
    static int [] count = new int[123456*2 +1];
    public static void main(String[] args) throws IOException {
        //4948 : 베르트랑 공준 => 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다
        // 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수 (1 ≤ n ≤ 123,456)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int in;

        madePrime();

        while((in = Integer.parseInt(reader.readLine())) != 0){
            result.append(count[in*2] - count[in]).append("\n");
        }

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static void madePrime() {
        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) continue;
            for (int j = i*2; j < prime.length; j+=i) {
                prime[j] = true;
            }
        }
        countPrime();
    }

    private static void countPrime() {
        for (int i = 2; i< count.length; i++) {
            count[i] = count[i-1];
            if (!prime[i]) count[i]++;
        }
    }


}
