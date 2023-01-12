package plan01;

import java.io.*;
import java.util.StringTokenizer;

public class MathProgress02 {

    static int [] progress = new int[21];
    static int count;
    static int n;
    static int s;

    public static void main(String[] args) throws IOException {
        //1182 : 부분수열의 합  (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer oneLine = new StringTokenizer(reader.readLine());
        StringTokenizer twoLine = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(oneLine.nextToken());
        s = Integer.parseInt(oneLine.nextToken());

        madeProgress(twoLine);
//        int count = countProgress(progress, s, 0, 0);
        countProgress(0,0);

        // s가 0인 경우 공집합도 포함될 수 있음 그러므로 배준다.
        if (s == 0) count --;

        writer.write(String.valueOf(count));

        writer.close();
        reader.close();

    }

    private static void countProgress(int sum, int step) {
        if (step == n) {
            if (sum == s) count++;
            return;
        }
        countProgress(sum + progress[step],step + 1); // 현재 시점에서 계산
        countProgress(sum, step + 1); // 현재 시점을 건너 뜀
    }

//    private static int countProgress(int[] progress, int s, int start, int count) {
//        // 공집합을 제외하고 시작하였기 때문에 -1을 할 필요가 없음
//        for (int i = start; i < progress.length; i++){
//            if (progress[i] == s) count ++;
//            count = countProgress(progress, s - progress[i], i + 1, count);
//        }
//        return count;
//    }

    private static void madeProgress(StringTokenizer twoLine) {
//        for (int i = 0; i < progress.length; i++) progress[i] = Integer.parseInt(twoLine.nextToken());
        for (int i = 0; i < n; i++) progress[i] = Integer.parseInt(twoLine.nextToken());
    }
}
