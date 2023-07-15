package beginner.plan01;

import java.io.*;

public class MathPrime03 {
    static boolean [] prime = new boolean[10001];
    static int max = 2;
    public static void main(String[] args) throws IOException {
        //9020 : 골드 바흐의 추측 -> 골드바흐 파티션 출력 (4 ≤ n ≤ 10,000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        int in;

        while(t-- > 0){
            in = Integer.parseInt(reader.readLine());
            findPartition(in, result);
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void findPartition(int in, StringBuilder result) {
        if (in > max) madePrime(in);
        int one = 0;
        for (int i = 2; i <= in/2; i++){
            if (!prime[i] || !prime[in - i]) continue;
            one = i;
        }
        result.append(String.valueOf(one)).append(" ").append(String.valueOf(in - one)).append("\n");
    }

    // 해당 방법은 에라코네스 체가 아님!!
    // 나머지를 구하는게 아니라 배수를 구해서 체로 걸러내야함
    private static void madePrime(int in) {
        for (int i = max; i <= in; i++){
            prime[i] = true;
            for (int j = 2; j <= i/2; j++){
                if (!prime[j]) continue;
                if (i % j == 0){
                    prime[i] = false;
                    break;
                }
            }
        }
        max = in;
    }
}
