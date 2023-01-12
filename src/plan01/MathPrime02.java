package plan01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MathPrime02 {
    public static void main(String[] args) throws IOException {
        //4948 : 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수 (1 ≤ n ≤ 123,456)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> prime = new HashMap<>();
        StringBuilder result = new StringBuilder();
        int in = 0;
        
        while((in = Integer.parseInt(reader.readLine())) != 0){
            madePrime(in ,prime);
            result.append(String.valueOf(countPrime(in, prime))).append("\n");
        }
        
        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static void madePrime(int in, HashMap<Integer, Integer> prime) {
        if (prime.size() > in * 2) return;
        int start = prime.size() == 0 ? 2 : prime.size() + 2;
        for (int i = start; i <= in * 2; i++){
            prime.put(i,1);
            for (Map.Entry<Integer,Integer> entry : prime.entrySet()){
                int key = entry.getKey();
                if (key > Math.sqrt(i)) break;
                if(entry.getValue() == 0) continue;
                if (i % key == 0){
                    prime.put(i,0);
                    break;
                }
            }
        }
    }

    private static int countPrime(int in, HashMap<Integer, Integer> prime) {
        int count = 0;
        for (int i = in + 1; i <= in * 2; i++) if(prime.get(i) != 0) count++;
        return count;
    }

}
