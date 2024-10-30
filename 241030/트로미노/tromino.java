import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int answer;
    static int[][] map;

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
                boolean[][] visited = new boolean[N][M];
                visited[i][j] = true;
                dfs(0, 0, i, j, visited);
            }
        }

        System.out.println(answer);

    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void dfs(int cur, int sum, int x, int y, boolean[][] visited) {

        if (cur == 3) {
            answer = Math.max(sum, answer);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(cur + 1, sum + map[nx][ny], nx, ny, visited);
            visited[nx][ny] = false;
        }

    }
}