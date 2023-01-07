package plan1;

import java.io.*;

public class MathPrime06 {
    static boolean [] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        //17103 : 골드바흐 파티션 출력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        // 1.소수 찾기
        madePrime();

        // 2. 파티션 찾기
        while (count -- > 0){
            result.append(countGold(Integer.parseInt(reader.readLine()))).append("\n");
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void madePrime() {
        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) continue;
            for (int j = i * 2; j < prime.length; j += i) prime[j] = true;
        }
    }

    private static int countGold(int num) {
        int count = 0;
        for (int i = 2; i <= num/2; i++){
            if(prime[i] || prime[num-i]) continue;
            count ++;
        }
        return count;
    }
}
