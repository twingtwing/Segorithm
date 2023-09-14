package ibeginner.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hp2696 {
    /**
     * [2696 중앙값 구하기]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());

        while (N-->0){
            int len = Integer.parseInt(reader.readLine());
            Heap maxHeap = new Heap(len, Type.MAX);
            Heap minHeap = new Heap(len, Type.MIN);

            result.append((len + 1)/2).append("\n");
            StringTokenizer str = new StringTokenizer(reader.readLine());
            for (int i = 0; i < len; i++) {
                if (i > 0 && i % 10 == 0){
                    str = new StringTokenizer(reader.readLine());
                    if(i % 20 == 0)
                        result.append("\n");
                }

                int n = Integer.parseInt(str.nextToken());
                if (maxHeap.isEmpty() || maxHeap.peek() >= n)
                    maxHeap.offer(n);
                else
                    minHeap.offer(n);
                if (maxHeap.getSize() > minHeap.getSize() + 1)
                    minHeap.offer(maxHeap.poll());
                else if(minHeap.getSize() > maxHeap.getSize())
                    maxHeap.offer(minHeap.poll());

                if (i % 2 == 0)
                    result.append(maxHeap.peek()).append(" ");

            }
            result.append("\n");
        }

        System.out.print(result);
        reader.close();
    }
}

enum Type{
    MAX, MIN
}

class Heap{
    private int size;
    private Type type;
    private int [] heap;

    public Heap(int len, Type type){
        this.size = 0;
        this.type = type;
        this.heap = new int[len + 1];
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void offer(int data){
        heap[++size] = data;

        int child = size;
        while (child > 1 &&
                (this.type == Type.MAX ?
                        heap[child] > heap[child/2] : heap[child] < heap[child/2])){
            swap(child, child / 2);
            child/=2;
        }
    }

    public int poll(){
        int root = heap[1];
        heap[1] = heap[size--];

        int parent = 1;
        while (parent * 2 <= size){
            int child = parent * 2;
            if (child < size &&
                    (this.type == Type.MAX ?
                            heap[child] < heap[child + 1] : heap[child] > heap[child + 1]))
                child++;
            if (this.type == Type.MAX ? heap[parent] >= heap[child] : heap[parent] <= heap[child])
                break;
            swap(parent, child);
            parent = child;
        }

        return root;
    }

    public int peek(){
        return heap[1];
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}