import java.io.*;
import java.util.*;

public class Main {
    private static Deque<Belt> top;
    private static Deque<Belt> bottom;
    private static int n;
    private static int k;
    private static int count;
    private static int broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 1;
        broken = 0;

        createConveyor(br, st);

        while (broken < k) {
            rotate();
            getRobot();
            moveRobot();
            getRobot();
            putRobot();

            if (broken >= k) {
                break;
            }

            count++;
        }

        System.out.println(count);
    }

    private static void putRobot() {
        Belt topFirst = top.pollFirst();

        if (topFirst.durability > 0) {
            topFirst.robot = true;
            if (--topFirst.durability == 0) {
                broken++;
            }
        }

        top.addFirst(topFirst);
    }

    private static void getRobot() {
        Belt topLast = top.pollLast();

        if (topLast.robot) {
            topLast.robot = false;
        }

        top.addLast(topLast);
    }

    private static void moveRobot() {
        //맨 오른쪽 두개의 벨트를 비교하고 다시 삽입하면서 전체 원소들을 비교하며 로봇들의 위치를 옮긴다.
        for (int i = 0 ; i < n - 1 ; i++) {
            Belt right = top.pollLast();
            Belt left = top.pollLast();

            if (left.robot && !right.robot && right.durability > 0) {
                left.robot = false;
                right.robot = true;
                if (--right.durability == 0) {
                    broken++;
                }
            }

            top.addFirst(right);
            top.addLast(left);
        }

        top.addFirst(top.pollLast());
    }

    private static void rotate() {
        Belt topLast = top.pollLast();
        Belt bottomFirst = bottom.pollFirst();

        bottom.addLast(topLast);
        top.addFirst(bottomFirst);
    }

    private static void createConveyor(BufferedReader br, StringTokenizer st) throws IOException {
        top = new ArrayDeque<>();
        bottom = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            top.addLast(new Belt(Integer.parseInt(st.nextToken()), false));
        }

        for (int i = 0 ; i < n ; i++) {
            bottom.addFirst(new Belt(Integer.parseInt(st.nextToken()), false));
        }
    }
}

//한칸의 벨트
class Belt {
    int durability;
    //로봇이 있는지 없는지
    boolean robot;

    public Belt(int durability, boolean robot) {
        this.durability = durability;
        this.robot = robot;
    }
}