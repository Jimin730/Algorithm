import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i]는 i번째 숫자를 포함했을 때의 최댓값
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            // (이전까지의 연속합 + 현재 숫자) vs (현재 숫자부터 새로 시작)
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            
            // 전체 최댓값 갱신
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}