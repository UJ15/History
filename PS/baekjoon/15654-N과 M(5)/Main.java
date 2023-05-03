import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[Integer.parseInt(st.nextToken())];
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0, c, nums, new ArrayList<>(), visited);
    }

    private static void dfs(int depth, int end, int[] nums, List<Integer> list, boolean[] visited) {
        if (depth == end) {
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(depth + 1, end, nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}