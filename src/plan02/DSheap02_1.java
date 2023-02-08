package plan02;

import java.io.*;

public class DSheap02_1 {
    public static void main(String[] args) throws IOException {
        // 11286 : 절댓값 heap
        // 정수는 -231보다 크고, 231보다 작다. => int 형
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        int in;
        int count = Integer.parseInt(reader.readLine());

        int size = 0;
        int [] minVal = new int[count];

        while (count-- > 0){
            in = Integer.parseInt(reader.readLine());
            if (in == 0) {
                if (size == 0) result.append("0\n");
                else{
                    result.append(String.valueOf(minVal[1])).append("\n");

                    int child = 2;
                    int tmp = minVal[size--];

                    while (child <= size){
                        if (child < size && (Math.abs(minVal[child]) > Math.abs(minVal[child+1])
                                || (minVal[child] + minVal[child+1] == 0 && minVal[child] > 0))) child++;
                        if (Math.abs(tmp) < Math.abs(minVal[child]) || tmp == minVal[child]
                                || (tmp + minVal[child] == 0 && tmp < 0)) break;
                        minVal[child / 2] = minVal[child];
                        child *= 2;
                    }
                    minVal[child/2] = tmp;

                }
            }else{
                int len = ++size;
                while (len > 1 && (Math.abs(in) < Math.abs(minVal[len/2])
                        || (in + Math.abs(minVal[len/2]) == 0 && in < 0))){
                    minVal[len] = minVal[len/2];
                    len /= 2;
                }
                minVal[len] = in;
            }
        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }
}
