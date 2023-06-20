package plan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gp2252 {
    /**
     * [2252 줄 세우기]
     * <br>
     * 학생의 선후관계를 파악해야하므로 위상정렬 이용<br>
     * N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000)
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        // 정답보기 : 알고리즘에 대해 이해 필요 

        reader.close();
    }
}
