import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    static int numOfCmd;
    public static void main(String[] args) throws IOException {
        numOfCmd = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfCmd; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd) {
                case "push_back":
                    push();
                    break;
                case "pop_back":
                    pop();
                    break;
                case "get":
                    get();
                    break;
                case "size":
                    size();
                    break;
            }
        }
    }

    private static void push() {
        int v = Integer.parseInt(st.nextToken());
        list.add(v);
    }
    private static void pop() {
        list.remove(list.size() - 1);
    }
    private static void get() {
        int v = Integer.parseInt(st.nextToken());
        System.out.println(list.get(v-1));

    }
    private static void size() {
        System.out.println(list.size());
    }
}