package ibeginner.dataStructure.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class St1764 {
    /**
     * [1764 듣보잡]
     * 여기서 SET은 중복체크용 혹은 존재 체크 용으로 생각하면 된다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken()) + Integer.parseInt(tokens.nextToken());

        int cnt = 0;
        Set<String> set = new TreeSet<>();
        Set<String> contains = new HashSet<>();
        while (N --> 0){
            String name = reader.readLine();
            if (contains.contains(name))
                set.add(name);
            else
                contains.add(name);
        }

        StringBuilder result = new StringBuilder();
        result.append(set.size()).append("\n");
        for(String name : set)
            result.append(name).append("\n");

        System.out.println(result);
        reader.close();
    }
}
