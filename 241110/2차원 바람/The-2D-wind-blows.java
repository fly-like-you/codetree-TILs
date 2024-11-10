import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.codetree.ai/missions/2/problems/The-2D-wind-blows/description
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, Q;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            simulate(r1, c1, r2, c2);
        }
        print();
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void simulate(int r1, int c1, int r2, int c2) {
        // 두 점으로부터 시계 방향으로 배열 밀기
        rotate2(r1, c1, r2, c2);
        // 평균 값 계산하기
        calculate(r1, c1, r2, c2);
    }

    private static void rotate2(int r1, int c1, int r2, int c2) {
        int temp;
        temp = arr[r1][c1];
        // c1
        for (int i = r1; i < r2; i++) {
            arr[i][c1] = arr[i + 1][c1];
        }
        // r2
        for (int i = c1; i < c2; i++) {
            arr[r2][i] = arr[r2][i + 1];
        }
        // c2
        for (int i = r2; i > r1; i--) {
            arr[i][c2] = arr[i - 1][c2];
        }
        // r1
        for (int i = c2; i > c1; i--) {
            arr[r1][i] = arr[r1][i - 1];
        }
        arr[r1][c1 + 1] = temp;
    }

    private static void rotate(int r1, int c1, int r2, int c2) {
        // r1 고정
        int temp;
        temp = arr[r1][c1];
        for (int i = c1; i < c2; i++) {
            arr[r1][i] = arr[r1][i + 1];
        }

        // c2 고정
        for (int i = r1; i < r2; i++) {
            arr[i][c2] = arr[i + 1][c2];
        }

        // r2 고정
        for (int i = c2; i > c1; i--) {
            arr[r2][i] = arr[r2][i - 1];
        }
        // c1 고정
        for (int i = r2; i < r1; i--) {
            arr[i][c1] = arr[i - 1][c1];
        }
        arr[r1 + 1][c1] = temp;
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private static void calculate(int r1, int c1, int r2, int c2) {
        int[][] afterArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, afterArr[i], 0, M);
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int sum = arr[i][j];
                int cnt = 1;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    cnt++;
                    sum += arr[nx][ny];
                }
                afterArr[i][j] = sum / cnt;
            }
        }
        for (int i = 0; i < N; i++) {
            System.arraycopy(afterArr[i], 0, arr[i], 0, M);
        }

    }
    

}
/*
4 6 1
4 5 2 5 6 6
2 1 6 1 0 5
5 2 2 1 6 5
4 5 2 8 8 6
2 2 4 6

 */