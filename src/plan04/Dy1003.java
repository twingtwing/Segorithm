package plan04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dy1003 {
    /**
     * [1003 피보나치 함수]
     * <br>
     * fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램 <br><br>
     * !!KeyPoint!!<br>
     * 피보나치 수열은 처음에 한번만 생성하면 된다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int n;
        int [] fibonacci = new int[41];
        int cnt = Integer.parseInt(reader.readLine());

        madeFibonacci(fibonacci, 40);

        while(cnt -- > 0){
            n = Integer.parseInt(reader.readLine());
            if (n == 0)
                result.append("1 0").append("\n");
            else if(n == 1)
                result.append("0 1").append("\n");
            else
                result.append(fibonacci[n-1]).append(" ").append(fibonacci[n]).append("\n");
        }

        System.out.println(result);
        reader.close();
    }

    private static void madeFibonacci(int[] fibonacci, int cnt) {
        if (cnt < 2) {
            fibonacci[cnt] = cnt;
            return;
        }
        madeFibonacci(fibonacci, cnt - 1);
        fibonacci[cnt] = fibonacci[cnt-1] + fibonacci[cnt-2];
    }


}
