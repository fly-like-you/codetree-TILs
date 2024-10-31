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
    static ArrayList<int[]>[] adj;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[from].add(new int[] {to, w});
            adj[to].add(new int[] {from, w});
        }

        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        dfs(visited, 1);

        Arrays.fill(visited, -1);
        visited[targetNode] = 0;
        dfs(visited, targetNode);
        System.out.println(longestDist);
    }
    static int longestDist = 0;
    static int targetNode = 0;
    private static void dfs(int[] visited, int cur) {

        for (int i = 0; i < adj[cur].size(); i++) {
            int[] node = adj[cur].get(i);
            int v = node[0], w = node[1];
            if (visited[v] != -1) continue;
            visited[v] = visited[cur] + w;
            if (visited[v] > longestDist) {
                targetNode = v;
                longestDist = visited[v];
            }
            dfs(visited, v);
        }
    }
}