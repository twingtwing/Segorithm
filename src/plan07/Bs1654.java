package plan07;

import java.awt.image.Kernel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs1654 {
    /**
     * [1654 랜선 자르기]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int [] lines = new int[Integer.parseInt(tokens.nextToken())];
        int N = Integer.parseInt(tokens.nextToken());

        int len = 0;
        for (int i = 0; i < lines.length; i++){
            lines[i] = Integer.parseInt(reader.readLine());
            len += lines[i];
        }

        Arrays.sort(lines);
        len /= N;

        int mid;
        int s = 0;
        int e = lines.length - 1;
        while (s <= e){
            mid = (s + e) / 2;
        }

        reader.close();
    }
}
