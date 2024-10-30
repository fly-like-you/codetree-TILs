import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int answer;
    static int N, M;
    static int[][][] shapes = new int[][][]{
            {{1, 1, 0}, {1, 0, 0}, {0, 0, 0}},

            {{1, 1, 0}, {0, 1, 0}, {0, 0, 0}},

            {{1, 0, 0}, {1, 1, 0}, {0, 0, 0}},

            {{0, 1, 0}, {1, 1, 0}, {0, 0, 0}},

            {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}},

            {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}},
    };

    private static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for (int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;
            for (int dx = 0; dx < 3; dx++) {
                for (int dy = 0; dy < 3; dy++) {
                    // 사용자 정의 블록에서의 이동
                    if (shapes[i][dx][dy] == 0) continue;
                    if (x + dx >= N || y + dy >= M) isPossible = false;
                    else sum += map[x + dx][y + dy];
                }
            }
            if (isPossible) maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, getMaxSum(i, j));
            }
        }

        System.out.println(answer);

    }

}