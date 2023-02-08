package plan02;

import java.io.*;

public class DSheap01_1 {
    public static void main(String[] args) throws IOException {
        // 1927 : 직접 구현
        // 최소 힙 => 가장 작은 key값이 Root에 위치하고, 부모노드 key값 ≤ 자식노드 key값 관계를 가진 완전이진트리
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int in;
        int count = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        // heap 배열
        int heapSize = 0;
        int [] minHeap = new int[count + 1];

        while (count-- > 0) {
            in = Integer.parseInt(reader.readLine());
            if (in == 0){
                if (heapSize == 0) result.append("0\n");
                else {
                    result.append(String.valueOf(minHeap[1])).append("\n");

                    // 재조정
                    int parent = 1;
                    int child = 2;
                    int tmp = minHeap[heapSize--];

                    while (child <= heapSize){
                        // min heap 규칙을 지키는 경우
                        if ((child < heapSize) && minHeap[child] > minHeap[child + 1]) child++;
                        // 루트 자식노드가 끝노드 보다 크기때문에 조건을 만족해서 나감
                        if (tmp <= minHeap[child]) break;
                        minHeap[child / 2] = minHeap[child];
                        child *= 2;
                        // 왜 밑의 경우는 안되는 거지..?? 왜냐하면 밑에서 /2하기 때문에 그대로 조정도 같은 과정을 해야함
//                        minHeap[parent] = minHeap[child];
//                        parent = child;
//                        child += 2;
                    }
                    minHeap[child / 2] = tmp;
//                    minHeap[parent] = tmp;
                }
            }else{
                // 분할 해서 찾아서 insert 함
                int i = ++heapSize;
                // 최소 힙의 특징을 이용해서 분할해서 검색함
                while ((i > 1) && (in < minHeap[i/2])){
                    minHeap[i] = minHeap[i/2]; // 부모노드를 내리고
                    i/=2; // 점점 올라감
                }
                minHeap[i] = in;
            }
        }

        writer.write(result.toString());

        writer.close();
        reader.close();

    }
}
