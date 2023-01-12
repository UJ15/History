import java.util.*;

class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    inte count = 0;

    public int[] solution(String[] operations) {

        for (String op : operations) {
            char command = op.charAt(0);

            switch (command) {
                case 'I' : insert(op);
                    break;
                case 'D' : delete(op);
                    break;
            }
        }

        if (count == 0) {
            return new int[] {0, 0};
        }

        return new int[] {maxHeap.poll(), minHeap.poll()};
    }

    private void insert(String op) {
        if (count == 0) {
            maxHeap.clear();
            minHeap.clear();
        }
        int number = Integer.parseInt(op.substring(2));

        maxHeap.add(number);
        minHeap.add(number);
        count++;
    }

    private void delete(String op) {
        if (count == 0) {
            maxHeap.clear();
            minHeap.clear();
            return;
        }

        if (op.length() == 3) {
            int number = maxHeap.poll();
            count--;
        } else {
            int number = minHeap.poll();
            count--
        }
    }
}