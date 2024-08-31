import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
add x : 숫자 x를 treeset에 추가합니다. 중복되는 경우 무시합니다.
remove x : 숫자 x를 treeset에서 제거합니다. 잘못된 입력은 주어지지 않습니다.
find x : 숫자 x가 treeset에 있는지를 판단합니다. 있다면 true, 없다면 false를 출력합니다.
lower_bound x : treeset에서 x보다 같거나 큰 최초의 숫자를 출력합니다. 만약 없다면 None을 출력합니다.
upper_bound x : treeset에서 x보다 큰 최초의 숫자를 출력합니다. 만약 없다면 None을 출력합니다.
largest : treeset에서 가장 큰 숫자를 출력합니다. 만약 treeset이 비어있다면 None을 출력합니다.
smallest : treeset에서 가장 작은 숫자를 출력합니다. 만약 treeset이 비어있다면 None을 출력합니다.
* */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            query(cmd, st);
        }
    }

    static TreeSet<Integer> s = new TreeSet<>();
    private static void query(String cmd, StringTokenizer st) {
        int target;
        String answer;
        switch (cmd) {
            case "largest":
                answer = !s.isEmpty() ? String.valueOf(s.last()) : "None";
                System.out.println(answer); break;
            case "smallest":
                answer = !s.isEmpty() ? String.valueOf(s.first()) : "None";
                System.out.println(answer); break;
            case "add":
                target = Integer.parseInt(st.nextToken()); s.add(target); break;
            case "remove":
                target = Integer.parseInt(st.nextToken());
                s.remove(target); break;
            case "find":
                target = Integer.parseInt(st.nextToken());
                answer = s.contains(target) ? "true" : "false";
                System.out.println(answer);
            break;
            case "lower_bound":
                target = Integer.parseInt(st.nextToken());
                answer = s.ceiling(target) != null ? String.valueOf(s.ceiling(target)) : "None";
                System.out.println(answer);
                break;
            case "upper_bound":
                target = Integer.parseInt(st.nextToken());
                answer = s.ceiling(target+1) != null ? String.valueOf(s.ceiling(target+1)) : "None";
                System.out.println(answer);
                break;

        }
    }

}