package plan1;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MathCommon02 {
    public static void main(String[] args) throws IOException {
        //2824 : N, M개의 곲한 수의 최대 공약수를 구해라 (1 ≤ N,M ≤ 1000)
        // 유클리드 호제법으로는 시간 ↑
        // 소수를 통해 약수를 구해서 최대 공약수를 구함
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder result = new StringBuilder(9);
        HashMap<Integer,Integer> one = new HashMap<>();
        HashMap<Integer,Integer> two = new HashMap<>();
        int oneC = Integer.parseInt(reader.readLine());
        StringTokenizer a = new StringTokenizer(reader.readLine());

        int twoC = Integer.parseInt(reader.readLine());
        StringTokenizer b = new StringTokenizer(reader.readLine());

        while(!(oneC -- < 0 || twoC-- < 0)) {
            if (oneC >= 0) {
                if (one.isEmpty())findMea(2, Integer.parseInt(a.nextToken()), one);
                else countMea(oneC,one);
            }
            if (twoC >= 0){
                if (two.isEmpty())findMea(2, Integer.parseInt(b.nextToken()), two);
                else countMea(twoC,two);
            }
        }

        String r = String.valueOf(findGOD(one, two));
        result.append(r);
        if (r.length() > 9) result.delete(0,r.length() - 9);
        writer.write(result.toString());

        writer.close();
        reader.close();

    }

    private static void countMea(int num, HashMap<Integer, Integer> hashMap) {
        int key;
        int value;
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if ((value = entry.getValue()) == 0) continue;
            if (num % (key = entry.getKey()) != 0) {
                hashMap.put(key, 0);
                continue;
            }
            while (num % key == 0 && ++ count < value) num /= key;
            hashMap.put(key, count);
        }
    }

    private static void findMea(int div, int num, HashMap<Integer, Integer> hashMap) {
        if (num % div == 0){
            hashMap.put(div, hashMap.getOrDefault(div,0) + 1);
            if (num == div) return;
            num /= div;
        }else{
            div++;
            if (div % 2 == 0) div++;
        }
        findMea(div,num,hashMap);
    }

    private static BigDecimal findGOD(HashMap<Integer, Integer> one, HashMap<Integer, Integer> two) {
        BigDecimal result = new BigDecimal(1);
        int key;
        int value;
        for (Map.Entry<Integer,Integer> entry : one.entrySet()){
            key = entry.getKey();  \]
            result = result.multiply(BigDecimal.valueOf(Math.pow(key,Math.min(entry.getValue(),two.get(key)))));
        }
        return result;
    }
}