package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue03_2 {
    static int [] queue;
    public static void main(String[] args) throws IOException {
        // 1021 : 양방향 회전큐 => 실제로 위치 이동한 값만 구한다.
        // point !! 순차자료구조 이므로 배열을 계속 업데이트 한다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine());

        int in;
        int total = 0;
        int cnt = Integer.parseInt(str.nextToken());
        int count = Integer.parseInt(str.nextToken());

        queue = new int[cnt];
        for (int i = 0; i < cnt; i++) {queue[i] = i + 1;}

        while (count-- > 0){
            in = Integer.parseInt(token.nextToken());
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] == in){
                    // i번 움직였다는 의미
                    if (i > queue.length / 2) total += queue.length - i; // 1 을 빼지않음(오직 앞에서만 pop가능하므로)
                    else total += i;
                    renewAry(i, queue.length);
                    break;
                }
            }
        }

        writer.write(String.valueOf(total));

        reader.close();
        writer.close();

    }

    private static void renewAry(int idx, int size) {
        int [] tmp = new int[size - 1];
        for (int i = 1; i < size; i++) {
            // 시작을 해당위치 다음부터 하고 마지막을 그 다음부터 하면 가능하다.
            // 왼쪽 오른쪽 이동 모두 가능하다 (와,, 진짜 천재인듯,,ㅋ)
            tmp[i - 1] = queue[(idx + i) % queue.length];
        }
        queue = tmp;
    }
}
