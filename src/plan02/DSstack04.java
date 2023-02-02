package plan02;

import java.io.*;

public class DSstack04 {
    static StringBuilder result = new StringBuilder();
    static int [] stack = new int[100000];
    static int top = -1;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        // 1874 : Stack에서 push시에 오름차순으로 자동 정렬됨
        // 임의의 수열이 주어졌을때, 스택을 이용해 해당 수열을 만들 수 확인
        // 만약 된다면, push,pop을  어떤 순서로 연산 수행해야하는지 출력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int in;
        int count = Integer.parseInt(reader.readLine());
        
        while(count-- >0){
            in = Integer.parseInt(reader.readLine());
            if (in > max) pushStack(in);
            else if(isEmptyS() || stack[top] != in){
                result.setLength(0);
                result.append("NO");
                break;
            }
            else {
                result.append("-\n");
                top--;
            }
        }

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static void pushStack(int in) {
        for (int i = max + 1; i < in ; i++) {
            stack[++top] = i;
            result.append("+\n");
        }
        result.append("+\n-\n");
        max = in;
    }

    private static boolean isEmptyS() {
        return top == -1;
    }


}
