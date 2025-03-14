import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 2748
public class Main {

    static int n;
    static long[] dp = new long[91];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }

    //탑 다운 방식 dp. 재귀 호출이지만 메모이제이션을 이용해 같은 계산은 한번만 한다.
    public static long fibonacci(int n){
        if(n<=1) return n;
        if(dp[n] != 0) return dp[n]; //메모이제이션
        else{
            dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return dp[n];
    }

}