package beginner.plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue03_2 {
    public static void main(String[] args) throws IOException {
        // 1021 : 양방향 회전큐 => 실제로 위치 이동한 값만 구한다.
        // point !! 순차자료구조 이므로 배열을 계속 업데이트 한다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int in;
        int total = 0;
        int cnt = Integer.parseInt(str.nextToken());
        int count = Integer.parseInt(str.nextToken());

        int [] queue = new int[cnt];

        for (int i = 0; i < cnt; i++) {queue[i] = i + 1;}

        while (count-- > 0){
            in = Integer.parseInt(token.nextToken());
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] == in){
                    if (i > queue.length / 2) total += queue.length - i; // 1 을 빼지않음 => 맨 앞자리는 pop이므로 움직이지 않은것로 취급한다.
                    else total += i;
                    int [] tmp = new int[queue.length - 1];
                    // 시작을 해당위치 다음부터 하고 마지막을 그 다음부터 하면 가능하다.
                    // 왼쪽 오른쪽 이동 모두 가능하다
                    for (int j = 1; j < queue.length; j++) tmp[j - 1] = queue[(i + j) % queue.length];
                    queue = tmp;
                    break;
                }
            }
        }

        System.out.print(total);

        reader.close();

    }

}
