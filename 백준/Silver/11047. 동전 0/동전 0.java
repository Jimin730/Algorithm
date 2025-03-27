import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11047
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int minCoin = 0;

        int[] coin = new int[N];

        for(int i=N-1; i>=0; i--){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<coin.length; i++){
            if(K-coin[i] >= 0){
                minCoin += K/coin[i];
                K %= coin[i];
            }
        }

        System.out.println(minCoin);

    }
}