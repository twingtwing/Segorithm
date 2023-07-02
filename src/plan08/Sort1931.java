package plan08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort1931 {
    /**
     * [1931 회의실 배정]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        String [] input;
        List<Meeting> list = new ArrayList<>();
        while (N-->0){
            input = reader.readLine().split(" ");
            list.add(new Meeting(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
        }

        Collections.sort(list);

        int count = 1;
        int min = list.get(0).y;
        for (int i = 1; i < list.size(); i++) {
            if (min > list.get(i).x)
                min = Math.min(min, list.get(i).y);
            else {
                count++;
                min = list.get(i).y;
            }
        }

        System.out.println(count);
        reader.close();
    }
}

class Meeting implements Comparable<Meeting>{
    int x;
    int y;

    Meeting(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.x != o.x)
            return this.x - o.x;
        return this.y - o.y;
    }
}
