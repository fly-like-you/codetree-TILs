import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] container;
    static int N, T;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        container = new int[3][N];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                container[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T = T % (N * 3);
        while (T-- > 0) {
            int temp1 = container[0][N-1];
            for (int i = N - 1; i > 0; i--) {
                container[0][i] = container[0][i-1];
            }
            container[0][0] = temp1;

            int temp2 = container[1][N-1];
            for (int i = N - 1; i > 0; i--) {
                container[1][i] = container[1][i-1];
            }
            container[1][0] = temp2;

            int temp3 = container[2][N-1];
            for (int i = N - 1; i > 0; i--) {
                container[2][i] = container[2][i-1];
            }
            container[2][0] = temp3;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(container[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}