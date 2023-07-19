package ibeginner.dataStructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class St2504_1 {
    /**
     * [2504 괄호의 값]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        char [] chars = sc.nextLine().toCharArray();

        int sum = 0;
        int tmp = 1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ')'){
                if (stack.isEmpty() || stack.pop() != '('){
                    sum = 0;
                    break;
                }
                if (chars[i - 1] == '(')
                    sum += tmp;
                tmp /= 2;
            }
            else if(chars[i] == ']'){
                if (stack.isEmpty() || stack.pop() != '['){
                    sum = 0;
                    break;
                }
                if (chars[i - 1] == '[')
                    sum += tmp;
                tmp /= 3;
            }
            else if(chars[i] == '(' || chars[i] == '['){
                tmp *= chars[i] == '(' ? 2 : 3;
                stack.push(chars[i]);
            }
            else {
                sum = 0;
                break;
            }

        }

        if (!stack.isEmpty())
            sum = 0;

        System.out.println(sum);
        sc.close();
    }
}
