package ibeginner.dataStructure.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class St7785 {
    /**
     * [1525 회사에 있는 사람]
     * Set - 두 집합 비교 / 중복값 없음
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /**
         * HashSet은 정렬을 보장하지 않지만, TreeSet은 정렬을 보장함
         * */
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        while (N -- > 0){
            tokens = new StringTokenizer(reader.readLine());
            String name = tokens.nextToken();
            if (tokens.nextToken().equals("enter"))
                set.add(name);
            else
                set.remove(name);

        }

        StringBuilder result = new StringBuilder();
        for (String name : set)
            result.append(name).append("\n");

        System.out.println(result);
        reader.close();
    }
}
