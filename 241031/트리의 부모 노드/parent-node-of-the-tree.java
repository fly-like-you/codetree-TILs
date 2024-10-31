import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List[] adj;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        adj = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }

        int[] parents = new int[N + 1];
        dfs(parents, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int[] visited, int cur) {

        for (int i = 0; i < adj[cur].size(); i++) {
            int node = (int) adj[cur].get(i);
            if (visited[node] != 0) continue;
            visited[node] = cur;
            dfs(visited, node);
        }
    }
}