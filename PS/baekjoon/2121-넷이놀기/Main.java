import java.io.*;
import java.util.*;

public class Main {
    private static int targetLength;
    private static int targetHeight;
    private static Set<Coordinate> set;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);

        for (Coordinate coordinate : set) {
            if (isSquare(coordinate)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isSquare(Coordinate coordinate) {

        Coordinate c1 = new Coordinate(coordinate.x + targetLength, coordinate.y + targetHeight);
        Coordinate c2 = new Coordinate(coordinate.x , coordinate.y + targetHeight);
        Coordinate c3 = new Coordinate(coordinate.x + targetLength, coordinate.y);

        return set.contains(c1) && set.contains(c2) && set.contains(c3);
    }

    private static void init(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();

        targetLength = Integer.parseInt(st.nextToken());
        targetHeight = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}