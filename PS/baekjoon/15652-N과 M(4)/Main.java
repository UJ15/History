import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(1, n, m, new StringBuilder());
    }

    private static void dfs(int start, int n, int m, StringBuilder sb) {
        if (sb.length() == m * 2) {
            System.out.println(sb);
            return;
        }

        for (int i = start ; i <= n ; i++) {
            sb.append(i).append(" ");
            dfs(i, n, m, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}