import java.io.*;
import java.util.*;

public class Main {

    private static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        result = "";
        dfs("", n);
        System.out.println(result);
    }

    private static void dfs(String s, int n) {
        if (result.length() == n) {
            return;
        }

        if (s.length() == n) {
            result = s;
            return;
        }

        for (int i = 1 ; i <= 3 ; i++) {
            if (isGood(s + i)) {
                dfs(s + i, n);
            }
        }
    }

    private static boolean isGood(String s) {
        int size = s.length();
        for (int i = 1 ; i <= size / 2 ; i++) {
            if (s.substring(size - i, size).equals(s.substring(size - (i * 2), size - i))) {
                return false;
            }
        }

        return true;
    }
}

