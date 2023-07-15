package beginner.plan01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MathCommon04 {
    public static void main(String[] args) throws IOException {
        //2981 : N개의 숫자 A들을 m으로 나누어서 나머지가 모두 같아지는 m을 모두 구해라 (2 ≤ N ≤ 100) (1 ≤ A ≤ 1,000,000,000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        int count = Integer.parseInt(reader.readLine());
        int pre = Integer.parseInt(reader.readLine());
        int now;
        int gcd = 0;

        while(--count > 0){
            now = Integer.parseInt(reader.readLine());
            gcd = findGCD(Math.abs(now - pre),gcd);
            pre = now;
        }

        list.add(gcd);
        for (int i = 2; i <= Math.sqrt(gcd); i++){
            if (gcd % i == 0) {
                list.add(i);
                if (i != Math.sqrt(gcd)) list.add(gcd/i);
            }
        }
        Collections.sort(list);

        for (int i : list){
            result.append(String.valueOf(i)).append(" ");
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static int findGCD(int one, int two) {
        if (two == 0) return one;
        return findGCD(two, one%two);
    }


}
