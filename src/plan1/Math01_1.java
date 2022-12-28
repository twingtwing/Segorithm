package plan1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Math01_1 {
    public static void main(String[] args) throws IOException {
        //1929 : M이상 N이하의 소수를 모두 출력(1 ≤ M ≤ N ≤ 1,000,000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = reader.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int start = Math.max(Integer.parseInt(st.nextToken()),2);
        int end = Integer.parseInt(st.nextToken());

        ArrayList<Integer> minor = new ArrayList<>();
        StringBuilder result = new StringBuilder(end - start + 1);

        findMinor(2, start - 1, minor, null);
        findMinor(start, end, minor, result);

        writer.write(result.toString());

        writer.close();
        reader.close();
    }

    private static void findMinor(int start, int end, ArrayList<Integer> list, StringBuilder str){
        boolean flag;
        for (int i = start; i <= end; i++){
            flag = false;
            for (int m : list){
                if (i % m == 0){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                list.add(i);
                System.out.println(i);
                if (str != null) str.append(String.valueOf(i)).append("\n");
            }
        }
    }
}
