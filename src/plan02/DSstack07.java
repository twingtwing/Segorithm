package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSstack07 {
    public static void main(String[] args) throws IOException {
        // 17298 : 오큰수
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());


        writer.write(result.toString());

        writer.close();
        reader.close();

    }
}
