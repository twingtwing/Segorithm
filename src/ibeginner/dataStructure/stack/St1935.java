package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class St1935 {
    /**
     * [1935 후위표기법 2]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        char [] chars = reader.readLine().toCharArray();

        int [] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(reader.readLine());

        Stack<Double> sum = new Stack<>();
        for (int i =0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z')
                sum.push((double) nums[chars[i] - 'A']);
            else{
                double n = sum.pop();
                switch (chars[i]){
                    case '+' :
                        sum.push(sum.pop() + n);
                        break;
                    case '-' :
                        sum.push(sum.pop() - n);
                        break;
                    case '*' :
                        sum.push(sum.pop() * n);
                        break;
                    case '/' :
                        sum.push(sum.pop() / n);
                        break;
                }
            }
        }

        System.out.printf("%.2f",sum.peek());
        reader.close();
    }
}
