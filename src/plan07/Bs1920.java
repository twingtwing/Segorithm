package plan07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs1920 {
    /**
     * [1920 수 찾기]
     * <br>
     * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BnySrh srh = new BnySrh(Integer.parseInt(reader.readLine()));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < srh.getLength(); i++)
            srh.add(i, Integer.parseInt(tokens.nextToken()));
        srh.sort();

        int M = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        tokens = new StringTokenizer(reader.readLine());
        while (M-->0)
            result.append(srh.search(Integer.parseInt(tokens.nextToken()))).append("\n");

        System.out.println(result);
        reader.close();
    }
}

class BnySrh{
    int [] sort;

    BnySrh(int N){
        this.sort = new int[N];
    }

    int getLength(){
        return this.sort.length;
    }

    void add(int i, int v){
        this.sort[i] = v;
    }

    void sort(){
        Arrays.sort(this.sort);
    }

    int search(int n){
        return binarySrh(0, this.sort.length - 1, n);
    }

    private int binarySrh(int s, int e, int n) {
        if (s > e)
            return 0;
        int mid = (s + e) / 2;
        if (this.sort[mid] == n)
            return 1;
        if (this.sort[mid] > n)
            return binarySrh(s, mid - 1, n);
        if (this.sort[mid] < n)
            return binarySrh(mid + 1, e, n);
        return 0;
    }

}
