package plan10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ip16236 {
    /**
     * [16236 아기상어]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int [][] sea = new int[N][N];
        int [][] four = {{-1,0},{0,-1},{1,0},{0,1}};
        int x = -1;
        int y = -1;
        int wgt = 2;
        int time = 0;

        StringTokenizer tokens;
        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                sea[i][j] = Integer.parseInt(tokens.nextToken());
                if (sea[i][j] == 9){
                    x = i;
                    y = j;
                }
            }
        }


        System.out.println(time);
        reader.close();
    }

}

class Sea{
    int wgt;
    int time;
    int [][] sea;
    Spot spot;

    Sea(int N){
        this.wgt = 2;
        this.time = 0;
        this.sea = new int[N][N];
    }

    void addSpot(int i, int j, int v){
        this.sea[i][j] = v;
        if (v == 9)
            this.spot = new Spot(i,j);
    }
}

class Spot{
    int x;
    int y;
    Spot(int x, int y){
        this.x = x;
        this.y = y;
    }
}
