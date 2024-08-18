import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K;
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        comb(0);
        System.out.println(sb);
    }

    private static void comb(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= K; i++) {
            arr[depth] = i;
            comb(depth + 1);
        }
    }
}