package plan02;

import java.io.*;

public class DSstack02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 9012 : 올바른 괄호 문자열인지 확인 알고리즘
        // 아스키 기호: ( 40, ) 41

//        StringBuilder result = new StringBuilder();
//        int count = Integer.parseInt(reader.readLine());
//        char [] stack;
//        int sum;
//        int top;
//        String out;ㅅ
//
//        while (count-- > 0) {
//            stack = reader.readLine().toCharArray();
//            sum = 0;
//            top = stack.length;
//            out = "NO";
//            if (stack[0] != 41 && stack[top-1] != 40) { //바로 끝낼 수 있는 경우는 바로 끝내기
//                while (--top >= 0) {
//                    sum += stack[top] == 40 ? 1 : -1;
//                    if (sum > 0) break;
//                }
//                out = sum == 0 ? "YES" : "NO";
//            }
//            result.append(out).append("\n");
//        }
//
//        writer.write(result.toString());

        //10773 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
        //이후 K개의 줄에 정수 N가 1개씩 주어진다. (1 ≤ N ≤ 1,000,000)
        //정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
        //정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
//        int count = Integer.parseInt(reader.readLine());
//        int[] stack = new int[count];
//        long sum = 0;
//        int top = -1;
//        int in;
//
//        while (count-- > 0) {
//            in = Integer.parseInt(reader.readLine());
//            if (in > 0) {
//                sum += in;
//                stack[++top] = in;
//            }
//            else sum -= stack[top--];
//        }
//
//        writer.write(String.valueOf(sum));

        // 1935 : 후위 표기식 =>  후입선출이기 때문에 Stack으로 구현가능
        // 대문자 A~Z 아스키 코드 : 65 ~ 90
        int [] ints = new int[Integer.parseInt(reader.readLine())];
        char [] chars = reader.readLine().toCharArray();
        double [] stack = new double[100];
        int top = -1;

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }

        for (char c : chars){
            if (c >= 65  && c <= 90) stack[++top] = ints[c-65];
            else {
                switch (c){
                    case 43 : stack[top-1] = stack[top-1] + stack[top];
                        break;
                    case 45 : stack[top-1] = stack[top-1] - stack[top];
                        break;
                    case 47 : stack[top-1] = stack[top-1] / stack[top];
                        break;
                    case 42 : stack[top-1] = stack[top-1] * stack[top];
                        break;
                }
                top--;
            }
        }

        writer.write(String.format("%.2f",stack[0]));

        writer.close();
        reader.close();
    }

}
