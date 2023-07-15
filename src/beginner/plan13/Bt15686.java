package beginner.plan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bt15686 {
    /**
     * [15686 치킨 배달]
     * <br>
     * 치킨집 M개 선택하는 총 조합을 백트래킹한다.
     * */
    private static int M;
    private static int min;
    private static ArrayList<Point> houses;
    private static ArrayList<Point> chickens;
    private static ArrayList<Point> selected;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        min = Integer.MAX_VALUE;
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        selected = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(tokens.nextToken());
                if (n == 1)
                    houses.add(new Point(i,j));
                if (n == 2)
                    chickens.add(new Point(i,j));
            }
        }

        backTracking(0, 0);

        System.out.println(min);
        reader.close();
    }

    private static void backTracking(int s, int cnt) {
        if (cnt == M){
            int distance = getDistance();
            min = Math.min(distance, min);
            return;
        }
        // KeyPoint!!
        // 치킨집 M개의 조합을 백트래킹
        for (int i = s; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            backTracking(i + 1, cnt + 1); // 치킨집 M개 선택하는 총 조합
            selected.remove(chickens.get(i));
        }
    }

    private static int getDistance(){ // 선택된 치킨집간의 최소 총 거리
        int total = 0;
        for (Point p : houses){
            int m = Integer.MAX_VALUE;
            for (Point s : selected){ // 선택된 치킨집중에 가장 가까운 치킨집
                int d  = Math.abs(p.x - s.x) + Math.abs(p.y - s.y);
                m = Math.min(m,d);
            }
            total += m;
        }
        return total;
    }
}

class Point{
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
