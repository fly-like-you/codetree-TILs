import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] mat;
    static int N, M, Q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        mat = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            boolean cmd = st.nextToken().charAt(0) == 'L';

            doCommand(row, cmd);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(mat[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void doCommand(int row, boolean cmd) {
        // 바람 불어서 밀기
        int[] arr = mat[row];
        sweep(arr, cmd);


        // 위 에서 밀었을 때 값이 같은지 비교하기
        int u = row - 1;
        int prev = row;
        boolean upCmd = cmd;
        while (u >= 0) {
            if (isCondition(mat[u], mat[prev])) {
                upCmd = !upCmd;
                sweep(mat[u], upCmd);
            } else break;
            prev = u;
            u--;
        }

        int d = row + 1;
        prev = row;
        boolean downCmd = cmd;
        while (d < N) {
            if (isCondition(mat[d], mat[prev])) {
                downCmd = !downCmd;
                sweep(mat[d], downCmd);
            } else break;
            prev = d;
            d++;
        }
    }
    private static boolean isCondition(int[] arr1, int[] arr2) {
        for (int i = 0; i < M; i++) {
            if (arr1[i] == arr2[i]) return true;
        }
        return false;
    }
    private static void sweep(int[] arr, boolean dir) {
        if (dir) {
            int temp = arr[M - 1];
            for (int i = M - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        } else {
            int temp = arr[0];
            for (int i = 0; i < M - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[M - 1] = temp;
        }

    }
}