package plan02;

import java.io.*;
import java.util.StringTokenizer;

public class DSqueue04 {
    public static void main(String[] args) throws IOException {
        // 1966 : print 큐 .. => 와,, 최고로 어렵다 ㅋㅋㅋㅋㅋ
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer first;
        StringTokenizer second;

//        for (int i = 0; i < T; i++) {
//            int N = sc.nextInt();
//            int M = sc.nextInt();
//            int cnt = 0;
//            Queue<int[]> queue = new LinkedList<>();
//            for (int j = 0; j < N; j++) {
//                queue.add(new int[] {j,sc.nextInt()});
//            }
//
//            while (true) {
//                int now[] = queue.remove();
//                boolean flag = true;
//
//                for (int q[] : queue) {
//                    if(q[1] > now[1]) {
//                        flag = false;
//                        break;
//                    }
//                }
//
//                if(flag) {
//                    cnt++;
//                    if(now[0] == M) break;
//                }else {
//                    queue.add(now);
//                }
//            }
//            System.out.println(cnt);
//        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }

}
