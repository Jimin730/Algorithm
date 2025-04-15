import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; //최소 횟수 저장
        int[] before = new int[N + 1]; //최소 경로 저장(역 추적)
        String str = "";

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {

            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
        }
        System.out.println(dp[N]);

        while (N > 0) {
            str += N + " ";
            N = before[N];
        }
        System.out.print(str);
    }
}