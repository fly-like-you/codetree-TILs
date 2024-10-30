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
            for (int i = 0; i <= N - M; i++) {
                int start = arr[i][j];
                int l = 1;
                for (int k  = i; k < i + M; k++) {
                    if (start == arr[k][j]) l++;
                }
                if (l == M) {
                    answer++;
                    break A;
                }
                
            }
        }
        // row search
        A: for (int j = 0; j < N; j++) {
            
            for (int i = 0; i <= N - M; i++) {
                int start = arr[j][i];
                int l = 0;
                for (int k  = i; k < i + M; k++) {
                    if (start == arr[j][k]) l++;
                }
                if (l == M) {
                    answer++;
                    break A;
                }
            }
        }
        System.out.println(answer);
    }
}