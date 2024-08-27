import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String cmd = st.nextToken();
        	if (cmd.equals("add")) {
        		int k = Integer.parseInt(st.nextToken());
        		int v = Integer.parseInt(st.nextToken());
        		map.put(k, v);
        	} else if (cmd.equals("find")) {
        		int f = Integer.parseInt(st.nextToken());
        		if (map.containsKey(f)) {
        			sb.append(map.get(f)).append("\n");
        		} else {
        			sb.append("None").append("\n");
        		}
        	} else if (cmd.equals("remove")) {
        		int r = Integer.parseInt(st.nextToken());
        		map.remove(r);
        	}
		}
        System.out.println(sb);
        
    }
	
}