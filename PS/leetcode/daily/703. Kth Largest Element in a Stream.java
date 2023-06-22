class KthLargest {
    private PriorityQueue<Integer> q;
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>((a, b) -> b - a);
        this.kth = k;

        for (int n : nums) {
            q.offer(n);
        }
    }

    public int add(int val) {
        q.offer(val);
        PriorityQueue<Integer> temp = new PriorityQueue<>(q);

        for (int i = 0 ; i < kth - 1; i++) {
            temp.poll();
        }

        return temp.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

//Best Solution

class KthLargest {
    private int k;
    private int size;
    private int[] heap;

    public KthLargest(int k, int[] nums) {
        //Initial heap
        this.k = k;
        this.heap = nums;
        this.size = nums.length;
        //heapify TODO
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            sink(i);
        }
        //Resize
        while (size > k) {//delete excessive
            del();
        }
        //Min heap of size k/k-1
        this.size = Math.min(k, nums.length);
        this.heap = Arrays.copyOf(nums, k);
    }


    void swim(int i) {
        while (i != 0 && heap[(i - 1) / 2] > heap[i]) {
            swap((i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    void sink(int i) {
        while (2*i + 1 < size) {
            int k = 2 * i + 1;
            if (k + 1 < size && heap[k + 1] < heap[k]) {
                k++;
            }
            if (heap[k] >= heap[i]) {
                break;
            }
            swap(i, k);
            i = k;
        }
    }

    void del() {
        swap(0, size - 1);
        size--;
        sink(0);
    }

    void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public int add(int val) {
        if (size != k) {
            heap[heap.length - 1] = val;
            size++;
            swim(heap.length - 1);
            return heap[0];
        }
        if (val > heap[0]) {
            heap[0] = val;
            sink(0);
        }
        return heap[0];
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */