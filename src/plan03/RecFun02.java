package plan03;

import java.io.*;
import java.util.StringTokenizer;

class Storage{
    int color;
    int white;
    public void sum(Storage first, Storage second){
        first.color += second.color;
        first.white += second.white;
    }
}

public class RecFun02 {
    public static void main(String[] args) throws IOException {
        // 2630 : 색종이 만들기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        int [][] box = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer str = new StringTokenizer(reader.readLine());
            for (int j = 0; j < size; j++) box[i][j] = Integer.parseInt(str.nextToken());
        }

        Storage result =findColorBox(box,0, size, 0,  size);

        System.out.println(result.white);
        System.out.println(result.color);

        reader.close();

    }

    private static Storage findColorBox(int [][] box, int stX, int edX, int stY, int edY) {
        Storage result = new Storage();
        boolean flag = false;
        int standard = box[stY][stX];

        Loop :
        for (int i = stY; i < edY; i++) {
            for (int j = stX; j < edX; j++) {
                if (box[i][j] != standard) {
                    flag = true;
                    break Loop;
                }
            }
        }

        if (flag){
            result.sum(result,findColorBox(box, stX, (edX + stX)/2, stY, (edY + stY) / 2));
            result.sum(result,findColorBox(box, stX, (edX + stX)/2, (edY + stY) / 2, edY));
            result.sum(result,findColorBox(box, (edX + stX)/2, edX, stY, (edY + stY) / 2));
            result.sum(result,findColorBox(box, (edX + stX)/2, edX,(edY + stY) / 2, edY));
        }else{
            if (standard == 1) result.color = 1;
            else result.white = 1;
        }

        return result;
    }

}
