package plan1;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Math01 {
    public static void main(String[] args) throws IOException {
        //8393 : n이 주어졌을 때, 1부터 n까지 합 (1 ≤ n ≤ 10,000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int count = Integer.parseInt(reader.readLine());
//        int sum = 0;
//
//        if(count % 2 == 0) sum = count * (count + 1) / 2;
//        else sum = count * (count - 1) / 2 + count;
//
//        writer.write(String.valueOf(sum));
//
//        writer.close();
//        reader.close();

        //1978 : 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력 (N갯수 100이하, N <= 1000)
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        boolean flag = false;
//        int num = 0;
//        int count = 0;
//        int in = Integer.parseInt(reader.readLine());
//        StringTokenizer str = new StringTokenizer(reader.readLine());
//
//        while(in-- > 0){
//            flag = false;
//            num = Integer.parseInt(str.nextToken());
//            if (num <= 1) continue;
//            for (int i = 2; i <= num/i; i++){
//                if (num % i == 0) {
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag) count++;
//        }
//
//        writer.write(String.valueOf(count));
//
//        writer.close();
//        reader.close();

        //2407 : nCm을 출력 (5 ≤ n ≤ 100, 5 ≤ m ≤ 100, m ≤ n)
        // nCm : n개의 숫자를 6가지 조헙 할 수 있는 경우의 수
//        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer str = new StringTokenizer(reader.readLine());
//        int n = Integer.parseInt(str.nextToken());
//        int m = Integer.parseInt(str.nextToken());
//
//        BigDecimal p = new BigDecimal(1);
//        BigDecimal f = new BigDecimal(1);
//
//        for (int i = 0; i < m; i++) {
//            p = p.multiply(BigDecimal.valueOf(n-i));
//            f = f.multiply(BigDecimal.valueOf(m-i));
//        }
//
//        BigDecimal result = p.divide(f, RoundingMode.HALF_DOWN);
//
//        writer.write(String.valueOf(result));

        writer.close();
        reader.close();

    }
}
