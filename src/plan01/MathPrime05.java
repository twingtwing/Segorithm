package plan01;

import java.io.*;

public class MathPrime05 {
    public static void main(String[] args) throws IOException {
        //11653 : 1을 제외한 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력 (1 ≤ N ≤ 10,000,000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int num = Integer.parseInt(reader.readLine());

        primeFactor(num, 2, result);

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static void primeFactor(int num, int div, StringBuilder result) {
        if (num == 1) return;
        if (num % div == 0){
            result.append(div).append("\n");
            if (num == div) return;
            num /= div;
        }else{
            div ++;
            if (div % 2 == 0) div++;
        }
        primeFactor(num, div, result);
    }
}
