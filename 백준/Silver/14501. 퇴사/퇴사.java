import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 14501번
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; // 1일에 일한 돈은 2일차에 누적되기 때문에 n+1
        int[] T = new int[n]; //시간
        int[] P = new int[n]; //수익

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            if(i + T[i] <= n){ //현재 인덱스에서 시간을 더한 인덱스가 n일을 넘지 않으면
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]); // 다음dp = 현재 누적값 , 다음 누적 값 중 최대를 고른다
        }

        System.out.println(dp[n]);

    }
}
