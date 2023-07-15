package beginner.plan01;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MathCommon02_02 {
    static HashMap<Integer,Integer> first = new HashMap<>();
    static HashMap<Integer,Integer> second = new HashMap<>();
    static boolean [] prime = new boolean[(int) Math.sqrt(1000000000) + 1];
//    static boolean [] prime = new boolean[40001];
    static int one;
    static int two;
    public static void main(String[] args) throws IOException {
        //2824 : N, M개의 곲한 수의 최대 공약수를 구해라 (1 ≤ N,M ≤ 1000)
        // 경우2. 에라토네스의 채

        // !! key point !! : 숫자의 오버플로우를 해결해야한다.
        // 즉, 먼저 곱하지 말고 최대 공약수를 구한 후에 진행한다.
        // 먼저 곱함으로써 발생하는 오버플로우를 막을 수 있다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder(9);

        // 1. 소수 구하기
        madePrimeMea();

        // 2. 소인수 분해
        // map을 사용하여 각 수의 소인수 분해 값을 저장한다.
        one = Integer.parseInt(reader.readLine());
        StringTokenizer str = new StringTokenizer(reader.readLine());
        for (int i = 0; i < one; i++)  {
            findMeaNum(first,Integer.parseInt(str.nextToken()));
        }

        two = Integer.parseInt(reader.readLine());
        str = new StringTokenizer(reader.readLine());
        for (int i = 0; i < two; i++) {
            findMeaNum(second,Integer.parseInt(str.nextToken()));
        }

        //3. 겹치는 소인수 분해 값을 곱해준다.
        BigDecimal output = findERA();

        //4. 원하는 형식대로 출력한다.
        // 9자리 이므로 8자리에서 최대값으로 비교해준다.
        if (output.compareTo(BigDecimal.valueOf(Math.pow(10,9)-1)) > 0)
            result.append(output.setScale(0, RoundingMode.HALF_EVEN)).delete(0, result.length() - 9);
        else
            result.append(output.setScale(0, RoundingMode.HALF_EVEN));

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static BigDecimal findERA() {
        int key;
        BigDecimal multi = new BigDecimal(1);
        for (Map.Entry<Integer,Integer> entry : first.entrySet()){
            key = entry.getKey();
            if (!second.containsKey(key)) continue;
            multi = multi.multiply(BigDecimal.valueOf(Math.pow(key, Math.min(entry.getValue(), second.get(key)))));
        }
        return multi;
    }

    // keyPoint : n에서 √n까지의 소수를 모두 나누면 1 혹은 최대 소수가 남는것인가?
    private static void findMeaNum(HashMap<Integer, Integer> map, int num) {
        for (int i = 2; i * i <= num; i++){
            if (num == 1) break;
            if (prime[i]) continue;
            if (num % i == 0){
                map.put(i, map.getOrDefault(i, 0) + 1);
                num /= i--;
            }
        }
        if (num != 1) map.put(num, map.getOrDefault(num, 0) + 1);
    }

    private static void madePrimeMea() {
        int len = prime.length;
        for (int i = 2; i*i <= len-1; i++){
            if (prime[i]) continue;// false : 소수
            for (int j = i * 2; j < len; j += i) prime[j] = true;
        }
    }

}
