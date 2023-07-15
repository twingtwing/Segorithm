package beginner.plan01;

import java.io.*;
import java.util.StringTokenizer;

public class MathPrime01 {
    public static void main(String[] args) throws IOException {
        // 1929 : M이상 N이하의 소수를 모두 출력(1 ≤ M ≤ N ≤ 1,000,000)
        // 에라토스테네스의 체
        // 배열의 갯수를 알기 때문에 굳이 HashMap을 할 필요가 없음
        // 또한, 삽입 삭제가 없기 때문에 배열을 사용

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = reader.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int start = Math.max(Integer.parseInt(st.nextToken()),2);
        int end = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder(end - start + 1);
        boolean [] prime = new boolean [end + 1];

        numIntial(end,prime);
        findPrime(start, end,prime,result);

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static void numIntial(int end, boolean [] prime) {
        for (int i = 0; i <= end; i++) prime[i] = true;
    }

    private static void findPrime(int start, int end, boolean [] prime, StringBuilder result) {
        for (int key = 2; key <= end; key ++){
            if (!prime[key]) continue;
            if (start <= key) result.append(key).append("\n");
            for (int j = key * 2; j <= end; j+= key){
                if (!prime[j]) continue;
                prime[j] = false;
            }
        }
    }

}
