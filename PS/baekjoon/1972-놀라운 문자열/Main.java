import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            String s = br.readLine();

            if (s.equals("*")) {
                break;
            }

            if (isSurprise(s)) {
                System.out.println(s + " is surprising.");
            } else {
                System.out.println(s + " is NOT surprising.");
            }
        }
    }

    private static boolean isSurprise(String s) {
        int n = s.length();

        for (int i = 1 ; i < n ; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0 ; j < s.length() ; j++) {
                if (j + i >= s.length()) {
                    continue;
                }

                String k = s.charAt(j) + "" + s.charAt(j + i);
                if (set.contains(k)) {
                    return false;
                }
                set.add(k);
            }
        }

        return true;
    }
}
