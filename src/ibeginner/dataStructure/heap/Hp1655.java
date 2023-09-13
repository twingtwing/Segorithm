package ibeginner.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hp1655 {
    /**
     * [1655 가운데를 말해요]
     * 중간값
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        MaxHeap maxHeap = new MaxHeap(N);
        MinHeap minHeap = new MinHeap(N);
        StringBuilder result = new StringBuilder();

        while (N-->0){
            int n = Integer.parseInt(reader.readLine());

            // 원소 주입
            // 중간 값을 효율적으로 찾기 위해서
            // maxHeap < n < minHeap 은 minHeap에 넣는다.
            if (maxHeap.isEmpty() || n <= maxHeap.peek())
                maxHeap.offer(n);
            else
                minHeap.offer(n);

            // 크기 조절
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.offer(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());

            result.append(maxHeap.peek()).append("\n");
        }

        System.out.println(result);
        reader.close();
    }
}

class MinHeap{
    int size;
    int [] heap;

    public MinHeap(int len){
        this.size = 0;
        this.heap = new int[len + 1];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public void offer(int data){
        heap[++size] = data;

        int child = size;
        while (child > 1 && heap[child] < heap[child/2]){
            swap(child, child/2);
            child/=2;
        }

    }

    public int poll(){
        int min = heap[1];
        heap[1] = heap[size--];

        int parent = 1;
        while (parent * 2 <= size){
            int child = parent * 2;
            if (child < size && heap[child] > heap[child + 1])
                child++;
            if (heap[parent] <= heap[child])
                break;
            swap(parent, child);
            parent = child;
        }

        return min;
    }

    private void swap(int i,  int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}

class MaxHeap{
    int size;
    int [] heap;

    public MaxHeap(int len){
        this.size = 0;
        this.heap = new int[len + 1];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    // 상향식
    public void offer(int data){
        heap[++size] = data;

        int child = size;
        while (child > 1 && heap[child] > heap[child / 2]){
            swap(child, child/2);
            child /= 2;
        }
    }

    // 하향식
    public int poll(){
        int max = heap[1];
        heap[1] = heap[size--];

        int parent = 1;
        while (parent * 2 <= size){
            int child = parent * 2;
            if (child < size && heap[child] < heap[child + 1])
                child++;
            if (heap[parent] >= heap[child])
                break;
            swap(parent, child);
            parent = child;
        }

        return max;
    }

    public int peek(){
        return heap[1];
    }

    private void swap(int i,  int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

}