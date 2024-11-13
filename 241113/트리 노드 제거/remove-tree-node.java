
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[] tree;
	static int N, cut, root, answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 트리 순회하기
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int node = 0; node < N; node++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = node;
				continue;
			}
			tree[parent].add(node);
			tree[node].add(parent);
		}
		cut = Integer.parseInt(br.readLine());
		
		traversal(root, root);
		System.out.println(answer);
		
		
	}
	public static void traversal(int cur, int prev) {
		
		int leaves = 0;
		for (int i = 0; i < tree[cur].size(); i++) {
			int next = tree[cur].get(i);
			if (next == prev) continue;
			if (next == cut) continue;
			traversal(next, cur);
			leaves++;
		}
//		System.out.println("cur: " + cur + ", leaves: " + leaves);
		if (leaves == 0) answer++;
	}
}
