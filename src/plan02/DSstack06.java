package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSstack06 {
    public static void main(String[] args) throws IOException {
        // 2493 : 탑 레이저
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int [] stack = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer token = new StringTokenizer(reader.readLine());

        writer.write(result.toString());

        writer.close();
        reader.close();

    }
}
