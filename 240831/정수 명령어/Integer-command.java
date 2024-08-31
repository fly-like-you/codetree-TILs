import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, K;
    static TreeSet<Integer> s = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        // 중복으로 삽입되는 경우는 주어지지않음
        // 큐가 비어있는데 삭제 연산이 들어오면 연산은 무시됨
        // 최종적으로 큐에 저장된 데이터의 최댓값과 최솟값을 출력하기
        T = Integer.parseInt(br.readLine());
        

        for (int t = 0; t < T; t++){
            K = Integer.parseInt(br.readLine());
            s.clear();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int target = Integer.parseInt(st.nextToken());

                switch(cmd) {
                    case "I": 
                        s.add(target);
                    break;
                    case "D": 
                        if (s.isEmpty()) continue;
                        if (target == 1) s.remove(s.last());
                        else s.remove(s.first());
                            
                        
                    break;
                }
            }

            if (s.isEmpty()) {
                System.out.println("EMPTY");    
            } else {
                System.out.println(s.last() + " " + s.first());
            }
        }
    }
}