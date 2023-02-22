package plan02;

import java.util.Scanner;

public class DSstack09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char [] notation = scanner.next().toCharArray();
        char [] stack = new char[notation.length * 2];
        int top = -1;

        // 1.이중 loop를 돌지않고
        // 2 한번의 loop로 끝내는 방법

        for (int i = 0; i < notation.length; i++){
            if (notation[i] > 64 && notation[i] < 91) System.out.print(notation[i]);// 대문자
            else{
                if (notation[i] == 43 || notation[i] == 45 || notation[i] == 41){ // + - )
                    while (top > -1) { // no empty
                        if (stack[top] == 40) break; // no (
                        System.out.print(stack[top--]);
                    }
                    if(notation[i] == 41) {
                        top--;
                        continue;
                    }
                }
                else if (notation[i] == 42 || notation[i] == 47){ // * /
                    if (top != -1 && (stack[top] == 42 || stack[top] == 47)) System.out.print(stack[top--]); // * /
                }
                stack[++top] = notation[i];
            }
        }

        while (top > -1) {
            if (stack[top] == 40) { // no (
                top--;
                continue;
            }
            System.out.print(stack[top--]);
        }

        scanner.close();
    }
}
