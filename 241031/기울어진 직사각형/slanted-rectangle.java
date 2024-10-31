import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};
    static Integer[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cost = getCost(i, j);
                maxSum = Math.max(maxSum, cost);
            }
        }

        System.out.println(maxSum);
    }

    private static int getCost(int x, int y) {
        int curDir = 0;
        int maxSum = 0;
        // 마름모 탐색

        for (int w = 1; w < N; w++) {
            for (int h = 1; h < N; h++) {
                int nx = x, ny = y;
                int sum = 0;
                for (int dir = 0; dir < 4; dir++) {
                    if (dir == 1 || dir == 3) {
                        for (int dw = 0; dw < w; dw++) {
                            nx += dx[dir]; ny += dy[dir];
                            if (!inRange(nx, ny))  {
                                sum -= 1000000;
                            } else {
                                sum += map[nx][ny];

                            }
                        }
                    } else {
                        for (int dh = 0; dh < h; dh++) {
                            nx += dx[dir]; ny += dy[dir];
                            if (!inRange(nx, ny)){
                                sum -= 1000000;
                            } else {
                                sum += map[nx][ny];

                            }
                        }
                    }
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}