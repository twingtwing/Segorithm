package plan02;

import java.io.*;

public class DSstack04 {
    public static void main(String[] args) throws IOException {
        // 1874 : Stack에서 push시에 오름차순으로 자동 정렬됨
        // 임의의 수열이 주어졌을때, 스택을 이용해 해당 수열을 만들 수 확인
        // 만약 된다면, push,pop을  어떤 순서로 연산 수행해야하는지 출력
        // 모르겠다 포기!!!
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        int count = Integer.parseInt(reader.readLine());
        int in;

        writer.write(result.toString());

        writer.close();
        reader.close();
    }


}
