import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxGold = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int numOfGold = 0;
                for (int k = 0; k <= 2 * (N - 1); k++) {
                    numOfGold += getGoldBorder(i, j, k);

                    if (numOfGold * M >= getArea(k)) {
                        maxGold = Math.max(maxGold, numOfGold);
                    }
                }
            }
        }
        System.out.println(maxGold);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static int getArea(int k) {
        return k * k + (k + 1) * (k + 1);
    }

    static int[] dx = new int[]{1, 1, -1, -1};
    static int[] dy = new int[]{-1, 1, 1, -1};

    private static int getGoldBorder(int x, int y, int k) {
        int numOfGold = 0;

        if (k == 0) return map[x][y];

        int curX = x - k, curY = y;

        for (int curDir = 0; curDir < 4; curDir++) {
            for (int step = 0; step < k; step++) {
                if (inRange(curX, curY)) {
                    numOfGold += map[curX][curY];
                }
                curX += dx[curDir];
                curY += dy[curDir];
            }
        }
        return numOfGold;
    }


}