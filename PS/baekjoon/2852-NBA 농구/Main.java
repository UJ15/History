import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int endTime = 48 * 60;
        int team1 = 0;
        int team2 = 0;
        int winner = 0;
        int result1 = 0;
        int result2 = 0;
        int[] lastTime = new int[] {0, 0};

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] info = br.readLine().split(" ");
            int getScoreTeam = Integer.parseInt(info[0]);
            String[] times = info[1].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

            if (getScoreTeam == 1) {
                team1++;
            } else {
                team2++;
            }

            if (team1 > team2) {
                winner = 1;
            } else if (team1 < team2) {
                winner = 2;
            } else {
                winner = 0;
            }


            if (winner == 0) {
                if (lastTime[0] == 1) {
                    result1 += time - lastTime[1];
                } else if (lastTime[0] == 2) {
                    result2 += time - lastTime[1];
                }
            }

            if (lastTime[0] != winner) {
                lastTime[0] = winner;
                lastTime[1] = time;
            }
        }

        if (lastTime[0] == 1) {
            result1 += endTime - lastTime[1];
        } else if (lastTime[0] == 2) {
            result2 += endTime - lastTime[1];
        }

        System.out.println(timeToString(result1));
        System.out.println(timeToString(result2));
    }

    private static String timeToString(int result) {
        StringBuilder sb = new StringBuilder();

        int m = result / 60;
        int s = result % 60;
        if (m < 10) {
            sb.append("0");
        }
        sb.append(m).append(":");
        if (s < 10) {
            sb.append("0");
        }
        sb.append(s);

        return sb.toString();
    }
}
