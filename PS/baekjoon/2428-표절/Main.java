import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0 ; i < arr.length ; i++) {
            sum += binarySearch(arr, i) - i;
        }

        System.out.println(sum);
    }

    private static int binarySearch(int[] arr, int i) {
        int left = i + 1;
        int right = arr.length - 1;
        int result = i;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[i] * 10 < arr[mid] * 9) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }
}

