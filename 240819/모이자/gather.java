import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] distance;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		distance = new int[N];
		for (int i = 0; i < N; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int home = i;
			int distanceSum = 0;
			
			for (int j = 0; j < N; j++) {
				distanceSum += Math.abs(home - j) * distance[j];
			}
			answer = Math.min(distanceSum, answer);
		}
		
		System.out.println(answer);
	}
}