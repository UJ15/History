import java.io.*;
import java.util.*;


public class Main {

    private static List<Character> vowel;
    private static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        vowel = List.of('a', 'e', 'i', 'o', 'u');
        result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        char[] arr = new char[k];
        for (int i = 0 ; i < k ; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(arr, n, 0, new StringBuilder(), 0, 0);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void dfs(char[] arr, int n, int start, StringBuilder sb, int vo, int con) {
        if (sb.length() == n) {
            if (vo >= 1 && con >= 2) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = start ; i < arr.length ; i++) {
            if (vowel.contains(arr[i])) {
                vo++;
            } else {
                con++;
            }
            sb.append(arr[i]);
            dfs(arr, n, i + 1, sb, vo, con);
            sb.deleteCharAt(sb.length() - 1);
            if (vowel.contains(arr[i])) {
                vo--;
            } else {
                con--;
            }
        }
    }
}

