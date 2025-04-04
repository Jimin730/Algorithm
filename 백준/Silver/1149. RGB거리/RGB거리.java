import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1149번
public class Main {

    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N][3]; // 행 : 집의 수, 열 : RGB
        cost = new int[N][3]; // 비용

        for(int i=0; i<N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 세팅
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(Math.min(painting(N-1,0),painting(N-1,1)), painting(N-1,2)));


    }

    public static int painting(int n, int color) {
        if(dp[n][color] == 0){
            if(color == 0) { // 빨강인 경우
                return dp[n][color] = Math.min(painting(n - 1, 1), painting(n - 1, 2)) + cost[n][color];
            } else if (color == 1) { // 초록인 경우
                return dp[n][color] = Math.min(painting(n - 1, 0), painting(n - 1, 2)) + cost[n][color];
            } else if (color == 2) { // 파랑인 경우
                return dp[n][color] = Math.min(painting(n - 1, 0), painting(n - 1, 1)) + cost[n][color];
            }
        }
        
        // 이미 계산 되어 있는 경우
        return dp[n][color];
    }
}