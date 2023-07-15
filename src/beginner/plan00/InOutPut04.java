package beginner.plan00;

import java.io.*;

public class InOutPut04 {
    public static void main(String[] args) throws IOException {
        // 2438 : 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개 출력(1 ≤ N ≤ 100)
//        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
//
//        int count = Integer.parseInt(reader.readLine());
//        reader.close();
//
//        int len = count % 2 == 0 ? count*(count+1)/2 : (count*(count-1)/2 + count);
//
//        StringBuilder str = new StringBuilder(len);
//
//        // 내 풀이
////        for (int i = 1; i <= count; i++){
////            for (int j = i; j > 0; j--) str.append("*");
////            str.append("\n");
////        }
//
//        // top 풀이
//        StringBuilder plus = new StringBuilder(count);
//        for (int i = 0; i < count; i++) {
//            plus.append("*");
//            str.append(plus).append("\n");
//        }
//
//        System.out.println(str.toString());

        // 2439 : 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개 오른쪽을 기준으로 출력(1 ≤ N ≤ 100)
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int count = Integer.parseInt(reader.readLine());
//        reader.close();
//
//        int len = count*count;
//
//        StringBuilder str = new StringBuilder(len);
//        StringBuilder line = new StringBuilder(count);
//
//        for (int i = 0; i < count; i++) line.append(" ");
//
//        for (int i = 0; i < count; i++) {
//            line.delete(0,1).append("*");
//            str.append(line).append("\n");
//        }
//
//        System.out.println(str.toString());

        // 2440 : 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개 출력
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int count = Integer.parseInt(reader.readLine());
//        int len = count % 2 == 0 ? count*(count+1)/2 : (count*(count-1)/2 + count);
//
//        StringBuilder str = new StringBuilder(len);
//        StringBuilder line = new StringBuilder(count);
//
//        for (int i = 0; i < count; i++) line.append("*");
//        for (int i = 0; i < count; i++) {
//            str.append(line).append("\n");
//            line.delete(0,1);
//        }
//
//        writer.write(str.toString());
//
//        writer.flush();
//        writer.close();
//        reader.close();

        // 2441 : 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 오른쪽을 기준으로 별 1개 출력
//        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int count = Integer.parseInt(reader.readLine());
//
//        StringBuilder str = new StringBuilder(count*count);
//        StringBuilder line = new StringBuilder(count);
//
//        for (int i = 0; i < count; i++) line.append("*");
//        for (int i = 0; i < count; i++) {
//            str.append(line).append("\n");
//            line.replace(i,i+1," ");
//        }
//
//        writer.write(str.toString());
//
//        writer.close();
//        reader.close();

        // 2442 : 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 가운데를 기준으로 대칭으로 출력
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int count = Integer.parseInt(reader.readLine());
//
//        StringBuilder str = new StringBuilder(2*count*count);
//        StringBuilder left = new StringBuilder(count);
//        StringBuilder right = new StringBuilder(count - 1);
//
//        for (int i = 0; i < count; i++) left.append(" ");
//        for (int i = 0; i < count; i++) {
//            left.delete(0,1).append("*");
//            str.append(left).append(right).append("\n");
//            right.append("*");
//        }
//
//        writer.write(str.toString());
//
//        writer.close();
//        reader.close();

        // 2445
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int count = Integer.parseInt(reader.readLine());
//
//        StringBuilder str = new StringBuilder(2 * count * count);
//        StringBuilder line = new StringBuilder(count);
//        StringBuilder rev = new StringBuilder(count);
//
//        for (int i = 0; i < count; i++)  {
//            line.append(" ");
//            rev.append(" ");
//        }
//        for (int i = 0; i < count; i++) {
//            line.replace(i,i+1,"*");
//            rev.delete(0,1).append("*");
//            str.append(line).append(rev).append("\n");
//        }
//        for (int i = count; i > 1; i--){
//            line.replace(i-1,i," ");
//            rev.replace(count - i, count - i + 1," ");
//            str.append(line).append(rev).append("\n");
//        }
//
//        writer.write(str.toString());
//
//        writer.close();
//        reader.close();

        // 2446 :
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int count = Integer.parseInt(reader.readLine());
//
//        StringBuilder str = new StringBuilder((int)Math.pow(count-1, 2));
//        StringBuilder right = new StringBuilder(count);
//        StringBuilder left = new StringBuilder(count-1);
//
//        left.append("*");
//        for (int i = 0; i < count - 1; i++){
//            right.append("*");
//            left.append("*");
//        }
//
//        for (int i = 0; i < count; i++) {
//            str.append(left).append(right).append("\n");
//            left.replace(i,i+1," ");
//            if(right.length() > 0) right.delete(right.length() - 1, right.length());
//        }
//
//        left.delete(0,1).append("*");
//        for (int i = 1; i < count; i++){
//            left.delete(0,1).append("*");
//            right.append("*");
//            str.append(left).append(right).append("\n");
//        }
//
//        writer.write(str.toString());
//
//        writer.close();
//        reader.close();

        // 2522 :
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());

        StringBuilder str = new StringBuilder(count*(2*count -1));
        StringBuilder line = new StringBuilder(count);

        for (int i = 0; i < count; i++) line.append(" ");
        for (int i = 0; i < count; i++){
            line.delete(0,1).append("*");
            str.append(line).append("\n");
        }
        for (int i = 1; i < count; i++){
            line.replace(i-1,i," ");
            str.append(line).append("\n");
        }

        writer.write(str.toString());

        reader.close();
        writer.close();

    }
}
