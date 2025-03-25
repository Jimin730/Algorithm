import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 1788
public class Main {

    static int[] dp;
    static final int mod = 1_000_000_000; //가독성을 위해 숫자 리터럴에 언더스코어 사용

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n>0){
            System.out.println(1);
        } else if(n<0){
            n = -n;
            if(n%2 == 0){ //짝수면 음수. -1
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        } else {
            System.out.println(0);
        }

        dp = new int[1_000_001];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2])%mod;
        }

        System.out.println(dp[n]);

    }
}