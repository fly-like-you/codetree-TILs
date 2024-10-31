import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] adj;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {  // 1부터 시작하여 불필요한 반복 제거
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]);
            int to = Integer.parseInt(tokens[1]);
            adj[from].add(to);
            adj[to].add(from);
        }

        int[] parents = new int[N + 1];
        dfs(parents, 1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int[] parents, int cur) {
        for (int node : adj[cur]) {
            if (parents[node] != 0) continue;
            parents[node] = cur;
            dfs(parents, node);
        }
    }
}