import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 9657
public class Main {

    static final int MAX_NUM = 1001;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[MAX_NUM];

        //dp[n] 돌이 n개 있을 경우 현재 플레이어가 이길 수 있는 경우가 있을 떄 = 1, 없을 떄 = 0
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        for(int i=5; i<=N; i++){
            //현재 플레이어가 돌을 1,3,4 각각 가져갔을 때 상대 입장에서 이길 수 없는 경우가 1개라도 있으면 현재 플레이어가 이길 수 있는 경우가 나온다.
            if(dp[i-1] == 0 || dp[i-3] == 0 || dp[i-4] == 0)
                dp[i] = 1; //이길 수 있는 경우
            else
                dp[i] = 0; //지는 경우
        }

        if(dp[N] == 1){
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}