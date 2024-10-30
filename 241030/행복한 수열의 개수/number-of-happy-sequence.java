import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int N, M;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        // column search
        A: for (int j = 0; j < N; j++) {
            int start = arr[0][j];
            for (int i = 0; i < N; i++) {
                if (start != arr[i][j]) {
                    break A;   
                }
            }
            answer++;
        }
        System.out.println(answer);
        // row search
                // column search
        A: for (int j = 0; j < N; j++) {
            int start = arr[j][0];
            for (int i = 0; i < N; i++) {
                if (start != arr[j][i]) {
                    break A;   
                }
            }
            answer++;
        }
    }
}