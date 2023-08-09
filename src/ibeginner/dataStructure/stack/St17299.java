package ibeginner.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class St17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int [] seq = new int[N];
        int [] result = new int[N];
        Map<Integer,Integer> frequency = new HashMap<>();

        // 오른쪽을 오름차순으로 정렬하는게 아니라
        // 왼쪽을 내림차순으로 정렬해서 값이 바로 할당 할 수 있도록 작성
        int top = -1;
        int [] stack = new int[N];

        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(tokens.nextToken());
            frequency.put(seq[i],frequency.getOrDefault(seq[i],0) + 1);
        }

        for (int i = 0; i < N; i++) {
            while (top > -1 
                    && frequency.get(seq[stack[top]]) < frequency.get(seq[i])) // 내림차순으로 정렬된 인덱스를 차례로 비교
                result[stack[top--]] = seq[i]; // while구문에서 해당 인덱스의 값보다 작은 값은 현재 인덱스가 오등큰수이므로 값 교체

            stack[++top] = i; // while구문에서 해당 인덱스의 값보다 작은 값은 stack에서 삭제 되었으므로 재정렬 X
        }

        //  stack은 인덱스를 할당하지 못한 인덱스므로 -1
        while (top > -1)
            result[stack[top--]] = -1;

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < seq.length; i++)
            str.append(result[i]).append(" ");

        System.out.println(str);
        reader.close();
    }
}
