package plan1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MathCommon01 {
    public static void main(String[] args) throws IOException {
        //2609 : 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        StringBuilder result = new StringBuilder();

        int one = Integer.parseInt(str.nextToken());
        int two = Integer.parseInt(str.nextToken());

        // 약수 list 생성
        HashMap<Integer,Integer> oneList = new HashMap<>();
        HashMap<Integer,Integer> twoList = new HashMap<>();

        getOddNum(one,2,  oneList);
        getOddNum(two, 2, twoList);

        // 최대 공약수 최소 공배수
        if (one % two == 0) result.append(two).append("\n").append(one);
        else if(two % one == 0) result.append(one).append("\n").append(two);
        else result.append(getDivNum(oneList,twoList)).append("\n").append(getMultiNum(oneList, twoList));

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    // 최대 공약수
    private static int getDivNum(HashMap<Integer, Integer> oneList, HashMap<Integer, Integer> twoList) {
        int div = 1;
        for (Map.Entry<Integer,Integer> entry : twoList.entrySet()){
            int key = entry.getKey();
            if (!oneList.containsKey(key)) continue;
            div = (int) (div * Math.pow(key,Math.min(entry.getValue(), oneList.getOrDefault(key,1))));
        }
        return div;
    }

    //최소 공배수
    private static int getMultiNum(HashMap<Integer, Integer> oneList, HashMap<Integer, Integer> twoList) {
        int multi = 1;
        for (Map.Entry<Integer,Integer> entry : oneList.entrySet()){
            int key = entry.getKey();
            multi = (int) (multi * Math.pow(key,Math.max(entry.getValue(), twoList.getOrDefault(key,1))));
        }
        for (Map.Entry<Integer,Integer> entry : twoList.entrySet()){
            int key = entry.getKey();
            if (oneList.containsKey(key)) continue;
            multi = (int) (multi * Math.pow(key,entry.getValue()));
        }
        return multi;
    }

    private static void getOddNum(int num, int div, HashMap<Integer, Integer> hashMap) {
        if (num == 1) return; // 1의 경우를 고려
        if (num % div == 0) {
            hashMap.put(div, hashMap.getOrDefault(div, 0) + 1);
            if (num == div) return;
            num /= div;
        }
        else {
            div++;
            if (div % 2 == 0) div++;
        }
        getOddNum(num,div,hashMap);
    }

}
