import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int answer;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        pretty(0);
        System.out.println(answer);
    }

    private static void pretty(int depth) {
        if (depth == N) {
            if (check()) {
                answer++;
            }
            return;
        }
        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            pretty(depth + 1);
        }

    }

    private static boolean check() {
        int i = 0;
        while (true) {
            int num = arr[i];
            if (i + num > N) {
                return false;
            }

            for (int j = i; j < num + i; j++) {
                if (arr[j] != num) {
                    return false;
                }
            }
            i += num;
            if (i == N) {
                break;
            }

        }
        return true;

    }
}