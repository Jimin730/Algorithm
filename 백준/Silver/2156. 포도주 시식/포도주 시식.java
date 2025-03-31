import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 2156
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n+1];
        int[] wine = new int[n+1];

        for(int i=1; i<=n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        if(n>=1) drink[1] = wine[1];
        if(n>=2) drink[2] = wine[1] + wine[2];
        if(n>=3) drink[3] = Math.max(wine[1] + wine[2], Math.max(wine[1], wine[2]) + wine[3]);

        for(int i=4; i<=n; i++){
            drink[i] = Math.max(drink[i-1], Math.max(drink[i-2] + wine[i], drink[i-3] + wine[i-1] + wine[i]));
        }

        System.out.println(drink[n]);

    }
}