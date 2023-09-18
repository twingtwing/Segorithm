package ibeginner.dataStructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Mp1302 {
    /**
     * [1302 베스트셀러]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        while (N-->0){
            String str = reader.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int max = 0;
        String best = "";
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue() > max ||
                    (entry.getValue() == max && entry.getKey().compareTo(best) < 0)){
                max = entry.getValue();
                best = entry.getKey();
            }
        }

        System.out.println(best);
        reader.close();
    }
}
