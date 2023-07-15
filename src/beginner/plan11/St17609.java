package beginner.plan11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class St17609 {
    /**
     * [17609 회문]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        while (N-- > 0){
            char [] str = reader.readLine().toCharArray();
            int s = 0;
            int e = str.length - 1;

            int cnt = 0;
            while (s < e && cnt < 1){
                if (str[s] == str[e]){
                    s++;
                    e--;
                }
                else {
                    int ts = s + 1;
                    int te = e;
                    while (ts < te){
                        if (str[ts++] != str[te--]){
                            cnt++;
                            break;
                        }
                    }
                    ts = s;
                    te = e - 1;
                    while (ts < te){
                        if (str[ts++] != str[te--]){
                            cnt++;
                            break;
                        }
                    }
                    cnt = cnt > 1 ? 2 : 1;
                }
            }

            result.append(cnt).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}
