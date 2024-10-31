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
        int answer = 0;
        K = 2 * N;
        while (K >= 0) {
            int gold = getGold(K);
            int cost = getCost(K);

            if (gold - cost >= 0) {
                answer = Math.max(answer, gold / M);
            }
            K--;
        }
        System.out.println(answer);
    }

    private static int getGold(int k) {
        int maxGold = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxGold = Math.max(maxGold, mine(i, j, k));
            }
        }
        return maxGold;
    }

    private static int mine(int x, int y, int k) {
        int gold = 0;
        for (int i = x - k; i <= x + k; i++) {
            for (int j = y - k; j <= y + k; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N) continue;
                if ((Math.abs(x - i)) + Math.abs(y - j) > k) continue;
                if (map[i][j] == 1) gold++;
            }
        }
        return gold * M;
    }

    private static int getCost(int k) {
        return k * k + (k + 1) * (k + 1);
    }
}