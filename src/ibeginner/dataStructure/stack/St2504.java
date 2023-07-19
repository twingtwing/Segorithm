package ibeginner.dataStructure.stack;

import java.util.Scanner;

public class St2504 {
    /**
     * [2504 괄호의 값]
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] chars = sc.nextLine().toCharArray();
        Stack stack = new Stack(chars.length);

        int sum = 1;
        boolean flag = false;
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '['){
                if ((stack.isEmpty() && sum > 1) ||
                        (!stack.isEmpty() && (chars[i - 1] == ')' || chars[i - 1] == ']'))){
                    stack.push(sum);
                    sum = 1;
                }
                stack.push(chars[i]);
            }
            else if (chars[i] == ')' || chars[i] == ']'){
                int pop = stack.pop();
                int bob = ( chars[i] == ')' ? '(' : '[' ) * -1;
                if(pop == bob)
                    sum *= chars[i] == ')' ? 2 : 3;
                else if (pop > 0){
                    sum += pop;
                    i--;
                }
                else {
                    flag = true;
                    break;
                }
            }
        }

        if (flag)
            System.out.println(0);
        else{
            while (!stack.isEmpty()){
                int pop = stack.pop();
                if (pop > 0)
                    sum += pop;
                else{
                    sum = 0;
                    break;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}

class Stack{
    int top;
    int [] stack;

    Stack(int len) {
        this.top = -1;
        this.stack = new int[len*2];
    }

    int size(){
        return this.top + 1;
    }

    boolean isEmpty(){
        return this.top == -1;
    }

    boolean isFull(){
        return this.size() == this.stack.length;
    }

    void push(int data) {
        if (isFull()) throw new IllegalStateException("Stack is Full");
        this.stack[++this.top] = data;
    }

    void push(char data) {
        if (isFull()) throw new IllegalStateException("Stack is Full");
        this.stack[++this.top] = data * -1;
    }

    int pop(){
        if (isEmpty()) return 0;
        return this.stack[this.top--];
    }

}
