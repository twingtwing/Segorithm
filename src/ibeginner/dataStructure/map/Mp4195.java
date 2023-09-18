package ibeginner.dataStructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Mp4195 {
    /**
     * [4195 친쿠 네트워크]
     * NETWORK -> GRAPH 로 생각
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringTokenizer tokens;
        StringBuilder result = new StringBuilder();
        while (N-->0){
            int F = Integer.parseInt(reader.readLine());
            HashMap<String, List<String>> map = new HashMap<>();
            while (F-- > 0){
                tokens = new StringTokenizer(reader.readLine());
                String one = tokens.nextToken();
                String two = tokens.nextToken();
                List<String> oneList = map.getOrDefault(one, new ArrayList<>());
                oneList.add(two);
                List<String> twoList = map.getOrDefault(two, new ArrayList<>());
                twoList.add(one);

                map.put(one, oneList);
                map.put(two, twoList);

                result.append(oneList.size() + twoList.size()).append("\n");
            }
        }

        System.out.println(result);
        reader.close();
    }
}