package src.algo1030;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        // row search
        for (int i = 0; i < N; i++) {
            // seq에 행 값 입력해주기
            for (int j = 0; j < N; j++) seq[j] = arr[i][j];
            if (isHappySequence()) answer++;
        }
        // column search
        for (int j = 0; j < N; j++) {
            // seq에 열 값 입력해주기
            for (int i = 0; i < N; i++) seq[i] = arr[i][j];

            if (isHappySequence()) answer++;
        }

        System.out.println(answer);
    }

    private static boolean isHappySequence() {
        // seq가 연속한지 확인하려면
        // 1. 같지 않은 경우 l길이를 초기화
        // 2. 같은 경우 l 길이를 늘려준다
        int l = 0;
        int cur = seq[0];
        int longest = 0;
        for (int i = 0; i < N; i++) {
            if (cur == seq[i]) l++;
            else {
                l = 1;
                cur = seq[i];
            }

            // 항상 최대로 길었던 값을 계속 비교
            longest = Math.max(longest, l);
        }
        return longest >= M;
    }
}