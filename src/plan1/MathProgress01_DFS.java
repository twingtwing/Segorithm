package plan1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MathProgress01_DFS {

    public static void main(String[] args) throws IOException {
        // 15649 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열 (1 ≤ M ≤ N ≤ 8)
        // DFS : 깊이 탐색 검색은 모든 경우를 구할 때 매우 용이하다.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        int row = Integer.parseInt(str.nextToken());
        int col = Integer.parseInt(str.nextToken());

        StringBuilder result = new StringBuilder(row*(row-1)*col);
        char [] chars = new char[col*2 - 1];
        boolean [] storage = new boolean[row + 1];

        Arrays.fill(chars,' ');

        progressDFS(col-1, storage, chars, result);

        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void progressDFS(int col, boolean [] storage,char [] chars ,StringBuilder result) {
        if (col == -1) {
            result.append(chars).append("\n");
            return;
        }
        for (int i = 1; i < storage.length; i++){
            if (storage[i]) continue;
            storage[i] = true;
            chars[chars.length - col*2 - 1] = (char) (i+'0'); // 아스키 코드에 '0'을 더해줘야지 숫자 그대로 변환됨
            progressDFS(col - 1,storage,chars,result); // col--를 하면 실제로 col에 영향을 가기 때문에 col - 1을 해준다.
            storage[i] = false;
        }
    }

}