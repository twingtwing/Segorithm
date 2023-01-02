package plan1;

import java.io.*;

public class MathPrime02_Ary {
    public static void main(String[] args) throws IOException {

        //4948 : 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수 (1 ≤ n ≤ 123,456)
        // n의 갯수를 정하였기 때문에 배열로 가능함 이때의 배열 값에는 소수의 갯수를 저장함
        // 소수의 갯수를 저장한 index는 나중에 다시 안하도록 저장
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        boolean [] prime = new boolean[123456*2 + 1];
        int [] count = new int[123456*2];
        int size = 0;
        int in = 0;

        while((in = Integer.parseInt(reader.readLine())) != 0){
            result.append(count[in]).append("\n");
        }

        writer.write(result.toString());

        writer.close();
        reader.close();
    }


}
