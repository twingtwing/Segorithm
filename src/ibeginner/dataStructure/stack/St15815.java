package ibeginner.dataStructure.stack;

import java.util.Scanner;

public class St15815 {
    /**
     * [15815 천재 수학자 성필]
     * 후위 표기법 계산
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        Stacks st = new Stacks(chars.length);
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '+' || chars[i] == '-' ||
                    chars[i] == '*' || chars[i] == '/')
                st.push(chars[i]);
            else
                st.push(chars[i] - '0');
        }

        System.out.println(st.pop());
        scanner.close();
    }
}

class Stacks {
    private int top;
    private int [] stack;
    Stacks(int len){
        this.top = -1;
        this.stack = new int[len];
    }

    public void push(int data){
        this.stack[++top] = data;
    }

    public void push(char data){
        int a = stack[top--];
        int b = stack[top--];

        switch (data){
            case '*' :
                this.stack[++top] = b * a;
                break;
            case '/' :
                this.stack[++top] = b / a;
                break;
            case '-' :
                this.stack[++top] = b - a;
                break;
            case '+' :
                this.stack[++top] = b + a;
                break;
        }
    }

    public int pop(){
        return this.stack[top--];
    }
}
