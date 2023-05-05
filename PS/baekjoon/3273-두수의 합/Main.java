import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());
        int index = 0;
        for (int num : arr) {
            map.put(num, index);
            index++;
        }

        for (int i = 0 ; i < n ; i++) {
            int t = target - arr[i];

            if (map.containsKey(t) && map.get(t) != i) {
                count++;
            }
        }

        System.out.println(count / 2);
    }
}