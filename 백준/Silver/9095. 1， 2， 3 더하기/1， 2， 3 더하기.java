import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 9095
public class Main {

    static int[] dp = new int[11];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            sb.append(recurDp(n)).append("\n"); //결과 저장
        }

        System.out.println(sb.toString()); //결과 출력
    }

    public static int recurDp(int n){

        if(n==0) return 1;
        if(n<0) return 0;

        if(dp[n] != 0) return dp[n];

        dp[n] = recurDp(n-1) + recurDp(n-2) + recurDp(n-3);

        return dp[n];
    }
}