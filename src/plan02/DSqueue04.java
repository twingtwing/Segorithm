package plan02;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class DSqueue04 {
    static int front;
    static int rear;
    static int [] queue = new int[100];
    public static void main(String[] args) throws IOException {
        // 1966 : print 큐
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        int count = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        StringTokenizer first;
        StringTokenizer second;

        int n;
        int len;
        int spot;

        while (count -- > 0) {

        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }

}
