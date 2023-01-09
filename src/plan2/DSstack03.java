package plan2;

import java.io.*;
import java.util.StringTokenizer;

public class DSstack03 {
    static char [] stack = new char[600000];
    static int top;
    static int cursor;
    public static void main(String[] args) throws IOException {
        //1406 : 소문자만을 기록할 수 있는 편집기 + 커서 존재
        // 커서 => 후입선출 Stack을 이용한다.
        // 중간 삭제가 있기 때문에 연결 자료구조 이용
        // 소문자 아스키 기호 97 ~ 122
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        top = 0;
        for (char c : reader.readLine().toCharArray()){
            stack[top++] = c;
        }

        cursor = top;
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer str;
        while(count-- > 0){
            str = new StringTokenizer(reader.readLine());
            switch (str.nextToken()){
                case "L" : ;
                    break;
                case "D" : ;
                    break;
                case "B" : ;
                    break;
                case "P":
                    break;
            }
        }

        writer.close();
        reader.close();

    }


}
