import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] container;
    static int N, T;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        container = new int[N * 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            container[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            container[i + N] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            container[i + 2 * N] = Integer.parseInt(st.nextToken());
        }

        int temp = container[3 * N - 1];
        for (int i = 3 * N - 1; i > 0; i--) {
            container[i] = container[i - 1];
        }
        container[0] = temp;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                int idx = i * N;
                sb.append(container[idx + j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}