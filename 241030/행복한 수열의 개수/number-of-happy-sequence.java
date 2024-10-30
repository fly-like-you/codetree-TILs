import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int N, M;
    static int[] seq;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        seq = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) seq[j] = arr[i][j];
            if (isHappySequence()) answer++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) seq[i] = arr[j][i];
            if (isHappySequence()) answer++;
        }
        System.out.println(answer);
    }
    private static boolean isHappySequence() {
        // 1 2 2 2 3 4 5
        int l = 0;
        int cur = seq[0];
        for (int i = 0; i < N; i++) {
            if (cur != seq[i]) {
                l = 1;    
            } else {
                l++;
            }
            
        }
        
        return l >= M;
    }
}