package plan1;

import java.io.*;

public class MathPrime04 {
    public static void main(String[] args) throws IOException {
        //6588 : 골드 바흐의 추측을 증명 (6 ≤ n,t ≤ 1000000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        boolean [] prime = new boolean[1000001];
        int n = Integer.parseInt(reader.readLine());

        for (int i = 3; i < 1000000; i+=2){ // 홀수로만 이루어졌기 때문
            prime[i] = true;
            for (int j = 3; j < i/2; j+=2){
                if (!prime[j]) continue;
                if (i % j == 0){
                    prime[i] = false;
                    break;
                }
            }
        }

        while(n != 0){
            findGoldbach(n, result, prime);
            n = Integer.parseInt(reader.readLine());
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void findGoldbach(int n, StringBuilder result, boolean [] prime) {
        int one = 0;
        for (int i = 3; i < n/2; i+=2){
            if (!prime[i] || !prime[n - i]) continue;
            one = i;
            break;
        }
        if (one == 0) result.append("Goldbach's conjecture is wrong.\n");
        else result.append(String.valueOf(n)).append(" = ").append(String.valueOf(one)).append(" + ").append(String.valueOf(n - one)).append("\n");
    }
}
