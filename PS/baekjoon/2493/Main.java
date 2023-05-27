import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        int[] arr = new int[n];
        int[] result = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1 ; i >= 0 ; i--) {
            if (stack.isEmpty()) {
                stack.push(new int[] {arr[i], i});
                continue;
            }

            int[] cur = stack.peek();

            while (arr[i] > cur[0]) {
                result[cur[1]] = i + 1;
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                cur = stack.peek();
            }

            stack.push(new int[] {arr[i], i});
        }

        for (int i = 0 ; i < n ; i++) {
            System.out.print(result[i] + " ");
        }

    }
}

