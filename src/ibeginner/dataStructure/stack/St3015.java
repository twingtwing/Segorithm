package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class St3015 {
    /**
     * [3015 오아시스 재결합]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] nums = new int[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(reader.readLine());

        long sum = 0;
        Storage stack = new Storage(nums.length);
        stack.push(nums[stack.length() - 1]);

        for (int i = stack.length() - 2; i >= 0; i--) {
            sum += stack.size();

            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            stack.push(nums[i]);
        }

        System.out.print(sum);
        reader.close();
    }
}

class Storage{
    private int top;
    private int [] stack;

    Storage(int len){
        this.top = -1;
        this.stack = new int[len];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int length(){
        return stack.length;
    }

    public int size(){
        return top + 1;
    }

    public void push(int data){
        stack[++top] = data;
    }

    public int pop(){
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

}
